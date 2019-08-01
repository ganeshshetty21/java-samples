package com.ganesh.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.beans.Employee;
import com.ganesh.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getEmployees(String name) {
		if (name == null || Constants.EMPTY.equalsIgnoreCase(name)) {
			return getAllEmployees();
		} else {
			List<Employee> employees = getEmployeeByFirstName(name);
			if (employees != null && employees.size() > 0) {
				return employees;
			}
			employees = getEmployeeByLastName(name);
			if (employees != null && employees.size() > 0) {
				return employees;
			}
		}
		return Collections.emptyList();
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		printList(employees);
		return employees;
	}

	public Optional<Employee> getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		logger.info(" employee " + employee);
		return employee;
	}

	public List<Employee> getEmployeeByFirstName(String name) {
		List<Employee> employees = employeeRepository.findByFirstName(name);
		printList(employees);
		return employees;
	}

	public List<Employee> getEmployeeByLastName(String name) {
		List<Employee> employees = employeeRepository.findByLastName(name);
		printList(employees);
		return employees;
	}

	public Employee createEmployee(Employee inEmployee) {
		Employee employee = employeeRepository.save(inEmployee);
		System.out.println(" employee " + employee);
		return employee;
	}

	public List<Employee> createEmployees(List<Employee> inEmployees) {
		List<Employee> employees = employeeRepository.saveAll(inEmployees);
		printList(employees);
		return employees;
	}

	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
	}

	public void deleteAllEmployees() {
		employeeRepository.deleteAll();
	}
 

	private void printList(List<Employee> employees) {
		employees.forEach(employee -> System.out.println(" employee " + employee));
	}

}
