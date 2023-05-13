/**
 * 
 */
package com.techfreaks.restdemo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Omkar
 *
 */
@RestController
@RequestMapping("/test")
public class DemoRestController {
	//add code for hello endpoint
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello world !!";
	}
}
