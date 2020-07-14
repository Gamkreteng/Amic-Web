package com.tmu.amic.repository;

import com.tmu.amic.model.TeamMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeamMembersRepository extends JpaRepository<TeamMembers, Long> {
}