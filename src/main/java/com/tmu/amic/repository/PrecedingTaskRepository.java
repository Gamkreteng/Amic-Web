package com.tmu.amic.repository;

import com.tmu.amic.model.PrecedingTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PrecedingTaskRepository extends JpaRepository<PrecedingTask, Long> {
}