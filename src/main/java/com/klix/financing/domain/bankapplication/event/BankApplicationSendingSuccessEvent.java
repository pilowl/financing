package com.klix.financing.domain.bankapplication.event;

import org.springframework.context.ApplicationEvent;

import com.klix.financing.domain.bankapplication.offer.model.OfferDetails;

public class BankApplicationSendingSuccessEvent extends ApplicationEvent {
    private Integer bankApplicationID;
    private String externalID;
    private String status;
    private OfferDetails offerDetails;

    public BankApplicationSendingSuccessEvent(Object source, Integer bankApplicationID, String externalID, String status, OfferDetails offerDetails) {
        super(source);
        this.bankApplicationID = bankApplicationID;
        this.externalID = externalID;
        this.status = status;
        this.offerDetails = offerDetails;
    }

    public Integer getBankApplicationID() {
        return this.bankApplicationID;
    }

    public String getExternalID() {
        return this.externalID;
    }

    public String getStatus() {
        return this.status;
    }

    public OfferDetails getOfferDetails() {
        return this.offerDetails;
    }
    
}
