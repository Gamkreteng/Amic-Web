package com.tmu.amic.repository;


import com.tmu.amic.model.Assigned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AssignedRepository extends JpaRepository<Assigned, Long> {
}