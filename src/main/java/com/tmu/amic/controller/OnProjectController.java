package com.tmu.amic.controller;

import com.tmu.amic.controller.request.OnProjectRequest;
import com.tmu.amic.controller.response.OnProjectResponse;
import com.tmu.amic.model.OnProject;
import com.tmu.amic.service.OnProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class OnProjectController {

    @Autowired
    private OnProjectServices onProjectServices;

    @GetMapping("/onproject")
    public List<OnProject> getAllOnProject() {

        return onProjectServices.findAll();
    }

    @GetMapping("/onproject/{id}")
    public OnProjectResponse getById(@PathVariable long id) {
        return onProjectServices.getOnProjectById(id);
    }

    @PostMapping("/onproject")
    public void creatOnProject(@RequestBody OnProjectRequest onProject) {
        onProjectServices.creatOnProject(onProject);
    }

    @PutMapping("/onproject/{id}")
    public void replaceOnProject(@RequestBody OnProject updateOnProject, @PathVariable Long id) {
        onProjectServices.replaceOnProject(updateOnProject, id);
    }

    @DeleteMapping("/onproject/{id}")
    public void delete(@PathVariable String id) {

        Long onProjectId = Long.parseLong(id);
        onProjectServices.deleteById(onProjectId);
    }
}
