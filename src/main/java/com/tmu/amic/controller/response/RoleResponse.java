package com.tmu.amic.controller.response;

import java.util.Objects;

public class RoleResponse {

    private String roleName;

    public RoleResponse() {
    }

    public RoleResponse(String roleName) {
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
        if (!(o instanceof RoleResponse)) return false;
        RoleResponse that = (RoleResponse) o;
        return getRoleName().equals(that.getRoleName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleName());
    }

    @Override
    public String toString() {
        return "RoleResponse{" +
                "roleName='" + roleName + '\'' +
                '}';
    }
}
