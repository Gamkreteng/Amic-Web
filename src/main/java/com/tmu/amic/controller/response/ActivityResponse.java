package com.tmu.amic.controller.response;

import java.sql.Date;
import java.util.Objects;

public class ActivityResponse {

    private String activityName;

    private int taskId;

    private int priority;

    private String description;

    private Date plannedStartDate;

    private Date plannedEndDate;

    private float plannedBudget;

    private Date actualStartTime;

    private Date actualEndTime;

    private float actualBudget;

    public ActivityResponse() {
    }

    public ActivityResponse(String activityName, int taskId, int priority, String description, Date plannedStartDate, Date plannedEndDate, float plannedBudget, Date actualStartTime, Date actualEndTime, float actualBudget) {
        this.activityName = activityName;
        this.taskId = taskId;
        this.priority = priority;
        this.description = description;
        this.plannedStartDate = plannedStartDate;
        this.plannedEndDate = plannedEndDate;
        this.plannedBudget = plannedBudget;
        this.actualStartTime = actualStartTime;
        this.actualEndTime = actualEndTime;
        this.actualBudget = actualBudget;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActivityResponse)) return false;
        ActivityResponse that = (ActivityResponse) o;
        return getTaskId() == that.getTaskId() &&
                getPriority() == that.getPriority() &&
                Float.compare(that.getPlannedBudget(), getPlannedBudget()) == 0 &&
                Float.compare(that.getActualBudget(), getActualBudget()) == 0 &&
                Objects.equals(getActivityName(), that.getActivityName()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getPlannedStartDate(), that.getPlannedStartDate()) &&
                Objects.equals(getPlannedEndDate(), that.getPlannedEndDate()) &&
                Objects.equals(getActualStartTime(), that.getActualStartTime()) &&
                Objects.equals(getActualEndTime(), that.getActualEndTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityName(), getTaskId(), getPriority(), getDescription(), getPlannedStartDate(), getPlannedEndDate(), getPlannedBudget(), getActualStartTime(), getActualEndTime(), getActualBudget());
    }

    @Override
    public String toString() {
        return "ActivityResponse{" +
                "activityName='" + activityName + '\'' +
                ", taskId=" + taskId +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                ", plannedStartDate=" + plannedStartDate +
                ", plannedEndDate=" + plannedEndDate +
                ", plannedBudget=" + plannedBudget +
                ", actualStartTime=" + actualStartTime +
                ", actualEndTime=" + actualEndTime +
                ", actualBudget=" + actualBudget +
                '}';
    }
}
