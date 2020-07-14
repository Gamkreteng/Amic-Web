package com.tmu.amic.controller.request;

import com.tmu.amic.model.Project;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Objects;

public class ProjectRequest {


    private String projectName;


    private Date plannedStartDate;


    private Date plannedEndDate;

    private Date actualStartDate;


    private Date actualEndDate;

    private String projectDescription;

    public ProjectRequest() {
    }

    public ProjectRequest(String projectName, Date plannedStartDate, Date plannedEndDate, Date actualStartDate, Date actualEndDate, String projectDescription) {
        this.projectName = projectName;
        this.plannedStartDate = plannedStartDate;
        this.plannedEndDate = plannedEndDate;
        this.actualStartDate = actualStartDate;
        this.actualEndDate = actualEndDate;
        this.projectDescription = projectDescription;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedEndDate() {
        return plannedEndDate;
    }

    public void setPlannedEndDate(Date plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public Date getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(Date actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectRequest)) return false;
        ProjectRequest that = (ProjectRequest) o;
        return Objects.equals(getProjectName(), that.getProjectName()) &&
                Objects.equals(getPlannedStartDate(), that.getPlannedStartDate()) &&
                Objects.equals(getPlannedEndDate(), that.getPlannedEndDate()) &&
                Objects.equals(getActualStartDate(), that.getActualStartDate()) &&
                Objects.equals(getActualEndDate(), that.getActualEndDate()) &&
                Objects.equals(getProjectDescription(), that.getProjectDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProjectName(), getPlannedStartDate(), getPlannedEndDate(), getActualStartDate(), getActualEndDate(), getProjectDescription());
    }

    @Override
    public String toString() {
        return "ProjectRequest{" +
                "projectName='" + projectName + '\'' +
                ", plannedStartDate=" + plannedStartDate +
                ", plannedEndDate=" + plannedEndDate +
                ", actualStartDate=" + actualStartDate +
                ", actualEndDate=" + actualEndDate +
                ", projectDescription='" + projectDescription + '\'' +
                '}';
    }


    public Project convertToProject(ProjectRequest projectRequest) {
        Project project = new Project();
        project.setProjectDescription(projectRequest.getProjectDescription());
        project.setProjectName(projectRequest.getProjectName());
        project.setActualEndDate(projectRequest.getActualEndDate());
        project.setActualStartDate(projectRequest.getActualStartDate());
        project.setPlannedStartDate(projectRequest.getPlannedStartDate());
        project.setPlannedEndDate(projectRequest.getPlannedEndDate());
        return project;
    }
}
