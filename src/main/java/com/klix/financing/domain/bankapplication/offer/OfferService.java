package com.klix.financing.domain.bankapplication.offer;

import com.klix.financing.domain.bankapplication.offer.model.OfferDetails;

public interface OfferService {
    void addBankApplicationOffer(Integer bankApplicationID, OfferDetails offerDetails);
}
