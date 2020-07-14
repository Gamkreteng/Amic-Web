package model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Data
@Table (name = "task")
public class Task {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date plannedStartDate;

    @Column
    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date plannedEndDate;

    @Column
    @NonNull
    private float plannedBudget;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date actualStartTime;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date actualEndTime;

    @Column
    private float actualBudget;

}
