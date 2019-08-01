package com.ganesh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.beans.Employee;
import com.ganesh.service.Constants;
import com.ganesh.service.EmployeeService;

@RestController
@RequestMapping("/ganesh")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getEmployees(
			@RequestParam(value = "name", required = false, defaultValue = Constants.EMPTY) String name) {
		return employeeService.getEmployees(name);
	}

	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable long id) {
		return employeeService.getEmployeeById(id);
	}

	@PostMapping("/employees")
	public List<Employee> createEmployees(@RequestBody List<Employee> employees) {
		return employeeService.createEmployees(employees);
	}
	 

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
	}

	@DeleteMapping("/employees")
	public void deleteAllEmployees() {
		employeeService.deleteAllEmployees();
	}	

}
