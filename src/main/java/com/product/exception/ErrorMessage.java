package com.product.exception;

import java.time.LocalDate;
import java.util.Date;

public class ErrorMessage {
	
	private String message;
	private Date timestamp;
	private int status;
	public ErrorMessage(String message, Date timestamp, int status) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.status = status;
	}
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

}
