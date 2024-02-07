package com.klix.financing.domain.application.rest;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klix.financing.domain.application.ApplicationService;
import com.klix.financing.domain.application.model.ApplicationWithOffers;
import com.klix.financing.domain.application.rest.dto.CreateApplicationRequest;
import com.klix.financing.domain.application.rest.dto.CreateApplicationResponse;
import com.klix.financing.domain.application.rest.dto.GetApplicationResponse;
import com.klix.financing.domain.application.rest.mapper.ApplicationRequestMapper;
import com.klix.financing.infrastructure.errors.FieldValidationError;
import com.klix.financing.infrastructure.errors.GenericRequestError;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/application")
public class ApplicationController {

    private final ApplicationService applicationService;
    
    private final ApplicationRequestMapper applicationRequestMapper;
   
    public ApplicationController(ApplicationService applicationService, ApplicationRequestMapper applicationRequestMapper) {
        this.applicationService = applicationService;
        this.applicationRequestMapper = applicationRequestMapper;
    }

    @PostMapping
    public ResponseEntity<?> createApplication(@RequestBody @Valid CreateApplicationRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(FieldValidationError.fromObjectErrors("There are some validation errors", bindingResult.getAllErrors()));
        }

        UUID uuid = applicationService.PostApplication(applicationRequestMapper.mapCreateApplicationRequestToApplicationDetails(request));
        return new ResponseEntity<>(new CreateApplicationResponse(uuid), HttpStatus.CREATED);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<GetApplicationResponse> getMethodName(@PathVariable String uuid) {
        ApplicationWithOffers applicationWithOffers = applicationService.GetApplicationByUUID(uuid);
        if (applicationWithOffers == null) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(applicationRequestMapper.mapApplicationWithOffersToGetApplicationResponse(applicationWithOffers), HttpStatus.OK);
    }
}