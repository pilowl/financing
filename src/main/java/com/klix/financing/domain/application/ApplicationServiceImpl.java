package com.klix.financing.domain.application;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.klix.financing.domain.application.mapper.ApplicationMapper;
import com.klix.financing.domain.application.model.ApplicationDetails;
import com.klix.financing.domain.application.model.ApplicationWithOffers;
import com.klix.financing.domain.application.repository.ApplicationRepository;
import com.klix.financing.domain.application.repository.entity.Application;
import com.klix.financing.domain.bankapplication.BankApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final BankApplicationService bankApplicationService;

    private final ApplicationMapper applicationMapper;
    
    public ApplicationServiceImpl(
        ApplicationMapper applicationDetailMapper,
        ApplicationRepository applicationRepository,
        BankApplicationService bankApplicationService
    ) {
        this.applicationMapper = applicationDetailMapper;
        this.applicationRepository = applicationRepository;
        this.bankApplicationService = bankApplicationService;
    }

    @Override
    public UUID PostApplication(ApplicationDetails applicationDetails) {
        UUID applicationUUID = UUID.randomUUID();  
        applicationDetails.setUuid(applicationUUID);

        Application application = applicationMapper.mapApplicationDetailsToApplication(applicationDetails);

        application = applicationRepository.save(application);

        bankApplicationService.spreadApplication(applicationDetails);

        return applicationUUID;
    }

    @Override
    public ApplicationWithOffers GetApplicationByUUID(String uuid) {
        Optional<Application> application = applicationRepository.findApplicationWithBankApplicaitonOfferByUuid(UUID.fromString(uuid));
        return applicationMapper.mapApplicationToApplicationWithOffers(application.get());
    }
}
