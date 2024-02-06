package com.klix.financing.domain.bankapplication.offer;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.klix.financing.domain.bankapplication.offer.mapper.OfferMapper;
import com.klix.financing.domain.bankapplication.offer.model.OfferDetails;
import com.klix.financing.domain.bankapplication.offer.repository.OfferRepository;
import com.klix.financing.domain.bankapplication.offer.repository.entity.Offer;
import com.klix.financing.domain.bankapplication.repository.BankApplicationRepository;
import com.klix.financing.domain.bankapplication.repository.entity.BankApplication;
import com.klix.financing.infrastructure.logger.Slf4jLogger;

@Service
public class OfferServiceImpl implements OfferService {

    private final Logger logger = Slf4jLogger.getLogger(this.getClass());

    private final OfferMapper offerMapper;
    private final OfferRepository offerRepository;

    private final BankApplicationRepository bankApplicationRepository;

    public OfferServiceImpl(OfferMapper offerMapper, OfferRepository offerRepository, BankApplicationRepository bankApplicationRepository) {
        this.offerMapper = offerMapper;
        this.offerRepository = offerRepository;
        this.bankApplicationRepository = bankApplicationRepository;
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

}
