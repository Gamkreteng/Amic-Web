package com.tmu.amic.service;

import com.tmu.amic.controller.request.PrecedingActivityRequest;
import com.tmu.amic.controller.response.PrecedingActivityResponse;
import com.tmu.amic.model.PrecedingActivity;
import com.tmu.amic.repository.PrecedingActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrecedingActivityServices {

    @Autowired
    private PrecedingActivityRepository precedingActivityRepository;

    public List<PrecedingActivity> findAll() {

        List<PrecedingActivity> it = precedingActivityRepository.findAll();

        ArrayList<PrecedingActivity> precedingActivities = new ArrayList<PrecedingActivity>();
        it.forEach(e -> precedingActivities.add(e));

        return precedingActivities;
    }

    public PrecedingActivityResponse getPrecedingActivityById(long id) {
        PrecedingActivityResponse precedingActivityResponse = new PrecedingActivityResponse();
        PrecedingActivity precedingActivity = precedingActivityRepository.findById(id).get();


        precedingActivityResponse.setActivityId(precedingActivity.getActivityId());
        precedingActivityResponse.setPrecedingActivityId(precedingActivity.getPrecedingActivityId());


        return precedingActivityResponse;
    }

    public void deleteById(Long id) {

        precedingActivityRepository.deleteById(id);
    }

    public void creatPrecedingActivity(PrecedingActivityRequest precedingActivity) {

        PrecedingActivity pra = new PrecedingActivity();

        pra.setActivityId(precedingActivity.getActivityId());
        pra.setPrecedingActivityId(precedingActivity.getPrecedingActivityId());

    }

    public PrecedingActivity replacePrecedingActivity(@RequestBody PrecedingActivity updatePrecedingActivity, @PathVariable Long id) {

        return precedingActivityRepository.findById(id)
                .map(assigned -> {
                    assigned.setActivityId(updatePrecedingActivity.getActivityId());
                    assigned.setPrecedingActivityId(updatePrecedingActivity.getPrecedingActivityId());
                    return precedingActivityRepository.save(assigned);
                })
                .orElseGet(() -> {
                    updatePrecedingActivity.setId(id);
                    return precedingActivityRepository.save(updatePrecedingActivity);
                });
    }
}
