package com.mindtree.producer.exception;

import java.util.Date;

public class ErrorDetails {

	private String message;
	private Date timestamp;
	private String description;

	public ErrorDetails(String message, Date timestamp, String description) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.description = description;
	}

	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorDetails [message=" + message + ", timestamp=" + timestamp + ", description=" + description + "]";
	}

}
