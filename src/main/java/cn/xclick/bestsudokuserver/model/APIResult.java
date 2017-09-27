package cn.xclick.bestsudokuserver.model;

import java.util.HashMap;
import java.util.Map;

import cn.xclick.bestsudokuserver.data.Constants;

public class APIResult {
	private String code ;
	private String message ;
	private Object data ;
	private Map<String,Object> map ;
	
	public String getCode(){
		return this.code;
	}
	public void setCode(String code){
		this.code = code ;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message ;
	}
	public Object getData(){
		return this.data;
	}
	public void setData(Object data){
		this.data = data ;
	}
	public Map<String,Object> getMap(){
		return this.map;
	}
	public void setMap(Map<String,Object> map){
		this.map = map ;
	}
	
	public APIResult(){
		code = Constants.SUCCESS_CODE ;
		message = "";
		data = "";
	}
	
}
