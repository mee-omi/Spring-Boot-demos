/**
 * 
 */
package com.springdemo.empldemo.dao;

import java.util.List;

import com.springdemo.empldemo.entity.Employee;

/**
 * @author Omkar
 */
public interface EmployeeDao {
	List<Employee> findAll();

	Employee findById(int Id);

	Employee save(Employee employee);

	void delete(int Id);
}
