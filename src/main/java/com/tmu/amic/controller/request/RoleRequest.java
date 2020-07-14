package com.tmu.amic.controller.request;

import java.util.Objects;

public class RoleRequest {

    private String roleName;

    public RoleRequest() {
    }

    public RoleRequest(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleRequest)) return false;
        RoleRequest that = (RoleRequest) o;
        return getRoleName().equals(that.getRoleName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleName());
    }

    @Override
    public String toString() {
        return "RoleRequest{" +
                "roleName='" + roleName + '\'' +
                '}';
    }
}
