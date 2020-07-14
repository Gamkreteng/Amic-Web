package com.tmu.amic.controller;


import com.tmu.amic.controller.request.ProjectRequest;
import com.tmu.amic.controller.response.ProjectResponse;
import com.tmu.amic.model.Project;
import com.tmu.amic.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/v1/api")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/project")
    public ArrayList<ProjectResponse> getAllProject() {

        return projectService.findAll();
    }

    @GetMapping("/project/{id}")
    public ProjectResponse getById(@PathVariable long id) {
       return projectService.getProjectById(id);
    }

    @PostMapping("/project")
    public void creatProject(@RequestBody ProjectRequest project) {
        projectService.creatProject(project);
    }

    @PutMapping("/project/{id}")
    public void replaceProject(@RequestBody Project updateProject, @PathVariable Long id) {
        projectService.replaceProject(updateProject, id);
    }

    @DeleteMapping("/project/{id}")
    public void delete(@PathVariable String id) {

        Long projectId = Long.parseLong(id);
        projectService.deleteById(projectId);
    }

}
