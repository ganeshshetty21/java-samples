package com.ganesh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.beans.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// Optional<Employee> findByFirstName(String firstName);
	List<Employee> findByFirstName(String firstName);

	// Optional<Employee> findByLastName(String lastName);
	List<Employee> findByLastName(String lastName);
 

}
