package com.tmu.amic.controller;

import com.tmu.amic.controller.request.AssignedRequest;
import com.tmu.amic.controller.response.AssignedResponse;
import com.tmu.amic.model.Assigned;
import com.tmu.amic.service.AssignedServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class AssignedController {

    @Autowired
    private AssignedServices assignedServices;

    @GetMapping("/assigned")
    public List<Assigned> getAllAssigned() {

        return assignedServices.findAll();
    }

    @GetMapping("/assigned/{id}")
    public AssignedResponse getById(@PathVariable long id) {
        return assignedServices.getAssignedById(id);
    }

    @PostMapping("/assigned")
    public void creatAssigned(@RequestBody AssignedRequest assigned) {
        assignedServices.creatAssigned(assigned);
    }

    @PutMapping("/assigned/{id}")
    public void replaceAssigned(@RequestBody Assigned updateAssigned, @PathVariable Long id) {
        assignedServices.replaceAssigned(updateAssigned, id);
    }

    @DeleteMapping("/assigned/{id}")
    public void delete(@PathVariable String id) {

        Long assignedId = Long.parseLong(id);
        assignedServices.deleteById(assignedId);
    }
}
