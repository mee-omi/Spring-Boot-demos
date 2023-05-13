/**
 * 
 */
package com.app.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.springboot.coredemo.Coach;
import com.app.springboot.coredemo.SwimCoach;

/**
 * @author Omkar
 * configuring additional third party beans
 * bean annotation adds new beans
 */
@Configuration
public class SportConfig {
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(); 
	}
}
