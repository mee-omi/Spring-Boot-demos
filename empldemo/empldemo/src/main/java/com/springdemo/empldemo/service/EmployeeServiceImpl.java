/**
 * 
 */
package com.springdemo.empldemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.empldemo.dao.EmployeeDao;
import com.springdemo.empldemo.entity.Employee;

import jakarta.transaction.Transactional;

/**
 * @author Omkar
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	public Employee findById(int Id) {
		// TODO Auto-generated method stub
		return employeeDao.findById(Id);
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.save(employee);
	}

	@Override
	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		employeeDao.delete(Id);
	}

}
