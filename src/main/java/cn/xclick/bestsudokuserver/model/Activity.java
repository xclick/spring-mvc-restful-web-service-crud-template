package cn.xclick.bestsudokuserver.model;

import java.util.Date;

public class Activity {
	private int id ;
	private String type ;
	private String key ;
	private String token ;
	private String ip ;
	private String userAgent ;
	private String data ;
	private Date editTime ;
	
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id ;
	}
	public String getType(){
		return this.type;
	}
	public void setType(String type){
		this.type = type ;
	}
	public String getKey(){
		return this.key;
	}
	public void setKey(String key){
		this.key = key ;
	}
	public String getToken(){
		return this.token;
	}
	public void setToken(String token){
		this.token = token ;
	}
	public String getIp(){
		return this.ip;
	}
	public void setIp(String ip){
		this.ip = ip ;
	}
	public String getUserAgent(){
		return this.userAgent;
	}
	public void setUserAgent(String userAgent){
		this.userAgent = userAgent ;
	}
	public String getData(){
		return this.data;
	}
	public void setData(String data){
		this.data = data ;
	}
	public Date getEditTime(){
		return this.editTime;
	}
	public void setEditTime(Date editTime){
		this.editTime = editTime ;
	}
}
