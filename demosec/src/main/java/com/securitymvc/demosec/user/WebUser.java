/**
 * 
 */
package com.securitymvc.demosec.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * @author Omkar
 *
 */
public class WebUser {
	
	@NotNull(message = "is required")
	@Size(min=1, message="is required")
	private String userName;
	
	@NotNull(message = "is required")
	@Size(min=1, message="is required")
	private String password;

	public WebUser() {
	}
	
	public WebUser(@NotNull(message = "is required") @Size(min = 1, message = "is required") String userName,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
