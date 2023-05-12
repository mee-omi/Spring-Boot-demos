/**
 * 
 */
package com.springdemo.empldemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdemo.empldemo.entity.Employee;

/**
 * @author Omkar
 * creating repository for employee class
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
