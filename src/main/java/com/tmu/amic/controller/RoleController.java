package com.tmu.amic.controller;

import com.tmu.amic.controller.request.RoleRequest;
import com.tmu.amic.controller.response.RoleResponse;
import com.tmu.amic.model.Role;
import com.tmu.amic.service.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class RoleController {

    @Autowired
    private RoleServices roleServices;

    @GetMapping("/role")
    public List<Role> getAllRole() {

        return roleServices.findAll();
    }

    @GetMapping("/role/{id}")
    public RoleResponse getById(@PathVariable long id) {
        return roleServices.getRoleById(id);
    }

    @PostMapping("/role")
    public void creatRole(@RequestBody RoleRequest role) {
        roleServices.creatRole(role);
    }

    @PutMapping("/role/{id}")
    public void replaceRole(@RequestBody Role updateRole, @PathVariable Long id) {
        roleServices.replaceRole(updateRole, id);
    }

    @DeleteMapping("/role/{id}")
    public void delete(@PathVariable String id) {

        Long roleId = Long.parseLong(id);
        roleServices.deleteById(roleId);
    }
}
