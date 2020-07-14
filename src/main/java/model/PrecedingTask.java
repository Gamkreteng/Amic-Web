package model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Table (name = "preceding_task")
public class PrecedingTask {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NonNull
    private int taskId;

    @Column
    @NonNull
    private int precedingTaskId;

}
