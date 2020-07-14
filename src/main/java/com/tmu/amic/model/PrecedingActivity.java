package com.tmu.amic.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table (name = "preceding_activity")
@ApiModel(description = "Class representing a list of all such prerequisite activities")
public class PrecedingActivity {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NonNull
    private int activityId;

    @Column
    @NonNull
    private int precedingActivityId;

    public PrecedingActivity() {
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

    public int getPrecedingActivityId() {
        return precedingActivityId;
    }

    public void setPrecedingActivityId(int precedingActivityId) {
        this.precedingActivityId = precedingActivityId;
    }
}
