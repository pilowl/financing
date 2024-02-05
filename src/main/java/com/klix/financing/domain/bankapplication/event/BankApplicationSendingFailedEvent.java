package com.klix.financing.domain.bankapplication.event;

import org.springframework.context.ApplicationEvent;

public class BankApplicationSendingFailedEvent extends ApplicationEvent {

    private Integer bankApplicationID;

    public BankApplicationSendingFailedEvent(Object source, Integer bankApplicationID) {
        super(source);
        this.bankApplicationID = bankApplicationID;
    }

    public Integer getBankApplicationID() {
        return bankApplicationID;
    }
    
}
