package model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Table (name = "role")
public class Role {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NonNull
    private String roleName;

}
