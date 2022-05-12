package com.laptrinhjavaweb.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.laptrinhjavaweb.dto.ResponseDTO;
import com.laptrinhjavaweb.myexception.FieldRequiredException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{

	@ExceptionHandler(FieldRequiredException.class)
	public ResponseEntity<ResponseDTO> handleNotFoundException(FieldRequiredException ex, WebRequest request){
		
		ResponseDTO result=new ResponseDTO();
	    result.setData(null);
	    result.setError(ex.getMessage());
				return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
