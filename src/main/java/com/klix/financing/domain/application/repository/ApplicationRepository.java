package com.klix.financing.domain.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klix.financing.domain.application.repository.entity.Application;
import java.util.UUID;


@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    Application findByUuid(UUID uuid);
}
