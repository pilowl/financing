package com.klix.financing.domain.bankapplication.integration.solidbank.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.klix.financing.domain.application.model.ApplicationDetails;
import com.klix.financing.domain.bankapplication.integration.solidbank.dto.CreateApplicationRequest;
import com.klix.financing.domain.bankapplication.integration.solidbank.dto.OfferResponse;
import com.klix.financing.domain.bankapplication.offer.model.OfferDetails;


@Mapper(componentModel = "spring")
public interface SolidBankRequestMapper {
    
    @Mapping(source = "monthlyIncomeAmount", target = "monthlyIncome")
    CreateApplicationRequest mapBankApplicationDetailsToCreateApplicationRequest(ApplicationDetails details);

    OfferDetails mapBankApplicationOfferResponseToOfferDetails(OfferResponse response);
}
