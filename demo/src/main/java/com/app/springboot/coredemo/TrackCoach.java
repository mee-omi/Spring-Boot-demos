/**
 * 
 */
package com.app.springboot.coredemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author Omkar
 * As this is marked as primary, it will be picked if no qualifier is specified in injection
 * But it will have only one for multiple implementations.
 * Qualifier has higher priority.
 * Lazy paramter makes is load when needed
 * If qualifier is not specified then lazy would not work as this is primary
 */
@Component
@Primary
@Lazy
public class TrackCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 20K!";
	}

	public TrackCoach() {
		System.out.println("in Constructor "+getClass().getSimpleName());
	}
}
