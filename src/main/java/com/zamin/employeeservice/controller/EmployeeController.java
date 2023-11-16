package com.zamin.employeeservice.controller;

import com.zamin.employeeservice.model.Employee;
import com.zamin.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeRepository employeeRepository;
    @PostMapping
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("Employee add: {}",employee);
        return employeeRepository.add(employee);
    }
    @GetMapping
    public List<Employee> getAll(){
        LOGGER.info("Employee find");
        return employeeRepository.getAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        LOGGER.info("Employee findById: {}",id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/departmentID/{id}")
    public  List<Employee> findByDepartmentId(@PathVariable Long id){
        LOGGER.info("Employee find By Department: {}",id);
        return employeeRepository.findBydepartment(id);
    }
}
