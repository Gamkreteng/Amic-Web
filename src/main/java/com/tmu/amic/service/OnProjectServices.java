package com.tmu.amic.service;

import com.tmu.amic.controller.request.AssignedRequest;
import com.tmu.amic.controller.request.OnProjectRequest;
import com.tmu.amic.controller.response.AssignedResponse;
import com.tmu.amic.controller.response.OnProjectResponse;
import com.tmu.amic.model.Assigned;
import com.tmu.amic.model.OnProject;
import com.tmu.amic.repository.AssignedRepository;
import com.tmu.amic.repository.OnProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class OnProjectServices {

    @Autowired
    private OnProjectRepository onProjectRepository;

    public List<OnProject> findAll() {

        List<OnProject> it = onProjectRepository.findAll();

        ArrayList<OnProject> onProjects = new ArrayList<OnProject>();
        it.forEach(e -> onProjects.add(e));

        return onProjects;
    }

    public OnProjectResponse getOnProjectById(long id) {
        OnProjectResponse onProjectResponse = new OnProjectResponse();
        OnProject onProject = onProjectRepository.findById(id).get();


        onProjectResponse.setClientPartnerId(onProject.getClientPartnerId());
        onProjectResponse.setProjectId(onProject.getProjectId());
        onProjectResponse.setDescription(onProject.getDescription());
        onProjectResponse.setDateStart(onProject.getDateStart());
        onProjectResponse.setDateEnd(onProject.getDateEnd());

        return onProjectResponse;
    }

    public void deleteById(Long id) {

        onProjectRepository.deleteById(id);
    }

    public void creatOnProject(OnProjectRequest onProject) {

        OnProject onp = new OnProject();

        onp.setClientPartnerId(onProject.getClientPartnerId());
        onp.setProjectId(onProject.getProjectId());
        onp.setDescription(onProject.getDescription());
        onp.setDateStart(onProject.getDateStart());
        onp.setDateEnd(onProject.getDateEnd());

    }

    public OnProject replaceOnProject(@RequestBody OnProject updateOnProject, @PathVariable Long id) {

        return onProjectRepository.findById(id)
                .map(onProject -> {
                    onProject.setClientPartnerId(updateOnProject.getClientPartnerId());
                    onProject.setProjectId(updateOnProject.getProjectId());
                    onProject.setDescription(updateOnProject.getDescription());
                    onProject.setDateStart(updateOnProject.getDateStart());
                    onProject.setDateEnd(updateOnProject.getDateEnd());
                    return onProjectRepository.save(onProject);
                })
                .orElseGet(() -> {
                    updateOnProject.setId(id);
                    return onProjectRepository.save(updateOnProject);
                });
    }

}
