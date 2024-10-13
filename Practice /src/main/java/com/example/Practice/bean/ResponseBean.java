package com.example.Practice.bean;

public class ResponseBean {
	
	private String message;
	private Object data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseBean [message=" + message + ", data=" + data + "]";
	}
	public ResponseBean(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}
	public ResponseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
