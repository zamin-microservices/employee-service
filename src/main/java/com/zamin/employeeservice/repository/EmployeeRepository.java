package com.zamin.employeeservice.repository;

import com.zamin.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employee> employeeList = new ArrayList<>();

    public Employee add(Employee employee){
        employeeList.add(employee);
        return employee;
    }

    public Employee findById(Long id){
        return employeeList.stream().filter(employee -> employee.id().equals(id)).findFirst().orElseThrow();
    }

    public List<Employee> getAll(){
        return employeeList;
    }

    public List<Employee> findBydepartment(Long departmentId){
        return employeeList.stream().filter(employee -> employee.departmentId().equals(departmentId)).toList();
    }
}
