package com.tmu.amic.service;

import com.tmu.amic.controller.request.AssignedRequest;
import com.tmu.amic.controller.request.TaskRequest;
import com.tmu.amic.controller.response.AssignedResponse;
import com.tmu.amic.controller.response.TaskResponse;
import com.tmu.amic.model.Assigned;
import com.tmu.amic.model.Task;
import com.tmu.amic.repository.AssignedRepository;
import com.tmu.amic.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServices {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {

        List<Task> it = taskRepository.findAll();

        ArrayList<Task> tasks = new ArrayList<Task>();
        it.forEach(e -> tasks.add(e));

        return tasks;
    }

    public TaskResponse getTaskById(long id) {
        TaskResponse taskResponse = new TaskResponse();
        Task task = taskRepository.findById(id).get();


        taskResponse.setTaskName(task.getTaskName());
        taskResponse.setProjectId(task.getProjectId());
        taskResponse.setPriority(task.getPriority());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setActualBudget(task.getActualBudget());
        taskResponse.setPlannedBudget(task.getPlannedBudget());
        taskResponse.setActualStartTime(task.getActualStartTime());
        taskResponse.setActualEndTime(task.getActualEndTime());
        taskResponse.setPlannedStartDate(task.getPlannedStartDate());
        taskResponse.setPlannedEndDate(task.getPlannedEndDate());

        return taskResponse;
    }

    public void deleteById(Long id) {

        taskRepository.deleteById(id);
    }

    public void creatTask(TaskRequest task) {

        Task tsk = new Task();

        tsk.setTaskName(task.getTaskName());
        tsk.setProjectId(task.getProjectId());
        tsk.setPriority(task.getPriority());
        tsk.setDescription(task.getDescription());
        tsk.setActualBudget(task.getActualBudget());
        tsk.setPlannedBudget(task.getPlannedBudget());
        tsk.setActualStartTime(task.getActualStartTime());
        tsk.setActualEndTime(task.getActualEndTime());
        tsk.setPlannedStartDate(task.getPlannedStartDate());
        tsk.setPlannedEndDate(task.getPlannedEndDate());

    }

    public Task replaceTask(@RequestBody Task updateTask, @PathVariable Long id) {

        return taskRepository.findById(id)
                .map(task -> {
                    task.setTaskName(updateTask.getTaskName());
                    task.setProjectId(updateTask.getProjectId());
                    task.setPriority(updateTask.getPriority());
                    task.setDescription(updateTask.getDescription());
                    task.setActualBudget(updateTask.getActualBudget());
                    task.setPlannedBudget(updateTask.getPlannedBudget());
                    task.setActualStartTime(updateTask.getActualStartTime());
                    task.setActualEndTime(updateTask.getActualEndTime());
                    task.setPlannedStartDate(updateTask.getPlannedStartDate());
                    task.setPlannedEndDate(updateTask.getPlannedEndDate());
                    return taskRepository.save(task);
                })
                .orElseGet(() -> {
                    updateTask.setId(id);
                    return taskRepository.save(updateTask);
                });
    }

}
