package com.rest_api.controller;

import com.rest_api.exception.ResourceNotFoundException;
import com.rest_api.model.Employee;
import com.rest_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

//    http://localhost:8080/api/v1/employees

@GetMapping
public List<Employee> getAllEmployees(){
    return employeeRepository.findAll();
}

//build create employee REST API
    @PostMapping
    private Employee createEmployee(@RequestBody Employee employee){
    return employeeRepository.save(employee);
    }

    //build get employee  by id Rest API

    @GetMapping("{id}")
    private ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
    Employee employee=employeeRepository.findById(id)
            .orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+ id));
    return ResponseEntity.ok(employee);
    }


    //build update employee Rest Api
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

        // Update individual properties
        updateEmployee.setName(employeeDetails.getName());
        updateEmployee.setEmail(employeeDetails.getEmail());
        updateEmployee.setCity(employeeDetails.getCity());
        updateEmployee.setPhone(employeeDetails.getPhone());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }
//build delete employee Rest API

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

    Employee employee=employeeRepository.findById(id)
            .orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+ id));

    employeeRepository.delete(employee);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
