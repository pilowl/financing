package com.klix.financing.domain.application.model;

import java.util.List;

public class ApplicationWithOrders extends ApplicationDetails {
    private List<Offer> offers;

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
