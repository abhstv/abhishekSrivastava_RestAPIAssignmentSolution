package com.greatlearning.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagement.model.Employee;
import com.greatlearning.EmployeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> get() {
		return employeeRepository.findAll();
	}

	public void addEmployee(String firstName, String lastName, String email) {
		employeeRepository.save(new Employee(firstName, lastName, email));
	}

	public void deleteEmployee(int theId) {
		employeeRepository.deleteById(theId);
	}

	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public Optional<Employee> searchById(int theId) {
		return employeeRepository.findById(theId);
	}

	public List<Employee> searchByFirstName(String fName) {
		Employee employee = new Employee();
		employee.setFirstName(fName);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "lastName", "email");
		return employeeRepository.findAll(Example.of(employee, exampleMatcher));
	}

	public List<Employee> getEmployeeByFirstNameOrder(Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}

}
