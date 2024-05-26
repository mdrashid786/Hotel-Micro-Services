package com.micro.payload;

import org.apache.hc.core5.http.HttpStatus;

public class ApiResponse {

    private String message;
    private Boolean success;
    private HttpStatus status;
    
	public ApiResponse() {
		super();
	}
	
	public ApiResponse(String message, Boolean success, HttpStatus status) {
		super();
		this.message = message;
		this.success = success;
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
    
    
}
