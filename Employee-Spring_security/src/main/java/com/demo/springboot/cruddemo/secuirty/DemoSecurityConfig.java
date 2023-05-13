/**
 * 
 */
package com.demo.springboot.cruddemo.secuirty;



import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Omkar
 */
@Configuration
public class DemoSecurityConfig {
	
	// add support for JDBC -- no more hardccoded users
	/**
	 * To access user details from custom table structure from db
	 * @param dataSource
	 * @return
	 */
	@Bean	
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		// define query to retrieve the user by username
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"select user_id, pw, active from members where user_id=?");

		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select user_id,role from roles where user_id = ?");
		
		return jdbcUserDetailsManager;
	}
	
	/*
	 * to access userdetaisl from default spring table structure from db
	 * @Bean
	 * public UserDetailsManager userDetailsManager(DataSource dataSource) {
	 * return new JdbcUserDetailsManager(dataSource);
	 * }
	 */
	
	/*
	 * @Bean
	 * public InMemoryUserDetailsManager userDetailsManager() {
	 * UserDetails bon =
	 * User.builder().username("bon").password("{noop}test123").roles("EMPLOYEE").
	 * build();
	 * UserDetails carry =
	 * User.builder().username("carry").password("{noop}test123").roles("EMPLOYEE",
	 * "MANAGER")
	 * .build();
	 * UserDetails vision =
	 * User.builder().username("vision").password("{noop}test123")
	 * .roles("EMPLOYEE", "MANAGER", "ADMIN").build();
	 * return new InMemoryUserDetailsManager(bon, carry, vision);
	 * }
	 */

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer -> configurer.requestMatchers(HttpMethod.GET, "/api/employees")
				.hasRole("EMPLOYEE").requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));

		http.httpBasic();

		// disable cross site request forger CSRF
		// csrf generarlly not required for stateless REST APIs
		http.csrf().disable();

		return http.build();
	}
}
