package com.klix.financing.domain.bankapplication.offer;

import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.klix.financing.domain.bankapplication.offer.mapper.OfferMapper;
import com.klix.financing.domain.bankapplication.offer.model.OfferDetails;
import com.klix.financing.domain.bankapplication.offer.repository.OfferRepository;
import com.klix.financing.domain.bankapplication.offer.repository.entity.Offer;
import com.klix.financing.domain.bankapplication.repository.BankApplicationRepository;
import com.klix.financing.domain.bankapplication.repository.entity.BankApplication;

@ExtendWith(MockitoExtension.class)
public class OfferServiceImplTest {

    @Mock
    private OfferMapper offerMapper;

    @Mock
    private OfferRepository offerRepository;

    @Mock
    private BankApplicationRepository bankApplicationRepository;

    @InjectMocks
    private OfferServiceImpl offerService;

    @Test
    void testAddBankApplicationOffer_BankApplicationNotFound() {
        Integer bankApplicationID = 404;
        OfferDetails offerDetails = new OfferDetails();

        when(bankApplicationRepository.findById(bankApplicationID))
            .thenReturn(Optional.empty());

        offerService.addBankApplicationOffer(bankApplicationID, offerDetails);
    }

    @Test
    void testAddBankApplicationOffer_Success() {
        Integer bankApplicationID = 42;
        OfferDetails offerDetails = new OfferDetails();

        BankApplication offersBankApplication = new BankApplication();
        offersBankApplication.setId(42);
        Offer mappedOffer = new Offer();

        when(bankApplicationRepository.findById(bankApplicationID))
            .thenReturn(Optional.of(offersBankApplication));
        when(offerMapper.mapOfferDetailsToOffer(offerDetails)).thenReturn(mappedOffer);

        mappedOffer.setBankApplication(offersBankApplication);

        when(offerRepository.save(mappedOffer))
            .thenReturn(mappedOffer);

        offerService.addBankApplicationOffer(bankApplicationID, offerDetails);
    }
}
