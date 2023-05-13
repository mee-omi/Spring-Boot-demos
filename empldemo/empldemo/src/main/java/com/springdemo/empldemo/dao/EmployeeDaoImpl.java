/**
 * 
 */
package com.springdemo.empldemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.empldemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * @author Omkar
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

		List<Employee> employees = query.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int Id) {
		// TODO Auto-generated method stub
		Employee employee = entityManager.find(Employee.class, Id);
		return employee;
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		Employee dbEmployee = entityManager.merge(employee);

		return dbEmployee;
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		// find the employee
		Employee employee = entityManager.find(Employee.class, Id);

		// remove employee
		entityManager.remove(employee);

	}

}
