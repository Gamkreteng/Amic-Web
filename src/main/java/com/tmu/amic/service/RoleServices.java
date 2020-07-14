package com.tmu.amic.service;

import com.tmu.amic.controller.request.AssignedRequest;
import com.tmu.amic.controller.request.RoleRequest;
import com.tmu.amic.controller.response.AssignedResponse;
import com.tmu.amic.controller.response.RoleResponse;
import com.tmu.amic.model.Assigned;
import com.tmu.amic.model.Role;
import com.tmu.amic.repository.AssignedRepository;
import com.tmu.amic.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServices {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {

        List<Role> it = roleRepository.findAll();

        ArrayList<Role> roles = new ArrayList<Role>();
        it.forEach(e -> roles.add(e));

        return roles;
    }

    public RoleResponse getRoleById(long id) {
        RoleResponse roleResponse = new RoleResponse();
        Role role = roleRepository.findById(id).get();


        roleResponse.setRoleName(role.getRoleName());

        return roleResponse;
    }

    public void deleteById(Long id) {

        roleRepository.deleteById(id);
    }

    public void creatRole(RoleRequest role) {

        Role rol = new Role();

        rol.setRoleName(role.getRoleName());

    }

    public Role replaceRole(@RequestBody Role updateRole, @PathVariable Long id) {

        return roleRepository.findById(id)
                .map(role -> {
                    role.setRoleName(updateRole.getRoleName());
                    return roleRepository.save(role);
                })
                .orElseGet(() -> {
                    updateRole.setId(id);
                    return roleRepository.save(updateRole);
                });
    }

}
