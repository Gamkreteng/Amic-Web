package com.tmu.amic.controller.response;

import java.util.Objects;

public class EmployeeResponse {

    private int id;

    private String employeeCode;

    private String userAccountId;

    public EmployeeResponse() {
    }

    public EmployeeResponse(int id, String employeeCode, String userAccountId) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.userAccountId = userAccountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeResponse)) return false;
        EmployeeResponse that = (EmployeeResponse) o;
        return getId() == that.getId() &&
                Objects.equals(getEmployeeCode(), that.getEmployeeCode()) &&
                Objects.equals(getUserAccountId(), that.getUserAccountId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmployeeCode(), getUserAccountId());
    }

    @Override
    public String toString() {
        return "EmployeeResponse{" +
                "id=" + id +
                ", employeeCode='" + employeeCode + '\'' +
                ", userAccountId='" + userAccountId + '\'' +
                '}';
    }
}
