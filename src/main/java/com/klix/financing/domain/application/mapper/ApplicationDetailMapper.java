package com.klix.financing.domain.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.klix.financing.domain.application.model.ApplicationDetails;
import com.klix.financing.domain.application.model.ApplicationWithOrders;
import com.klix.financing.domain.application.repository.entity.Application;

@Mapper(componentModel = "spring")
public interface ApplicationDetailMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "bankApplications", ignore = true)
    Application mapApplicationDetailsToApplication(ApplicationDetails applicationDetails);

    List<ApplicationDetails> mapApplicationsToApplicationDetails(List<Application> application);

    ApplicationWithOrders mapApplicationToApplicationWithOffers(Application application);
}
