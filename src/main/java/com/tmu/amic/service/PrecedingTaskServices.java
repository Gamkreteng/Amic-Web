package com.tmu.amic.service;

import com.tmu.amic.controller.request.PrecedingTaskRequest;
import com.tmu.amic.controller.response.PrecedingTaskResponse;
import com.tmu.amic.model.PrecedingTask;
import com.tmu.amic.repository.PrecedingTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrecedingTaskServices {

    @Autowired
    private PrecedingTaskRepository precedingTaskRepository;

    public List<PrecedingTask> findAll() {

        List<PrecedingTask> it = precedingTaskRepository.findAll();

        ArrayList<PrecedingTask> precedingTasks = new ArrayList<PrecedingTask>();
        it.forEach(e -> precedingTasks.add(e));

        return precedingTasks;
    }

    public PrecedingTaskResponse getPrecedingTaskById(long id) {
        PrecedingTaskResponse precedingTaskResponse = new PrecedingTaskResponse();
        PrecedingTask precedingTask = precedingTaskRepository.findById(id).get();


        precedingTaskResponse.setPrecedingTaskId(precedingTask.getPrecedingTaskId());
        precedingTaskResponse.setTaskId(precedingTask.getTaskId());

        return precedingTaskResponse;
    }

    public void deleteById(Long id) {

        precedingTaskRepository.deleteById(id);
    }

    public void creatPrecedingTask(PrecedingTaskRequest precedingTask) {

        PrecedingTask prt = new PrecedingTask();

        prt.setPrecedingTaskId(precedingTask.getPrecedingTaskId());
        prt.setTaskId(precedingTask.getTaskId());

    }

    public PrecedingTask replacePrecedingTask(@RequestBody PrecedingTask updatePrecedingTask, @PathVariable Long id) {

        return precedingTaskRepository.findById(id)
                .map(precedingTask -> {
                    precedingTask.setPrecedingTaskId(updatePrecedingTask.getPrecedingTaskId());
                    precedingTask.setTaskId(updatePrecedingTask.getTaskId());
                    return precedingTaskRepository.save(precedingTask);
                })
                .orElseGet(() -> {
                    updatePrecedingTask.setId(id);
                    return precedingTaskRepository.save(updatePrecedingTask);
                });
    }

}
