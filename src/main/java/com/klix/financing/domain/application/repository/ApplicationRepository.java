package com.klix.financing.domain.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.klix.financing.domain.application.repository.entity.Application;
import java.util.UUID;


@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    Application findApplicationByUuid(@Param("uuid") UUID uuid);

    @Query("FROM Application as a LEFT JOIN FETCH a.bankApplications as ba LEFT JOIN FETCH ba.offer WHERE a.uuid = :uuid")
    Optional<Application> findApplicationWithBankApplicaitonOfferByUuid(@Param("uuid") UUID uuid);
}
