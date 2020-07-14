package com.tmu.amic.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table (name = "role")
@ApiModel(description = "Class representing roles in team")
public class Role {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NonNull
    private String roleName;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
