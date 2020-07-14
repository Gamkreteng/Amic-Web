package com.tmu.amic.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table (name = "task")
@ApiModel(description = "Class representing specifications of a task")
public class Task {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NonNull
    private String taskName;

    @Column
    @NonNull
    private int projectId;

    @Column
    @NonNull
    private int priority;

    @Column
    private String description;

    @Column
    @NonNull
//    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date plannedStartDate;

    @Column
    @NonNull
//    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date plannedEndDate;

    @Column
    @NonNull
    private float plannedBudget;

    @Column
//    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date actualStartTime;

    @Column
//    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date actualEndTime;

    @Column
    private float actualBudget;

    public Task(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedEndDate() {
        return plannedEndDate;
    }

    public void setPlannedEndDate(Date plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public float getPlannedBudget() {
        return plannedBudget;
    }

    public void setPlannedBudget(float plannedBudget) {
        this.plannedBudget = plannedBudget;
    }

    public Date getActualStartTime() {
        return actualStartTime;
    }

    public void setActualStartTime(Date actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    public Date getActualEndTime() {
        return actualEndTime;
    }

    public void setActualEndTime(Date actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public float getActualBudget() {
        return actualBudget;
    }

    public void setActualBudget(float actualBudget) {
        this.actualBudget = actualBudget;
    }
}
