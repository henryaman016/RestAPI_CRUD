package com.rest_api.repository;

import com.rest_api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;


public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
// all crud data base methods

}
