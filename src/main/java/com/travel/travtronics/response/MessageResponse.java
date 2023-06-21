package com.travel.travtronics.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MessageResponse {

	private Integer status;
	private String message;
	
	
	
	public MessageResponse(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
