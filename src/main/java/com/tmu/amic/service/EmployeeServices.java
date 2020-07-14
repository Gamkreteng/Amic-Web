package com.tmu.amic.service;

import com.tmu.amic.controller.request.AssignedRequest;
import com.tmu.amic.controller.request.EmployeeRequest;
import com.tmu.amic.controller.response.AssignedResponse;
import com.tmu.amic.controller.response.EmployeeResponse;
import com.tmu.amic.model.Assigned;
import com.tmu.amic.model.Employee;
import com.tmu.amic.repository.AssignedRepository;
import com.tmu.amic.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {

        List<Employee> it = employeeRepository.findAll();

        ArrayList<Employee> employees = new ArrayList<Employee>();
        it.forEach(e -> employees.add(e));

        return employees;
    }

    public EmployeeResponse getEmployeeById(long id) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        Employee employee = employeeRepository.findById(id).get();


        employeeResponse.setEmployeeCode(employee.getEmployeeCode());
        employeeResponse.setUserAccountId(employee.getUserAccountId());

        return employeeResponse;
    }

    public void deleteById(Long id) {

        employeeRepository.deleteById(id);
    }

    public void creatEmployee(EmployeeRequest employee) {

        Employee emp = new Employee();

        emp.setEmployeeCode(employee.getEmployeeCode());
        emp.setUserAccountId(employee.getUserAccountId());

    }

    public Employee replaceEmployee(@RequestBody Employee updateEmployee, @PathVariable Long id) {

        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setEmployeeCode(updateEmployee.getEmployeeCode());
                    employee.setUserAccountId(updateEmployee.getUserAccountId());
                    return employeeRepository.save(employee);
                })
                .orElseGet(() -> {
                    updateEmployee.setId(id);
                    return employeeRepository.save(updateEmployee);
                });
    }

}
