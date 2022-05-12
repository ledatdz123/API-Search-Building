package com.laptrinhjavaweb.myexception;

public class FieldRequiredException extends RuntimeException{
	
	public FieldRequiredException(String errorMessage) {
		super(errorMessage);
	}
}
