/**
 * 
 */
package com.securitymvc.demosec.secuirty;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Omkar
 */
@Configuration
public class DemoSecurityConfig {
	/*
	 * @Bean
	 * public BCryptPasswordEncoder passwordEncoder() {
	 * return new BCryptPasswordEncoder();
	 * }
	 * @Bean
	 * public DaoAuthenticationProvider authenticationProvider(UserDetailsService
	 * userDetailsService) {
	 * DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
	 * auth.setUserDetailsService(userDetailsService); //set the custom user details
	 * service
	 * auth.setPasswordEncoder(passwordEncoder()); //set the password encoder -
	 * bcrypt
	 * return auth;
	 * }
	 */
	
	/**
	 * For using custom user credentials table for spring security
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
	 * to use spring security using default spring tables
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
		http.authorizeHttpRequests(configurer -> configurer.requestMatchers("/").hasRole("EMPLOYEE")
				.requestMatchers("/leaders/**").hasRole("MANAGER").requestMatchers("/systems/**").hasRole("ADMIN")
				.anyRequest().authenticated())
				.formLogin(
						form -> form.loginPage("/showLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll())
				.logout(logout -> logout.permitAll())
				.exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));

		// http.cors().disable();

		return http.build();
	}
}
