package com.tmu.amic.controller;

import com.tmu.amic.controller.request.AssignedRequest;
import com.tmu.amic.controller.request.TaskRequest;
import com.tmu.amic.controller.response.AssignedResponse;
import com.tmu.amic.controller.response.TaskResponse;
import com.tmu.amic.model.Assigned;
import com.tmu.amic.model.Task;
import com.tmu.amic.repository.TaskRepository;
import com.tmu.amic.service.AssignedServices;
import com.tmu.amic.service.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class TaskController {

    @Autowired
    private TaskServices taskServices;

    @GetMapping("/task")
    public List<Task> getAllTask() {

        return taskServices.findAll();
    }

    @GetMapping("/task/{id}")
    public TaskResponse getById(@PathVariable long id) {
        return taskServices.getTaskById(id);
    }

    @PostMapping("/task")
    public void creatTask(@RequestBody TaskRequest task) {
        taskServices.creatTask(task);
    }

    @PutMapping("/task/{id}")
    public void replaceTask(@RequestBody Task updateTask, @PathVariable Long id) {
        taskServices.replaceTask(updateTask, id);
    }

    @DeleteMapping("/task/{id}")
    public void delete(@PathVariable String id) {

        Long taskId = Long.parseLong(id);
        taskServices.deleteById(taskId);
    }
}
