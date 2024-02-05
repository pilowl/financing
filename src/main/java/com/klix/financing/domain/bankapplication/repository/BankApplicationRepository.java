package com.klix.financing.domain.bankapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.klix.financing.domain.bankapplication.repository.entity.BankApplication;
import com.klix.financing.domain.bankapplication.repository.entity.Status;

import java.util.List;


@Repository
public interface BankApplicationRepository extends JpaRepository<BankApplication, Integer> {

    @Modifying
    @Query(value = "UPDATE bank_applications SET status = :status WHERE id = :bank_application_id", nativeQuery = true)
    void setBankApplicationStatus(@Param("bank_application_id") Integer bankApplicationID, @Param("status") String newStatus);

    @Modifying
    @Query(value = "UPDATE bank_applications SET external_uuid = :external_uuid WHERE id = :bank_application_id", nativeQuery = true)
    void setBankApplicationExternalUUID(@Param("bank_application_id") Integer bankApplicationID, @Param("external_uuid") String externalUUID); 

    List<BankApplication> findByStatus(Status status);    
}
