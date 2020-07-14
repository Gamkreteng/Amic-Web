package model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Table (name = "employee")
public class Empolyee {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NonNull
    private String employeeCode;

    @Column
    private String userAccountId;

}
