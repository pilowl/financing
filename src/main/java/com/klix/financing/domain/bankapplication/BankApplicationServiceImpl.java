package com.klix.financing.domain.bankapplication;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.klix.financing.domain.application.model.ApplicationDetails;
import com.klix.financing.domain.application.repository.ApplicationRepository;
import com.klix.financing.domain.application.repository.entity.Application;
import com.klix.financing.domain.bankapplication.mapper.BankApplicationMapper;
import com.klix.financing.domain.bankapplication.model.BankName;
import com.klix.financing.domain.bankapplication.offer.mapper.OfferMapper;
import com.klix.financing.domain.bankapplication.offer.model.OfferDetails;
import com.klix.financing.domain.bankapplication.offer.repository.OfferRepository;
import com.klix.financing.domain.bankapplication.offer.repository.entity.Offer;
import com.klix.financing.domain.bankapplication.repository.BankApplicationRepository;
import com.klix.financing.domain.bankapplication.repository.entity.Bank;
import com.klix.financing.domain.bankapplication.repository.entity.BankApplication;
import com.klix.financing.domain.bankapplication.repository.entity.Status;
import com.klix.financing.infrastructure.logger.Slf4jLogger;

@Service
public class BankApplicationServiceImpl implements BankApplicationService {

    private final Logger logger = Slf4jLogger.getLogger(this.getClass());

    private final List<BankClient> bankClients;
    private final HashMap<BankName, BankClient> bankClientIndex;

    private final ApplicationRepository applicationRespository;
    private final BankApplicationRepository bankApplicationRepository;
    private final OfferRepository offerRepository;

    private final BankApplicationMapper bankApplicationMapper;
    private final OfferMapper offerMapper;
    

    public BankApplicationServiceImpl(List<BankClient> bankClients,
        ApplicationRepository applicationRepository,
        BankApplicationRepository bankApplicationRepository,
        OfferRepository offerRepository,
        BankApplicationMapper bankApplicationMapper,
        OfferMapper offerMapper
    ) {
        this.bankClients = bankClients;
        this.applicationRespository = applicationRepository;
        this.bankApplicationRepository = bankApplicationRepository;
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
        this.bankApplicationMapper = bankApplicationMapper;
        this.bankClientIndex = new HashMap<BankName, BankClient>();
        for (BankClient bc : bankClients) {
            this.bankClientIndex.put(bc.getName(), bc);
        }
    }

    public void spreadApplication(ApplicationDetails applicationDetails) {
        Application application = applicationRespository.findByUuid(applicationDetails.getUuid());

        for (BankClient client : bankClients) {
            BankApplication newBankApplication = BankApplication.builder()
                .setBankName(Bank.valueOf(client.getName().name()))
                .setStatus(Status.NONE)
                .setApplication(application).build();

            newBankApplication = bankApplicationRepository.save(newBankApplication);

            client.sendApplication(newBankApplication.getId(), applicationDetails);
        }
    }

    @Override
    public void updateBankApplicationStatus(Integer bankApplicationID, String newStatus) {
        bankApplicationRepository.setBankApplicationStatus(bankApplicationID, newStatus);
    }

    @Override
    public void setBankApplicationExternalUUID(Integer bankApplicationID, String uuid) {
        bankApplicationRepository.setBankApplicationExternalUUID(bankApplicationID, uuid);
    }

    @Override
    public void addBankApplicationOffer(Integer bankApplicationID, OfferDetails offerDetails) {
        Optional<BankApplication> bankApplication = bankApplicationRepository.findById(bankApplicationID);
        if (!bankApplication.isPresent()) {
            logger.error("Failed to find bank application by id while adding offer (BankApplicationID: %d)", bankApplicationID);
            return;
        }
        
        Offer newOffer = offerMapper.mapOfferDetailsToOffer(offerDetails);
        newOffer.setApplication(bankApplication.get());
        
        offerRepository.save(newOffer);
    }

    public void revisitDraftApplications() {
        List<BankApplication> draftBankApplications = bankApplicationRepository.findByStatus(Status.DRAFT);

        for (BankApplication application: draftBankApplications) {
            BankClient bankClient = bankClientIndex.get(bankApplicationMapper.mapBankEntityToBankName(application.getBankName()));
            bankClient.getApplication(application.getId(), application.getExternalUUID(), application.getStatus().toString());
        }
    }
}
