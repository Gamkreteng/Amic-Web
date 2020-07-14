package com.tmu.amic.controller;

import com.tmu.amic.controller.request.EmployeeRequest;
import com.tmu.amic.controller.response.EmployeeResponse;
import com.tmu.amic.model.Employee;
import com.tmu.amic.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {

        return employeeServices.findAll();
    }

    @GetMapping("/employee/{id}")
    public EmployeeResponse getById(@PathVariable long id) {
        return employeeServices.getEmployeeById(id);
    }

    @PostMapping("/employee")
    public void creatEmployee(@RequestBody EmployeeRequest employee) {
        employeeServices.creatEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public void replaceEmployee(@RequestBody Employee updateEmployee, @PathVariable Long id) {
        employeeServices.replaceEmployee(updateEmployee, id);
    }

    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable String id) {

        Long employeeId = Long.parseLong(id);
        employeeServices.deleteById(employeeId);
    }

}
