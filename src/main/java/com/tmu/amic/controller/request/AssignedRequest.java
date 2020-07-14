package com.tmu.amic.controller.request;

import lombok.NonNull;

import javax.persistence.Column;
import java.util.Objects;

public class AssignedRequest {

    private int activityId;

    private int employeeId;

    private int roleID;

    public AssignedRequest() {
    }

    public AssignedRequest(int activityId, int employeeId, int roleID) {
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
        if (!(o instanceof AssignedRequest)) return false;
        AssignedRequest that = (AssignedRequest) o;
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
        return "AssignedRequest{" +
                "activityId=" + activityId +
                ", employeeId=" + employeeId +
                ", roleID=" + roleID +
                '}';
    }
}
