package com.klix.financing.domain.application;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.klix.financing.domain.application.mapper.ApplicationDetailMapper;
import com.klix.financing.domain.application.model.ApplicationDetails;
import com.klix.financing.domain.application.model.ApplicationWithOrders;
import com.klix.financing.domain.application.repository.ApplicationRepository;
import com.klix.financing.domain.application.repository.entity.Application;
import com.klix.financing.domain.bankapplication.BankApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final BankApplicationService bankApplicationService;

    private final ApplicationDetailMapper applicationDetailMapper;
    
    public ApplicationServiceImpl(
        ApplicationDetailMapper applicationDetailMapper,
        ApplicationRepository applicationRepository,
        BankApplicationService bankApplicationService
    ) {
        this.applicationDetailMapper = applicationDetailMapper;
        this.applicationRepository = applicationRepository;
        this.bankApplicationService = bankApplicationService;
    }

    @Override
    public UUID PostApplication(ApplicationDetails applicationDetails) {
        UUID applicationUUID = UUID.randomUUID();  
        applicationDetails.setUuid(applicationUUID);

        Application application = applicationDetailMapper.mapApplicationDetailsToApplication(applicationDetails);

        application = applicationRepository.save(application);

        bankApplicationService.spreadApplication(applicationDetails);

        return applicationUUID;
    }

    @Override
    public ApplicationWithOrders GetApplicationByUUID(String uuid) {
        Application applicationWithOrders = applicationRepository.findByUuid(UUID.fromString(uuid));
        return applicationDetailMapper.mapApplicationToApplicationWithOffers(applicationWithOrders);
    }
}
