package com.tmu.amic.controller;

import com.tmu.amic.controller.request.AssignedRequest;
import com.tmu.amic.controller.request.ProjectManagerRequest;
import com.tmu.amic.controller.response.AssignedResponse;
import com.tmu.amic.controller.response.ProjectManagerResponse;
import com.tmu.amic.model.Assigned;
import com.tmu.amic.model.ProjectManager;
import com.tmu.amic.repository.ProjectManagerRepository;
import com.tmu.amic.service.AssignedServices;
import com.tmu.amic.service.ProjectManagerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class ProjectManagerController {

    @Autowired
    private ProjectManagerServices projectManagerServices;

    @GetMapping("/projectmanager")
    public List<ProjectManager> getAllAssigned() {

        return projectManagerServices.findAll();
    }

    @GetMapping("/projectmanager/{id}")
    public ProjectManagerResponse getById(@PathVariable long id) {
        return projectManagerServices.getProjectManagerById(id);
    }

    @PostMapping("/projectmanager")
    public void creatProjectManager(@RequestBody ProjectManagerRequest projectManager) {
        projectManagerServices.creatProjectManager(projectManager);
    }

    @PutMapping("/projectmanager/{id}")
    public void replaceProjectManager(@RequestBody ProjectManager updateProjectManager, @PathVariable Long id) {
        projectManagerServices.replaceProjectManager(updateProjectManager, id);
    }

    @DeleteMapping("/projectmanager/{id}")
    public void delete(@PathVariable String id) {

        Long projectManagerID = Long.parseLong(id);
        projectManagerServices.deleteById(projectManagerID);
    }
}
