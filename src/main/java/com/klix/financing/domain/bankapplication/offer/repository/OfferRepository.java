package com.klix.financing.domain.bankapplication.offer.repository;

import org.springframework.stereotype.Repository;

import com.klix.financing.domain.bankapplication.offer.repository.entity.Offer;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer>{
}
