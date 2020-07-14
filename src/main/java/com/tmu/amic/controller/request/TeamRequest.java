package com.tmu.amic.controller.request;

import java.util.Objects;

public class TeamRequest {

    private String teamName;

    public TeamRequest() {
    }

    public TeamRequest(String teamName) {
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
        if (!(o instanceof TeamRequest)) return false;
        TeamRequest that = (TeamRequest) o;
        return getTeamName().equals(that.getTeamName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTeamName());
    }

    @Override
    public String toString() {
        return "TeamRequest{" +
                "teamName='" + teamName + '\'' +
                '}';
    }
}
