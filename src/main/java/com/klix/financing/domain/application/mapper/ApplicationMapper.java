package com.klix.financing.domain.application.mapper;

import java.util.Set;
import java.util.List;
import java.util.LinkedList;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.klix.financing.domain.application.model.ApplicationDetails;
import com.klix.financing.domain.application.model.ApplicationWithOffers;
import com.klix.financing.domain.application.model.Offer;
import com.klix.financing.domain.application.repository.entity.Application;
import com.klix.financing.domain.bankapplication.repository.entity.BankApplication;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "bankApplications", ignore = true)
    Application mapApplicationDetailsToApplication(ApplicationDetails applicationDetails);

    List<ApplicationDetails> mapApplicationsToApplicationDetails(List<Application> application);

    @Mapping(source = "bankApplications", target = "offers", qualifiedByName = "extractBankApplicationOffers")
    ApplicationWithOffers mapApplicationToApplicationWithOffers(Application application);

    @Named("extractBankApplicationOffers")    
    public static List<Offer> extractBankApplicationOffers(Set<BankApplication> bankApplications) {
        List<Offer> offers = new LinkedList<Offer>();
        
        for (BankApplication bankApplication : bankApplications) {
            if (bankApplication.getOffer() != null) {
                Offer newOffer = new Offer();
                newOffer.setBankName(bankApplication.getBankName().name());
                newOffer.setFirstRepayment(bankApplication.getOffer().getFirstRepaymentDate());
                newOffer.setMonthlyPayment(bankApplication.getOffer().getMonthlyPaymentAmount());
                newOffer.setTotalRepayment(bankApplication.getOffer().getTotalRepaymentAmount());
                newOffer.setPaymentAmount(bankApplication.getOffer().getNumberOfPayments());

                offers.add(newOffer);
            };
        }

        return offers;
    }
}
