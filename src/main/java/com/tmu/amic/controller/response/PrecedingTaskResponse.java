package com.tmu.amic.controller.response;


import java.util.Objects;

public class PrecedingTaskResponse {

    private int id;

    private int taskId;

    private int precedingTaskId;

    public PrecedingTaskResponse() {
        this.id = id;
        this.taskId = taskId;
        this.precedingTaskId = precedingTaskId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (!(o instanceof PrecedingTaskResponse)) return false;
        PrecedingTaskResponse that = (PrecedingTaskResponse) o;
        return getId() == that.getId() &&
                getTaskId() == that.getTaskId() &&
                getPrecedingTaskId() == that.getPrecedingTaskId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTaskId(), getPrecedingTaskId());
    }

    @Override
    public String toString() {
        return "PrecedingTaskResponse{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", precedingTaskId=" + precedingTaskId +
                '}';
    }
}
