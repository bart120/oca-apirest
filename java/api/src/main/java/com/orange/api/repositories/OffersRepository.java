package com.orange.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orange.api.models.Offer;

public interface OffersRepository extends JpaRepository<Offer, Long> {

}
