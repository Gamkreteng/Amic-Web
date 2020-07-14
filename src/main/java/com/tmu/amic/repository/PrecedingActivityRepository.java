package com.tmu.amic.repository;

import com.tmu.amic.model.PrecedingActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PrecedingActivityRepository extends JpaRepository<PrecedingActivity, Long> {
}