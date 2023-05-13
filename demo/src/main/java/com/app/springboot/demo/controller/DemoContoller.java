package com.app.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springboot.coredemo.Coach;

@RestController
public class DemoContoller {
	// define private field for dependency
	private Coach myCoach;
	private Coach anotherCoach;

	// define constructor for dependency
	// constructor injection
	// example for qualifier
	@Autowired
	//public DemoContoller(@Qualifier("baseBallCoach") Coach coach, @Qualifier("baseBallCoach") Coach theAnotherCoach) {
	//public DemoContoller(@Qualifier("swimCoach") Coach coach, @Qualifier("baseBallCoach") Coach theAnotherCoach) {
	public DemoContoller(@Qualifier("shark") Coach coach, @Qualifier("baseBallCoach") Coach theAnotherCoach) {
		System.out.println("in Constructor " + getClass().getSimpleName());
		myCoach = coach;
		anotherCoach = theAnotherCoach;
	}

	// setter injection method name can be any method name
	/*
	 * @Autowired
	 * public void setCoach(Coach setterCoach) {
	 * myCoach = setterCoach;
	 * }
	 */
	// autowired not necessary for single constructor

	@GetMapping("dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
	
	/**
	 * differentiation between singleton and prototype scope
	 * @return
	 */
	@GetMapping("check")
	public String check() {
		return " comparing beans mycoach and another coach "+ (myCoach == anotherCoach);
	}
}
