package com.infosys.employeeprofile.config;

public class CustomException extends Exception {
	private final static long serialVersionUID = 1L;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public CustomException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;

	}

	
	 public CustomException()
	 { super(); 
	 }
	 
	 
}
