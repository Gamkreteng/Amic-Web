package com.tmu.amic.controller.request;

import lombok.NonNull;

import javax.persistence.Column;
import java.util.Objects;

public class EmployeeRequest {

    private int id;

    private String employeeCode;

    private String userAccountId;

    public EmployeeRequest() {
    }

    public EmployeeRequest(int id, String employeeCode, String userAccountId) {
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
        if (!(o instanceof EmployeeRequest)) return false;
        EmployeeRequest that = (EmployeeRequest) o;
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
        return "EmployeeRequest{" +
                "id=" + id +
                ", employeeCode='" + employeeCode + '\'' +
                ", userAccountId='" + userAccountId + '\'' +
                '}';
    }
}
