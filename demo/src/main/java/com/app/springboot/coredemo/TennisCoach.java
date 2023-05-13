package com.app.springboot.coredemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author Omkar
 *
 */
@Component
@Lazy
public class TennisCoach implements Coach {

	/**
	 *
	 */
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your backhand volley";
	}
	
	public TennisCoach() {
		System.out.println("in Constructor "+getClass().getSimpleName());
	}

}
