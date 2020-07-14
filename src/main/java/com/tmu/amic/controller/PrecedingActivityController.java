package com.tmu.amic.controller;

import com.tmu.amic.controller.request.PrecedingActivityRequest;
import com.tmu.amic.controller.response.PrecedingActivityResponse;
import com.tmu.amic.model.PrecedingActivity;
import com.tmu.amic.service.PrecedingActivityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class PrecedingActivityController {

    @Autowired
    private PrecedingActivityServices precedingActivityServices;

    @GetMapping("/precedingactivity")
    public List<PrecedingActivity> getAllPrecedingActivity() {

        return precedingActivityServices.findAll();
    }

    @GetMapping("/precedingactivity/{id}")
    public PrecedingActivityResponse getById(@PathVariable long id) {
        return precedingActivityServices.getPrecedingActivityById(id);
    }

    @PostMapping("/precedingactivity")
    public void creatPrecedingActivity(@RequestBody PrecedingActivityRequest precedingActivity) {
        precedingActivityServices.creatPrecedingActivity(precedingActivity);
    }

    @PutMapping("/precedingactivity/{id}")
    public void replacePrecedingActivity(@RequestBody PrecedingActivity updatePrecedingActivity, @PathVariable Long id) {
        precedingActivityServices.replacePrecedingActivity(updatePrecedingActivity, id);
    }

    @DeleteMapping("/precedingactivity/{id}")
    public void delete(@PathVariable String id) {

        Long precedingActivityId = Long.parseLong(id);
        precedingActivityServices.deleteById(precedingActivityId);
    }
}
