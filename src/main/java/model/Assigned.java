package model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Table (name = "assigned")
public class Assigned {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NonNull
    private int activityId;

    @Column
    @NonNull
    private int employeeId;

    @Column
    @NonNull
    private int roleID;

}
