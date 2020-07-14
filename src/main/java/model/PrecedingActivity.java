package model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Table (name = "preceding_activity")
public class PrecedingActivity {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NonNull
    private int activityId;

    @Column
    @NonNull
    private int precedingActivityId;

}
