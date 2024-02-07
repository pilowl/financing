package com.klix.financing.domain.bankapplication.offer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.klix.financing.domain.bankapplication.offer.model.OfferDetails;
import com.klix.financing.domain.bankapplication.offer.repository.entity.Offer;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    @Mapping(target = "bankApplication", ignore = true)
    Offer mapOfferDetailsToOffer(OfferDetails offerDetails);
}
