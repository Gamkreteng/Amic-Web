package com.tmu.amic.controller.response;

import java.util.Objects;

public class TeamResponse {

    private String teamName;

    public TeamResponse() {
    }

    public TeamResponse(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamResponse)) return false;
        TeamResponse that = (TeamResponse) o;
        return getTeamName().equals(that.getTeamName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTeamName());
    }

    @Override
    public String toString() {
        return "TeamResponse{" +
                "teamName='" + teamName + '\'' +
                '}';
    }
}
