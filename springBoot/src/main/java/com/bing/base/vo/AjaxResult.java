package com.bing.base.vo;

public class AjaxResult {

	public enum ResultState{
		ok,error;
	}
	
	private ResultState state;
	private String message;
	private Object data;
	public ResultState getState() {
		return state;
	}
	public void setState(ResultState state) {
		this.state = state;
	}
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
	public AjaxResult() {
		super();
	}
	
	public AjaxResult(ResultState state, String message) {
		super();
		this.state = state;
		this.message = message;
	}
	
	public static AjaxResult errorResult(String errorMsg){
		return new AjaxResult(ResultState.error,errorMsg);
	}
	public static AjaxResult okResult(Object data){
		 AjaxResult result = new AjaxResult();
		 result.setData(data);
		 result.setState(ResultState.ok);
		 return result;
	}
	public static AjaxResult okResult(){
		AjaxResult result = new AjaxResult();
		result.setState(ResultState.ok);
		return result;
	}
	
}
