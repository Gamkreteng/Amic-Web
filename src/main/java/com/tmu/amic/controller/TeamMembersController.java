package com.tmu.amic.controller;

import com.tmu.amic.controller.request.TeamMembersRequest;
import com.tmu.amic.controller.response.TeamMembersResponse;
import com.tmu.amic.model.TeamMembers;
import com.tmu.amic.service.TeamMembersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class TeamMembersController {

    @Autowired
    private TeamMembersServices teamMembersServices;

    @GetMapping("/teammembers")
    public List<TeamMembers> getAllTeamMembers() {

        return teamMembersServices.findAll();
    }

    @GetMapping("/teammembers/{id}")
    public TeamMembersResponse getById(@PathVariable long id) {
        return teamMembersServices.getTeamMemberById(id);
    }

    @PostMapping("/teammembers")
    public void creatTeamMembers(@RequestBody TeamMembersRequest teamMembers) {
        teamMembersServices.creatTeamMembers(teamMembers);
    }

    @PutMapping("/teammembers/{id}")
    public void replaceTeamMembers(@RequestBody TeamMembers updateTeamMembers, @PathVariable Long id) {
        teamMembersServices.replaceTeamMembers(updateTeamMembers, id);
    }

    @DeleteMapping("/teammembers/{id}")
    public void delete(@PathVariable String id) {

        Long assignedId = Long.parseLong(id);
        teamMembersServices.deleteById(assignedId);
    }
}
