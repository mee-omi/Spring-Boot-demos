package com.app.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.app.springboot.coredemo","com.app.springboot.demo",,"com.app.springboot.config"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public DemoApplication() {
		System.out.println("in Constructor "+getClass().getSimpleName());
	}
}
