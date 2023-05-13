/**
 * 
 */
package com.techfreaks.restdemo.entity;

/**
 * @author Omkar
 */
public class Student {
	private String firstName;
	private String lastName;

	public Student() {

	}

	/**
	 * @param firstName
	 * @param lastName
	 */
	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
