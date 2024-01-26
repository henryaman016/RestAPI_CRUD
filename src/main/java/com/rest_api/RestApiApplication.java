package com.rest_api;

import com.rest_api.model.Employee;
import com.rest_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;



	@Override
	public void run(String... args) throws Exception {
		Employee employee=new Employee();
		employee.setName("Rahul");
		employee.setEmail("rahul@gmail.com");
		employee.setCity("Nawada");
		employee.setPhone("7415654997");

		employeeRepository.save(employee);

		Employee employee1=new Employee();
		employee1.setName("Nandni");
		employee1.setEmail("nandni@gmail.com");
		employee1.setCity("Mirzapur");
		employee1.setPhone("8051268797");

		employeeRepository.save(employee1);
	}
}
