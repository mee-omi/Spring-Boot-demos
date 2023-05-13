/**
 * 
 */
package com.demo.springboot.thyemleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Omkar
 */
@Controller
public class DemoController {

	@GetMapping("/hello")
	public String sayHello(Model theModel) {

		theModel.addAttribute("theDate", new java.util.Date());

		return "helloworld";
	}

}
