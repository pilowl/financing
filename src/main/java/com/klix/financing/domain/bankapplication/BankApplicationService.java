package com.klix.financing.domain.bankapplication;

import com.klix.financing.domain.application.model.ApplicationDetails;
import com.klix.financing.domain.bankapplication.offer.model.OfferDetails;

public interface BankApplicationService {
    void spreadApplication(ApplicationDetails application);
    void updateBankApplicationStatus(Integer bankApplicationID, String newStatus);
    void setBankApplicationExternalUUID(Integer bankApplicationID, String uuid);
    void addBankApplicationOffer(Integer bankApplicationID, OfferDetails offerDetails);
    void revisitDraftApplications();
}
