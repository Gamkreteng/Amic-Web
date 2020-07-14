package model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Table (name = "team_members")
public class TeamMembers {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NonNull
    private int teamID;

    @Column
    @NonNull
    private int employeeId;

    @Column
    @NonNull
    private int roleId;

}
