package com.tmu.amic.model;

import io.swagger.annotations.ApiModel;
import org.springframework.data.annotation.LastModifiedDate;
import javax.validation.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;


@Entity
@Table(name = "user_account")
@ApiModel(description = "Class representing specifications of a user")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotEmpty
    @Size(min = 4, max = 20)
    private String username;

    @Column
    @NotEmpty
//    @Pattern(regexp ="[(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$]")
    private String password;

    @Column
    @NotEmpty
    @Email (message = "Email should be a valid email")
    private String email;

    @Column
    @NotEmpty
    private String firstName;

    @Column
    @NotEmpty
    private String lastName;

    @Column
    private boolean isProjectManager;

    @Column
    // (nullable = false, updatable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    //@CreatedDate
    @LastModifiedDate
    private Date createdAt;

    @Column
    // (nullable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    //@UpdateTimestamp
    @LastModifiedDate
    private Date updatedAt;

    public UserAccount() {
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isProjectManager() {
        return isProjectManager;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setProjectManager(boolean projectManager) {
        isProjectManager = projectManager;
    }
}
