package com.tmu.amic.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table (name = "on_project")
@ApiModel(description = "Class representing specifications of working on project like dates, which client does ask for and participating of a partner")
public class OnProject {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NonNull
    private int projectId;

    @Column
    @NonNull
    private int clientPartnerId;

    @Column
    @NonNull
//    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date dateStart;

    @Column
//    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date dateEnd;

    @Column
    @NonNull
    private boolean isClient;

    @Column
    @NonNull
    private boolean isPartner;

    @Column
    @NonNull
    private String description;

    public OnProject() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getClientPartnerId() {
        return clientPartnerId;
    }

    public void setClientPartnerId(int clientPartnerId) {
        this.clientPartnerId = clientPartnerId;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public boolean isClient() {
        return isClient;
    }

    public void setClient(boolean client) {
        isClient = client;
    }

    public boolean isPartner() {
        return isPartner;
    }

    public void setPartner(boolean partner) {
        isPartner = partner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
