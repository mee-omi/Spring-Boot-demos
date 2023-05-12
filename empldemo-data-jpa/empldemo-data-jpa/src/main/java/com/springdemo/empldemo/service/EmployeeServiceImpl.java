/**
 * 
 */
package com.springdemo.empldemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.empldemo.dao.EmployeeRepository;
import com.springdemo.empldemo.entity.Employee;

/**
 * @author Omkar
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		this.employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int Id) {
		Optional<Employee> result = employeeRepository.findById(Id);
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			// employee not found
			throw new RuntimeException(" Did not find employee id "+Id);
		}
		return theEmployee;
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void delete(int Id) {
		employeeRepository.deleteById(Id);
	}

}
