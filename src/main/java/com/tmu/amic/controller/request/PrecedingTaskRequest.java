package com.tmu.amic.controller.request;

import lombok.NonNull;

import javax.persistence.Column;
import java.util.Objects;

public class PrecedingTaskRequest {

    private int taskId;

    private int precedingTaskId;

    public PrecedingTaskRequest() {
    }

    public PrecedingTaskRequest(int taskId, int precedingTaskId) {
        this.taskId = taskId;
        this.precedingTaskId = precedingTaskId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getPrecedingTaskId() {
        return precedingTaskId;
    }

    public void setPrecedingTaskId(int precedingTaskId) {
        this.precedingTaskId = precedingTaskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrecedingTaskRequest)) return false;
        PrecedingTaskRequest that = (PrecedingTaskRequest) o;
        return getTaskId() == that.getTaskId() &&
                getPrecedingTaskId() == that.getPrecedingTaskId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTaskId(), getPrecedingTaskId());
    }

    @Override
    public String toString() {
        return "PrecedingTaskRequest{" +
                "taskId=" + taskId +
                ", precedingTaskId=" + precedingTaskId +
                '}';
    }
}
