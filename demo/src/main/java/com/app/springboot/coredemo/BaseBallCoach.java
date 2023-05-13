package com.app.springboot.coredemo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * @author Omkar
 *
 */
/**
 * @author Omkar
 *
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BaseBallCoach implements Coach {

	/**
	 *
	 */
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Spend 45 mins in batting practice";
	}
	
	public BaseBallCoach() {
		System.out.println("in Constructor "+getClass().getSimpleName());
	}
	
	@PostConstruct
	public void startup() {
		System.out.println("in startup "+getClass().getSimpleName());
	}
	
	@PreDestroy
	public void cleanup() {
		System.out.println("in destroy "+getClass().getSimpleName());
	}
}

