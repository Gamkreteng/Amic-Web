package com.tmu.amic.controller.request;

public class PrecedingActivityRequest {

    private int activityId;

    private int precedingActivityId;

    public PrecedingActivityRequest() {
    }

    public PrecedingActivityRequest(int activityId, int precedingActivityId) {
        this.activityId = activityId;
        this.precedingActivityId = precedingActivityId;
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
    public String toString() {
        return "PrecedingActivityRequest{" +
                ", activityId=" + activityId +
                ", precedingActivityId=" + precedingActivityId +
                '}';
    }
}
