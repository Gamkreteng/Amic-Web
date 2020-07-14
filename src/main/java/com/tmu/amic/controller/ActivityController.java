package com.tmu.amic.controller;

import com.tmu.amic.controller.request.ActivityRequest;
import com.tmu.amic.controller.response.ActivityResponse;
import com.tmu.amic.model.Activity;
import com.tmu.amic.service.ActivityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class ActivityController {

    @Autowired
    private ActivityServices activityServices;

    @GetMapping("/activity")
    public List<Activity> getAllActivity() {

        return activityServices.findAll();
    }

    @GetMapping("/activity/{id}")
    public ActivityResponse getById(@PathVariable long id) {
        return activityServices.getActivityById(id);
    }

    @PostMapping("/activity")
    public void creatActivity(@RequestBody ActivityRequest activity) {
        activityServices.creatActivity(activity);
    }

    @PutMapping("/activity/{id}")
    public void replaceActivity(@RequestBody Activity updateActivity, @PathVariable Long id) {
        activityServices.replaceActivity(updateActivity, id);
    }

    @DeleteMapping("/activity/{id}")
    public void delete(@PathVariable String id) {

        Long activityId = Long.parseLong(id);
        activityServices.deleteById(activityId);
    }
}
