package com.tmu.amic.repository;

import com.tmu.amic.model.ClientPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientPartnerRepository extends JpaRepository<ClientPartner, Long> {
}