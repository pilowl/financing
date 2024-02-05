package com.klix.financing.domain.bankapplication.integration.fastbank.mapper;

import org.mapstruct.Mapper;

import com.klix.financing.domain.application.model.ApplicationDetails;
import com.klix.financing.domain.bankapplication.integration.fastbank.dto.CreateApplicationRequest;
import com.klix.financing.domain.bankapplication.integration.fastbank.dto.OfferResponse;
import com.klix.financing.domain.bankapplication.offer.model.OfferDetails;

@Mapper(componentModel = "spring")
public interface FastBankRequestMapper {
    CreateApplicationRequest mapBankApplicationDetailsToCreateApplicationRequest(ApplicationDetails applicationDetails);

    OfferDetails mapBankApplicationOfferResponseToOfferDetails(OfferResponse response);
}
