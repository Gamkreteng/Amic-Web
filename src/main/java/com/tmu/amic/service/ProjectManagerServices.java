package com.tmu.amic.service;

import com.tmu.amic.controller.request.ProjectManagerRequest;
import com.tmu.amic.controller.response.ProjectManagerResponse;
import com.tmu.amic.model.ProjectManager;
import com.tmu.amic.repository.ProjectManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectManagerServices {

    @Autowired
    private ProjectManagerRepository projectManagerRepository;

    public List<ProjectManager> findAll() {

        List<ProjectManager> it = projectManagerRepository.findAll();

        ArrayList<ProjectManager> projectManagers = new ArrayList<ProjectManager>();
        it.forEach(e -> projectManagers.add(e));

        return projectManagers;
    }

    public ProjectManagerResponse getProjectManagerById(long id) {
        ProjectManagerResponse projectManagerResponse = new ProjectManagerResponse();
        ProjectManager projectManager = projectManagerRepository.findById(id).get();


        projectManagerResponse.setProjectId(projectManager.getProjectId());
        projectManagerResponse.setUserAccountId(projectManager.getUserAccountId());

        return projectManagerResponse;
    }

    public void deleteById(Long id) {

        projectManagerRepository.deleteById(id);
    }

    public void creatProjectManager(ProjectManagerRequest projectManager) {

        ProjectManager pma = new ProjectManager();

        pma.setUserAccountId(projectManager.getUserAccountId());
        pma.setProjectId(projectManager.getProjectId());

    }

    public ProjectManager replaceProjectManager(@RequestBody ProjectManager updateProjectManager, @PathVariable Long id) {

        return projectManagerRepository.findById(id)
                .map(projectManager -> {
                    projectManager.setUserAccountId(updateProjectManager.getUserAccountId());
                    projectManager.setProjectId(updateProjectManager.getProjectId());
                    return projectManagerRepository.save(projectManager);
                })
                .orElseGet(() -> {
                    updateProjectManager.setId(id);
                    return projectManagerRepository.save(updateProjectManager);
                });
    }

}
