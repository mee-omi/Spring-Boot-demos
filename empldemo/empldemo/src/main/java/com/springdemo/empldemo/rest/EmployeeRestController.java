/**
 * 
 */
package com.springdemo.empldemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.empldemo.dao.EmployeeDao;
import com.springdemo.empldemo.entity.Employee;
import com.springdemo.empldemo.service.EmployeeService;

/**
 * @author Omkar
 *         Using dao-service architecture for better clarity and handling of
 *         requests
 *         service enables handling of multiple dao
 */
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// private EmployeeDao employeeDao;
	private EmployeeService employeeService;

	/*
	 * @Autowired
	 * public EmployeeRestController(EmployeeDao employeeDao) {
	 * this.employeeDao = employeeDao;
	 * }
	 */

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmp = employeeService.findById(employeeId);

		if (theEmp == null) {
			throw new RuntimeException("Employee not found with id: " + employeeId);
		}

		return theEmp;
	}

	// mapping for adding new employees
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}

	// mapping for updating existing employees
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);

		if (theEmployee == null) {
			throw new RuntimeException("Employee not found with id: " + employeeId);
		}

		employeeService.delete(employeeId);
		
		return " Deleted employee Id: "+employeeId;
	}
}
