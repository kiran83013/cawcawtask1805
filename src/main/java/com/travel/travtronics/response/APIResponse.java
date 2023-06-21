package com.travel.travtronics.response;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import com.travel.travtronics.model.Task;

public class APIResponse {
	private String message;
	private Integer status;
	private List<?> data;
	private List<?> errors;
	
	public APIResponse(Integer status, String message, List<?>data) {
		this(status, message, data, Collections.emptyList());
	}

	public APIResponse(Integer status, String message, List<?> data, List<?> errors) {
		this.message = message;
		this.status = status;
		this.data = data;
		this.errors = errors;
	}

	 public APIResponse(int value, int value2, List<Task> list) {
		
	}

	public APIResponse(int value, String name, String sql) {
		// TODO Auto-generated constructor stub
	}

	public APIResponse(int value, String name, StringBuilder sb) {
		// TODO Auto-generated constructor stub
	}

	public APIResponse(int value, String name, Query q) {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public List<?> getErrors() {
		return errors;
	}

	public void setErrors(List<?> errors) {
		this.errors = errors;
	}


	

}
