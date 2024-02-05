package com.klix.financing.domain.bankapplication.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.klix.financing.domain.bankapplication.BankApplicationService;
import com.klix.financing.domain.bankapplication.repository.entity.Status;

import jakarta.transaction.Transactional;

@Component
public class BankApplicationListener {

    private final BankApplicationService bankApplicationService;

    public BankApplicationListener(BankApplicationService bankApplicationService) {
        this.bankApplicationService = bankApplicationService;
    }

    @EventListener
    @Transactional
    public void handleBankApplicationSendingSuccess(BankApplicationSendingSuccessEvent event) {
        bankApplicationService.updateBankApplicationStatus(event.getBankApplicationID(), event.getStatus());
        bankApplicationService.setBankApplicationExternalUUID(event.getBankApplicationID(), event.getExternalID());
        if (event.getOfferDetails() != null) {
            bankApplicationService.addBankApplicationOffer(event.getBankApplicationID(), event.getOfferDetails());
        }
    } 

    @EventListener
    public void handleBankApplicationSendingFail(BankApplicationSendingFailedEvent event) {
        bankApplicationService.updateBankApplicationStatus(event.getBankApplicationID(), Status.FAILED.name());
    }
}
