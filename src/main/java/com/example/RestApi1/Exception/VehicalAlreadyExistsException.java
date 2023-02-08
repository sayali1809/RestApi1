package com.example.RestApi1.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class VehicalAlreadyExistsException extends RuntimeException{

	private String message;
    public VehicalAlreadyExistsException() {}
 
    public VehicalAlreadyExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
    
	    /*	public VehicalAlreadyExistsException(String string) {
		// TODO Auto-generated constructor stub
	}
	
	@ExceptionHandler(value= VehicalAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleVehicalAlreadyExistsException(VehicalAlreadyExistsException ex){
		 return new ErrorResponse(HttpStatus.CONFLICT.value(),ex.getMessage());
	 }*/
}
