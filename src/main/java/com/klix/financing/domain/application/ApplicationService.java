package com.klix.financing.domain.application;

import java.util.UUID;

import com.klix.financing.domain.application.model.ApplicationDetails;
import com.klix.financing.domain.application.model.ApplicationWithOrders;

public interface ApplicationService {
    UUID PostApplication(ApplicationDetails application); 
    ApplicationWithOrders GetApplicationByUUID(String uuid);
}
