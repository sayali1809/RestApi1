package com.example.RestApi1.Exception;

public class NoSuchVehicalExistsException extends RuntimeException{
	private String message;
	 
    public NoSuchVehicalExistsException() {}
 
    public NoSuchVehicalExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
