package com.tmu.amic.controller.response;

import java.util.Objects;

public class PrecedingActivityResponse {

    private int id;

    private int activityId;

    private int precedingActivityId;

    public PrecedingActivityResponse() {
    }

    public PrecedingActivityResponse(int id, int activityId, int precedingActivityId) {
        this.id = id;
        this.activityId = activityId;
        this.precedingActivityId = precedingActivityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getPrecedingActivityId() {
        return precedingActivityId;
    }

    public void setPrecedingActivityId(int precedingActivityId) {
        this.precedingActivityId = precedingActivityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrecedingActivityResponse)) return false;
        PrecedingActivityResponse that = (PrecedingActivityResponse) o;
        return getId() == that.getId() &&
                getActivityId() == that.getActivityId() &&
                getPrecedingActivityId() == that.getPrecedingActivityId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getActivityId(), getPrecedingActivityId());
    }

    @Override
    public String toString() {
        return "PrecedingActivityResponse{" +
                "id=" + id +
                ", activityId=" + activityId +
                ", precedingActivityId=" + precedingActivityId +
                '}';
    }
}
