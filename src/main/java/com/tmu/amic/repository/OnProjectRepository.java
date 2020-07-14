package com.tmu.amic.repository;

import com.tmu.amic.model.OnProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OnProjectRepository extends JpaRepository<OnProject, Long> {
}