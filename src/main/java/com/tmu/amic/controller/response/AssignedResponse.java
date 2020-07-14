package com.tmu.amic.controller.response;

import lombok.NonNull;

import javax.persistence.Column;
import java.util.Objects;

public class AssignedResponse {

    private int activityId;

    private int employeeId;

    private int roleID;

    public AssignedResponse() {
    }

    public AssignedResponse(int activityId, int employeeId, int roleID) {
        this.activityId = activityId;
        this.employeeId = employeeId;
        this.roleID = roleID;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssignedResponse)) return false;
        AssignedResponse that = (AssignedResponse) o;
        return getActivityId() == that.getActivityId() &&
                getEmployeeId() == that.getEmployeeId() &&
                getRoleID() == that.getRoleID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId(), getEmployeeId(), getRoleID());
    }

    @Override
    public String toString() {
        return "AssignedResponse{" +
                "activityId=" + activityId +
                ", employeeId=" + employeeId +
                ", roleID=" + roleID +
                '}';
    }
}
