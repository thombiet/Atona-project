package com.wha.springmvc.model;

import java.util.Date;

public class Notification {

	private Date date;
	private String message;
	private boolean lu;

	public Notification() {

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isLu() {
		return lu;
	}

	public void setLu(boolean lu) {
		this.lu = lu;
	}

}
