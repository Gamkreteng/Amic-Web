package com.tmu.amic.repository;

import com.tmu.amic.model.ProjectManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectManagerRepository extends JpaRepository<ProjectManager, Long> {
}