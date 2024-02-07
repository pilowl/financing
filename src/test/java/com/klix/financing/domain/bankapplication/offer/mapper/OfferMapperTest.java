package com.klix.financing.domain.bankapplication.offer.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.klix.financing.domain.bankapplication.offer.model.OfferDetails;
import com.klix.financing.domain.bankapplication.offer.repository.entity.Offer;

public class OfferMapperTest {
    
    @DisplayName("Offer Details to Offer entity mapper test")
    @Test
    void testMapOfferDetailsToOffer() {
        OfferDetails offerDetails = new OfferDetails();
        offerDetails.setFirstRepaymentDate(LocalDate.parse("2024-01-01"));
        offerDetails.setMonthlyPaymentAmount(9.99);
        offerDetails.setNumberOfPayments(10);
        offerDetails.setTotalRepaymentAmount(99.90);
        
        Offer offer = OfferMapper.INSTANCE.mapOfferDetailsToOffer(offerDetails);

        assertEquals(offerDetails.getFirstRepaymentDate(), offer.getFirstRepaymentDate().toLocalDate());
        assertEquals(offerDetails.getMonthlyPaymentAmount(), offer.getMonthlyPaymentAmount());
        assertEquals(offerDetails.getNumberOfPayments(), offer.getNumberOfPayments());
        assertEquals(offerDetails.getTotalRepaymentAmount(), offer.getTotalRepaymentAmount());
    }
}
