package com.app.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {

	@Value("${coach.name}")
	private String coachName;

	@Value("${team.name}")
	private String teamName;

	// expose "/" to return hello world
	@GetMapping("/")
	public String sayHello() {
		return "Hello World 1 00 0 " + coachName;
	}

	// expose endpoint "/teaminfo" to return hello world
	@GetMapping("/teamindfo")
	public String teamInfo() {
		return "coach : " + coachName + " & team : " + teamName;
	}

	// expose new endpoint for workout""
	@GetMapping("workout")
	public String getDailyWorkout() {
		return "run a hard 5k!";
	}

	// expose a new endopoint for "fortune"
	@GetMapping("fortune")
	public String getDailytFortune() {
		return "Today is your lucky day.";
	}
}
