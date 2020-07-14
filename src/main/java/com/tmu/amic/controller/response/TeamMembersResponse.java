package com.tmu.amic.controller.response;


import java.util.Objects;

public class TeamMembersResponse {

    private int teamID;

    private int employeeId;

    private int roleId;

    public TeamMembersResponse() {
    }

    public TeamMembersResponse(int teamID, int employeeId, int roleId) {
        this.teamID = teamID;
        this.employeeId = employeeId;
        this.roleId = roleId;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamMembersResponse)) return false;
        TeamMembersResponse that = (TeamMembersResponse) o;
        return getTeamID() == that.getTeamID() &&
                getEmployeeId() == that.getEmployeeId() &&
                getRoleId() == that.getRoleId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTeamID(), getEmployeeId(), getRoleId());
    }

    @Override
    public String toString() {
        return "TeamMemberResponse{" +
                "teamID=" + teamID +
                ", employeeId=" + employeeId +
                ", roleId=" + roleId +
                '}';
    }
}
