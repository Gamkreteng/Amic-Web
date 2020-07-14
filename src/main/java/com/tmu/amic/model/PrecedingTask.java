package com.tmu.amic.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table (name = "preceding_task")
@ApiModel(description = "Class representing a list of all such prerequisite tasks")
public class PrecedingTask {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NonNull
    private int taskId;

    @Column
    @NonNull
    private int precedingTaskId;

    public PrecedingTask() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
