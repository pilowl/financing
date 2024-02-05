package com.klix.financing.domain.application.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.klix.financing.domain.application.model.ApplicationDetails;
import com.klix.financing.domain.application.model.ApplicationWithOrders;
import com.klix.financing.domain.application.rest.dto.CreateApplicationRequest;
import com.klix.financing.domain.application.rest.dto.GetApplicationResponse;

@Mapper(componentModel = "spring")
public interface ApplicationRequestMapper {

    @Mapping(target = "uuid", ignore = true)
    ApplicationDetails mapCreateApplicationRequestToApplicationDetails(CreateApplicationRequest request);

    GetApplicationResponse mapApplicationWithOrderToGetApplicationResponse(ApplicationWithOrders applicationWithOrders);
}
