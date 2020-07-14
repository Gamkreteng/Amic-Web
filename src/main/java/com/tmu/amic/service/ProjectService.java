package com.tmu.amic.service;

import com.tmu.amic.controller.request.ProjectRequest;
import com.tmu.amic.controller.response.ProjectResponse;
import com.tmu.amic.model.Project;
import com.tmu.amic.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public ArrayList<ProjectResponse> findAll() {
        ProjectResponse projectResponse = new ProjectResponse();
        List<Project> results = projectRepository.findAll();
        ArrayList<ProjectResponse> projects = (ArrayList<ProjectResponse>) projectResponse.convertToList(results);
        return projects;
    }

    public ProjectResponse getProjectById(long id) {
        ProjectResponse projectResponse = new ProjectResponse();
        Project project = projectRepository.findById(id).get();

        projectResponse.setActualEndDate(project.getActualEndDate());
        projectResponse.setActualStartDate(project.getActualStartDate());
        projectResponse.setPlannedEndDate(project.getPlannedEndDate());
        projectResponse.setPlannedStartDate(project.getPlannedStartDate());
        projectResponse.setProjectDescription(project.getProjectDescription());
        projectResponse.setProjectName(project.getProjectName());

        return projectResponse;
    }

    public void deleteById(Long id) {

        projectRepository.deleteById(id);
    }

    public void creatProject(ProjectRequest project) {
        projectRepository.save(project.convertToProject(project));
    }

    public Project replaceProject(@RequestBody Project updateProject, @PathVariable Long id) {

        return projectRepository.findById(id)
                .map(project -> {
                    project.setProjectName(updateProject.getProjectName());
                    project.setProjectDescription(updateProject.getProjectDescription());
                    return projectRepository.save(project);
                })
                .orElseGet(() -> {
                    updateProject.setId(id);
                    return projectRepository.save(updateProject);
                });
    }

}
