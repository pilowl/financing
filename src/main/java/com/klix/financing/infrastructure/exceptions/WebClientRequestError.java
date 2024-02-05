package com.klix.financing.infrastructure.exceptions;

import reactor.core.publisher.Mono;

public class WebClientRequestError extends Throwable {
    
    private Object request;

    private Mono<String> response;

    private String statusCode;

    private String message;

    public WebClientRequestError(Object request, Mono<String> response, String statusCode, String message) {
        this.request = request;
        this.response = response;
        this.statusCode = statusCode;
        this.message = message;
    }

    public Object getRequest() {
        return request;
    }

    public Mono<String> getResponse() {
        return response;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "WebClientRequestError [request=" + request + ", response=" + response + ", statusCode=" + statusCode
                + ", message=" + message + "]";
    }
}
