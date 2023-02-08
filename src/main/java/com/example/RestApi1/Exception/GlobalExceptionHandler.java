package com.example.RestApi1.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = NoSuchVehicalExistsException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse handleException(NoSuchVehicalExistsException ex)
	{
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
	
	@ExceptionHandler(value = VehicalAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse handleException(VehicalAlreadyExistsException ex)
	{
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
	
}
