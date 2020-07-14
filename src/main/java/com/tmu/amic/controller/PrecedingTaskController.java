package com.tmu.amic.controller;


import com.tmu.amic.controller.request.AssignedRequest;
import com.tmu.amic.controller.request.PrecedingTaskRequest;
import com.tmu.amic.controller.response.AssignedResponse;
import com.tmu.amic.controller.response.PrecedingTaskResponse;
import com.tmu.amic.model.Assigned;
import com.tmu.amic.model.PrecedingTask;
import com.tmu.amic.repository.PrecedingTaskRepository;
import com.tmu.amic.service.AssignedServices;
import com.tmu.amic.service.PrecedingTaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class PrecedingTaskController {

    @Autowired
    private PrecedingTaskServices precedingTaskServices;

    @GetMapping("/precedingtask")
    public List<PrecedingTask> getAllAssigned() {

        return precedingTaskServices.findAll();
    }

    @GetMapping("/precedingtask/{id}")
    public PrecedingTaskResponse getById(@PathVariable long id) {
        return precedingTaskServices.getPrecedingTaskById(id);
    }

    @PostMapping("/precedingtask")
    public void creatPrecedingTask(@RequestBody PrecedingTaskRequest precedingTask) {
        precedingTaskServices.creatPrecedingTask(precedingTask);
    }

    @PutMapping("/precedingtask/{id}")
    public void replacePrecedingTask(@RequestBody PrecedingTask updatePrecedingTask, @PathVariable Long id) {
        precedingTaskServices.replacePrecedingTask(updatePrecedingTask, id);
    }

    @DeleteMapping("/precedingtask/{id}")
    public void delete(@PathVariable String id) {

        Long precedingTaskId = Long.parseLong(id);
        precedingTaskServices.deleteById(precedingTaskId);
    }
}
