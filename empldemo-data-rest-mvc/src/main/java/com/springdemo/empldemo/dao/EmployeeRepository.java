/**
 * 
 */
package com.springdemo.empldemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springdemo.empldemo.entity.Employee;

/**
 * @author Omkar
 * creating repository for employee class
 * annotation repository rest resource used to specify custom path
 */
//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee> findAllByOrderByLastNameAsc();
}
