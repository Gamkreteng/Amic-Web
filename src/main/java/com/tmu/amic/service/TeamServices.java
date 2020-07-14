package com.tmu.amic.service;

import com.tmu.amic.controller.request.TeamRequest;
import com.tmu.amic.controller.response.TeamResponse;
import com.tmu.amic.model.Team;
import com.tmu.amic.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServices {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> findAll() {

        List<Team> it = teamRepository.findAll();

        ArrayList<Team> teams = new ArrayList<Team>();
        it.forEach(e -> teams.add(e));

        return teams;
    }

    public TeamResponse getTeamById(long id) {
        TeamResponse teamResponse = new TeamResponse();
        Team team = teamRepository.findById(id).get();


        teamResponse.setTeamName(team.getTeamName());

        return teamResponse;
    }

    public void deleteById(Long id) {

        teamRepository.deleteById(id);
    }

    public void creatTeam(TeamRequest team) {

        Team tem = new Team();

        tem.setTeamName(team.getTeamName());
    }

    public Team replaceTeam(@RequestBody Team updateTeam, @PathVariable Long id) {

        return teamRepository.findById(id)
                .map(team -> {
                    team.setTeamName(updateTeam.getTeamName());
                    return teamRepository.save(team);
                })
                .orElseGet(() -> {
                    updateTeam.setId(id);
                    return teamRepository.save(updateTeam);
                });
    }

}
