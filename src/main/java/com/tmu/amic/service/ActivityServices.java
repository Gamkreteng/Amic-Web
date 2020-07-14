package com.tmu.amic.service;

import com.tmu.amic.controller.request.ActivityRequest;
import com.tmu.amic.controller.response.ActivityResponse;
import com.tmu.amic.model.Activity;
import com.tmu.amic.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServices {


    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> findAll() {

        List<Activity> it = activityRepository.findAll();

        ArrayList<Activity> activities = new ArrayList<Activity>();
        it.forEach(e -> activities.add(e));

        return activities;
    }

    public ActivityResponse getActivityById(long id) {
        ActivityResponse activityResponse = new ActivityResponse();
        Activity activity = activityRepository.findById(id).get();


        activityResponse.setActivityName(activity.getActivityName());
        activityResponse.setPriority(activity.getPriority());
        activityResponse.setActualBudget(activity.getActualBudget());
        activityResponse.setActualEndTime(activity.getActualEndTime());
        activityResponse.setActualStartTime(activity.getActualStartTime());
        activityResponse.setDescription(activity.getDescription());
        activityResponse.setPlannedBudget(activity.getPlannedBudget());
        activityResponse.setPlannedEndDate(activity.getPlannedEndDate());
        activityResponse.setPlannedStartDate(activity.getPlannedStartDate());
        activityResponse.setTaskId(activity.getTaskId());

        return activityResponse;
    }

    public void deleteById(Long id) {

        activityRepository.deleteById(id);
    }

    public void creatActivity(ActivityRequest activity) {

        Activity act = new Activity();

        act.setActivityName(activity.getActivityName());
        act.setPriority(activity.getPriority());
        act.setActualBudget(activity.getActualBudget());
        act.setActualEndTime(activity.getActualEndTime());
        act.setActualStartTime(activity.getActualStartTime());
        act.setDescription(activity.getDescription());
        act.setPlannedBudget(activity.getPlannedBudget());
        act.setPlannedEndDate(activity.getPlannedEndDate());
        act.setPlannedStartDate(activity.getPlannedStartDate());
        act.setTaskId(activity.getTaskId());
    }

    public Activity replaceActivity(@RequestBody Activity updateActivity, @PathVariable Long id) {

        return activityRepository.findById(id)
                .map(activity -> {
                    activity.setActivityName(updateActivity.getActivityName());
                    activity.setPriority(updateActivity.getPriority());
                    return activityRepository.save(activity);
                })
                .orElseGet(() -> {
                    updateActivity.setId(id);
                    return activityRepository.save(updateActivity);
                });
    }


}
