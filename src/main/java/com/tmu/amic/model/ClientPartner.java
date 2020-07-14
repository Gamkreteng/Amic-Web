package com.tmu.amic.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table (name = "client_partner")
@ApiModel(description = "Class representing specifications of a client or partner")
public class ClientPartner {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NonNull
    private String cpName;

    @Column
    @NonNull
    private String cpAddress;

    @Column
    @NonNull
    private String cpDetails;

    public ClientPartner() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public String getCpAddress() {
        return cpAddress;
    }

    public void setCpAddress(String cpAddress) {
        this.cpAddress = cpAddress;
    }

    public String getCpDetails() {
        return cpDetails;
    }

    public void setCpDetails(String cpDetails) {
        this.cpDetails = cpDetails;
    }
}
