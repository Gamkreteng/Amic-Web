package com.tmu.amic.service;

import com.tmu.amic.controller.request.AssignedRequest;
import com.tmu.amic.controller.response.AssignedResponse;
import com.tmu.amic.model.Assigned;
import com.tmu.amic.repository.AssignedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssignedServices {



    @Autowired
    private AssignedRepository assignedRepository;

    public List<Assigned> findAll() {

        List<Assigned> it = assignedRepository.findAll();

        ArrayList<Assigned> assigneds = new ArrayList<Assigned>();
        it.forEach(e -> assigneds.add(e));

        return assigneds;
    }

    public AssignedResponse getAssignedById(long id) {
        AssignedResponse assignedResponse = new AssignedResponse();
        Assigned assigned = assignedRepository.findById(id).get();


        assignedResponse.setActivityId(assigned.getActivityId());
        assignedResponse.setEmployeeId(assigned.getEmployeeId());
        assignedResponse.setRoleID(assigned.getRoleID());

        return assignedResponse;
    }

    public void deleteById(Long id) {

        assignedRepository.deleteById(id);
    }

    public void creatAssigned(AssignedRequest assigned) {

        Assigned ass = new Assigned();

        ass.setActivityId(assigned.getActivityId());
        ass.setEmployeeId(assigned.getEmployeeId());
        ass.setRoleID(assigned.getRoleID());

    }

    public Assigned replaceAssigned(@RequestBody Assigned updateAssigned, @PathVariable Long id) {

        return assignedRepository.findById(id)
                .map(assigned -> {
                    assigned.setActivityId(updateAssigned.getActivityId());
                    assigned.setEmployeeId(updateAssigned.getEmployeeId());
                    assigned.setRoleID(updateAssigned.getRoleID());
                    return assignedRepository.save(assigned);
                })
                .orElseGet(() -> {
                    updateAssigned.setId(id);
                    return assignedRepository.save(updateAssigned);
                });
    }


}
