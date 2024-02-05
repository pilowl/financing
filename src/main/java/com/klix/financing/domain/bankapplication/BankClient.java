package com.klix.financing.domain.bankapplication;

import com.klix.financing.domain.application.model.ApplicationDetails;
import com.klix.financing.domain.bankapplication.model.BankName;

public interface BankClient {  
     BankName getName();
     void sendApplication(Integer bankApplicationID, ApplicationDetails application);
     void getApplication(Integer bankApplicationID, String applicationExternalUUID, String oldStatus);
}
