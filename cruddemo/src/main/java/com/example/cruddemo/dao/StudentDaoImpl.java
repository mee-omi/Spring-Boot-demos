/**
 * 
 */
package com.example.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

/**
 * @author Omkar
 */
@Repository
public class StudentDaoImpl implements StudentDAO {
	// define field for entity manager
	private EntityManager entityManager;

	// inject entity manager using constructor inj
	@Autowired
	public StudentDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		// TODO Auto-generated method stub
		entityManager.persist(student);
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub order by default asc
		TypedQuery<Student> query = entityManager.createQuery("FROM Student order by lastName desc", Student.class);
		return query.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		// TODO Auto-generated method stub
		TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName =:theData", Student.class)
				.setParameter("theData", theLastName);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		// TODO Auto-generated method stub
		entityManager.merge(student);
	}

	@Override
	@Transactional
	public void delete(Integer studentId) {
		// TODO Auto-generated method stub
		Student delStudent = findById(studentId);
		entityManager.remove(delStudent);
	}

	@Override
	@Transactional
	public int deleteAll() {
		// TODO Auto-generated method stub
		int numOfDeletedRows = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numOfDeletedRows;
	}
}
