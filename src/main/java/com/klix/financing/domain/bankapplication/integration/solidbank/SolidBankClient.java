package com.klix.financing.domain.bankapplication.integration.solidbank;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;

import com.klix.financing.domain.application.model.ApplicationDetails;
import com.klix.financing.domain.bankapplication.BankClient;
import com.klix.financing.domain.bankapplication.event.BankApplicationSendingFailedEvent;
import com.klix.financing.domain.bankapplication.event.BankApplicationSendingSuccessEvent;
import com.klix.financing.domain.bankapplication.integration.solidbank.dto.ApplicationResponse;
import com.klix.financing.domain.bankapplication.integration.solidbank.dto.CreateApplicationRequest;
import com.klix.financing.domain.bankapplication.integration.solidbank.mapper.SolidBankRequestMapper;
import com.klix.financing.domain.bankapplication.model.BankName;
import com.klix.financing.infrastructure.exceptions.WebClientRequestError;
import com.klix.financing.infrastructure.logger.Slf4jLogger;
import com.klix.financing.infrastructure.web.DefaultWebClient;

import reactor.core.publisher.Mono;

@Component
@ConditionalOnProperty(
  value="integrations.solidbank.enabled", 
  havingValue = "true", 
  matchIfMissing = false)
public class SolidBankClient implements BankClient {
   
    @Value("${integrations.solidbank.base}")
    private String baseURL; 
    
    private final ApplicationEventPublisher eventPublisher;

    private final SolidBankRequestMapper requestMapper;

    private final WebClient webClient;

    public SolidBankClient(@Value("${integrations.solidbank.base}") String baseURL, SolidBankRequestMapper requestMapper, ApplicationEventPublisher eventPublisher) {
        this.requestMapper = requestMapper;
        this.eventPublisher = eventPublisher;
        this.webClient = DefaultWebClient.build(baseURL);
    }

    @Override
    public BankName getName() {
        return BankName.SOLID_BANK;
    }

    @Override
    @Async
    public void sendApplication(Integer bankApplicationID, ApplicationDetails application) {
        CreateApplicationRequest requestBody = requestMapper.mapBankApplicationDetailsToCreateApplicationRequest(application);
        UriSpec<RequestBodySpec> uriSpec = webClient.method(HttpMethod.POST);
        RequestBodySpec bodySpec = uriSpec.uri("/applications");
        RequestHeadersSpec<?> headersSpec = bodySpec
            .body(Mono.just(requestBody), CreateApplicationRequest.class)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
            .ifNoneMatch("*");

        headersSpec.exchangeToMono(res -> {
            if (res.statusCode().equals(HttpStatus.CREATED)) {
                return res.bodyToMono(ApplicationResponse.class);
            }

            return Mono.error(new WebClientRequestError(requestBody, res.bodyToMono(String.class), res.statusCode().toString(), "Request to FastBank failed"));
        })
        .onErrorResume(WebClientRequestError.class, err -> {
            eventPublisher.publishEvent(new BankApplicationSendingFailedEvent(this, bankApplicationID));
            return Mono.empty();
        })
        .subscribe(resp -> eventPublisher.publishEvent(new BankApplicationSendingSuccessEvent(this, 
        bankApplicationID, resp.getId(), resp.getStatus(), requestMapper.mapBankApplicationOfferResponseToOfferDetails(resp.getOffer()))));
    }

    @Override
    @Async
    public void getApplication(Integer bankApplicationID, String applicationExternalUUID, String oldStatus) {
        UriSpec<RequestBodySpec> uriSpec = webClient.method(HttpMethod.GET);
        RequestBodySpec bodySpec = uriSpec.uri("/applications/" + applicationExternalUUID);
        RequestHeadersSpec<?> headersSpec = bodySpec
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .ifNoneMatch("*");
      
        headersSpec.exchangeToMono(res -> {
            if (res.statusCode().equals(HttpStatus.OK)) {
                return res.bodyToMono(ApplicationResponse.class);
            }

            return Mono.error(new WebClientRequestError(null, res.bodyToMono(String.class), res.statusCode().toString(), "Get Request to FastBank failed"));
        }).onErrorResume(WebClientRequestError.class, err -> {
            eventPublisher.publishEvent(new BankApplicationSendingFailedEvent(this, bankApplicationID));
            return Mono.empty();
        })
        .subscribe(resp -> {
                if (!oldStatus.equals(resp.getStatus())) {
                    eventPublisher.publishEvent(new BankApplicationSendingSuccessEvent(this, bankApplicationID, resp.getId(), resp.getStatus(), requestMapper.mapBankApplicationOfferResponseToOfferDetails(resp.getOffer())));
                }
            }
        );
    }
}
