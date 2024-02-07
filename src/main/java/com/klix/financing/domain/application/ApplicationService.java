package com.klix.financing.domain.application;

import java.util.UUID;

import com.klix.financing.domain.application.model.ApplicationDetails;
import com.klix.financing.domain.application.model.ApplicationWithOffers;

public interface ApplicationService {
    UUID PostApplication(ApplicationDetails application); 
    ApplicationWithOffers GetApplicationByUUID(String uuid);
}
