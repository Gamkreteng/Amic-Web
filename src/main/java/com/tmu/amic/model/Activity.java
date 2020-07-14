package com.tmu.amic.model;

import io.swagger.annotations.ApiModel;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;


@Entity
@Table (name = "activity")
@ApiModel(description = "Class representing an activity which is in relation with Tasks")
public class Activity {

    @Id
    @NotEmpty
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotEmpty
    private String activityName;

    @Column
    @NotEmpty
    private int taskId;

    @Column
    @NotEmpty
    private int priority;

    @Column
    private String description;

    @Column
    @NotEmpty
    //@Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date plannedStartDate;

    @Column
    @NotEmpty
    //@Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date plannedEndDate;

    @Column
    @NotEmpty
    private float plannedBudget;

    @Column
    //@Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date actualStartTime;

    @Column
    //@Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date actualEndTime;

    @Column
    private float actualBudget;

    public Activity() {
    }

    public Long getId() {
        return id;
    }

    public String getActivityName() {
        return activityName;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public Date getPlannedEndDate() {
        return plannedEndDate;
    }

    public float getPlannedBudget() {
        return plannedBudget;
    }

    public Date getActualStartTime() {
        return actualStartTime;
    }

    public Date getActualEndTime() {
        return actualEndTime;
    }

    public float getActualBudget() {
        return actualBudget;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public void setPlannedEndDate(Date plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public void setPlannedBudget(float plannedBudget) {
        this.plannedBudget = plannedBudget;
    }

    public void setActualStartTime(Date actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    public void setActualEndTime(Date actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public void setActualBudget(float actualBudget) {
        this.actualBudget = actualBudget;
    }
}
