package com.tmu.amic.controller;

import com.tmu.amic.controller.request.TeamRequest;
import com.tmu.amic.controller.response.TeamResponse;
import com.tmu.amic.model.Team;
import com.tmu.amic.service.TeamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class TeamController {

    @Autowired
    private TeamServices teamServices;

    @GetMapping("/team")
    public List<Team> getAllTeam() {

        return teamServices.findAll();
    }

    @GetMapping("/team/{id}")
    public TeamResponse getById(@PathVariable long id) {
        return teamServices.getTeamById(id);
    }

    @PostMapping("/team")
    public void creatTeam(@RequestBody TeamRequest team) {
        teamServices.creatTeam(team);
    }

    @PutMapping("/team/{id}")
    public void replaceTeam(@RequestBody Team updateTeam, @PathVariable Long id) {
        teamServices.replaceTeam(updateTeam, id);
    }

    @DeleteMapping("/team/{id}")
    public void delete(@PathVariable String id) {

        Long teamId = Long.parseLong(id);
        teamServices.deleteById(teamId);
    }
}
