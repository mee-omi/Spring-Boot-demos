/**
 * 
 */
package com.springdemo.empldemo.service;

import java.util.List;

import com.springdemo.empldemo.entity.Employee;

/**
 * @author Omkar
 */
public interface EmployeeService {
	List<Employee> findAll();

	Employee findById(int Id);

	Employee save(Employee employee);

	void delete(int Id);
}
