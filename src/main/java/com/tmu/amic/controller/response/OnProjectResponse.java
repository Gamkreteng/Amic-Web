package com.tmu.amic.controller.response;

import java.sql.Date;
import java.util.Objects;

public class OnProjectResponse {

    private int projectId;

    private int clientPartnerId;

    private Date dateStart;

    private Date dateEnd;

    private boolean isClient;

    private boolean isPartner;

    private String description;

    public OnProjectResponse() {
    }

    public OnProjectResponse(int projectId, int clientPartnerId, Date dateStart, Date dateEnd, boolean isClient, boolean isPartner, String description) {
        this.projectId = projectId;
        this.clientPartnerId = clientPartnerId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.isClient = isClient;
        this.isPartner = isPartner;
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OnProjectResponse)) return false;
        OnProjectResponse that = (OnProjectResponse) o;
        return getProjectId() == that.getProjectId() &&
                getClientPartnerId() == that.getClientPartnerId() &&
                isClient() == that.isClient() &&
                isPartner() == that.isPartner() &&
                Objects.equals(getDateStart(), that.getDateStart()) &&
                Objects.equals(getDateEnd(), that.getDateEnd()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProjectId(), getClientPartnerId(), getDateStart(), getDateEnd(), isClient(), isPartner(), getDescription());
    }

    @Override
    public String toString() {
        return "OnProjectResponse{" +
                "projectId=" + projectId +
                ", clientPartnerId=" + clientPartnerId +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", isClient=" + isClient +
                ", isPartner=" + isPartner +
                ", description='" + description + '\'' +
                '}';
    }
}
