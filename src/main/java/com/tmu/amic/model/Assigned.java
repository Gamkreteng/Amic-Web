package com.tmu.amic.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table (name = "assigned")
@ApiModel(description = "Class representing how activities, employees and roles are linked")
public class Assigned {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NonNull
    private int activityId;

    @Column
    @NonNull
    private int employeeId;

    @Column
    @NonNull
    private int roleID;

    public Assigned() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
