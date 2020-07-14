package com.tmu.amic.service;

import com.tmu.amic.controller.request.AssignedRequest;
import com.tmu.amic.controller.request.TeamMembersRequest;
import com.tmu.amic.controller.response.AssignedResponse;
import com.tmu.amic.controller.response.TeamMembersResponse;
import com.tmu.amic.model.Assigned;
import com.tmu.amic.model.TeamMembers;
import com.tmu.amic.repository.TeamMembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamMembersServices {

    @Autowired
    private TeamMembersRepository teamMembersRepository;

    public List<TeamMembers> findAll() {

        List<TeamMembers> it = teamMembersRepository.findAll();

        ArrayList<TeamMembers> teamMemberses = new ArrayList<TeamMembers>();
        it.forEach(e -> teamMemberses.add(e));

        return teamMemberses;
    }

    public TeamMembersResponse getTeamMemberById(long id) {
        TeamMembersResponse teamMembersResponse = new TeamMembersResponse();
        TeamMembers teamMembers = teamMembersRepository.findById(id).get();


        teamMembersResponse.setTeamID(teamMembers.getTeamID());
        teamMembersResponse.setEmployeeId(teamMembers.getEmployeeId());
        teamMembersResponse.setRoleId(teamMembers.getRoleId());

        return teamMembersResponse;
    }

    public void deleteById(Long id) {

        teamMembersRepository.deleteById(id);
    }

    public void creatTeamMembers(TeamMembersRequest teamMembers) {

        TeamMembers tes = new TeamMembers();

        tes.setTeamID(teamMembers.getTeamID());
        tes.setEmployeeId(teamMembers.getEmployeeId());
        tes.setRoleId(teamMembers.getRoleId());

    }

    public TeamMembers replaceTeamMembers(@RequestBody TeamMembers updateTeamMembers, @PathVariable Long id) {

        return teamMembersRepository.findById(id)
                .map(teamMembers -> {
                    teamMembers.setRoleId(updateTeamMembers.getRoleId());
                    teamMembers.setEmployeeId(updateTeamMembers.getEmployeeId());
                    teamMembers.setTeamID(updateTeamMembers.getTeamID());
                    return teamMembersRepository.save(teamMembers);
                })
                .orElseGet(() -> {
                    updateTeamMembers.setId(id);
                    return teamMembersRepository.save(updateTeamMembers);
                });
    }

}
