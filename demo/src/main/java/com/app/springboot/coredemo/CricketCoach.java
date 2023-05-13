package com.app.springboot.coredemo;

import org.springframework.stereotype.Component;

import com.app.springboot.coredemo.Coach;

@Component
public class CricketCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 minutes, NOW !!!!!!!! -- :)";
	}

	public TrackCoach() {
		System.out.println("in Constructor "+getClass().getSimpleName());
	}
}
