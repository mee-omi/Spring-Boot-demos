/**
 * 
 */
package com.securitymvc.demosec.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.securitymvc.demosec.user.WebUser;

import jakarta.validation.Valid;

/**
 * @author Omkar
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserDetailsService userService;
	
    private Logger logger = Logger.getLogger(getClass().getName());


	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

	}

	@GetMapping("/showRegistrationForm")
	public String showRegistrationPage(Model theModel) {
		theModel.addAttribute("webUser", new WebUser());
		return "registration-form";
	}

	@GetMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("webUser") WebUser theCrmUser, 
			BindingResult theBindingResult, 
			Model theModel) {
		/*
		 * String userName = theCrmUser.getUserName();
		 * logger.info("Processing registration form for: " + userName);
		 * // form validation
		 * if (theBindingResult.hasErrors()){
		 * theModel.addAttribute("webUser", new WebUser());
		 * theModel.addAttribute("registrationError",
		 * "User name/password can not be empty.");
		 * return "register/registration-form";
		 * }
		 * // check the database if user already exists
		 * WebUser existing = userService.findByUserName(userName);
		 * if (existing != null){
		 * theModel.addAttribute("crmUser", new WebUser());
		 * theModel.addAttribute("registrationError", "User name already exists.");
		 * logger.warning("User name already exists.");
		 * return "registration-form";
		 * }
		 * // create user account
		 * userService.save(theCrmUser);
		 * logger.info("Successfully created user: " + userName);
		 */
		return "registration-confirmation";
	}
}
