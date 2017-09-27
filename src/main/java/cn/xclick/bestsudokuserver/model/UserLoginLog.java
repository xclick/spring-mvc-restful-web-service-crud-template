package cn.xclick.bestsudokuserver.model;

import java.util.Date;

public class UserLoginLog {
	private int id ;
	private long userId ;
	private String action ;
	private String fromIp ;
	private String status ;
	private Date actionTime ;
	private String token ;
	private String data ;
	
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id ;
	}
	public long getUserId(){
		return this.userId;
	}
	public void setUserId(long userId){
		this.userId = userId ;
	}
	public String getAction(){
		return this.action;
	}
	public void setAction(String action){
		this.action = action ;
	}
	public String getFromIp(){
		return this.fromIp;
	}
	public void setFromIp(String fromIp){
		this.fromIp = fromIp ;
	}
	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status){
		this.status = status ;
	}
	public Date getActionTime(){
		return this.actionTime;
	}
	public void setActionTime(Date actionTime){
		this.actionTime = actionTime ;
	}
	public String getToken(){
		return this.token;
	}
	public void setToken(String token){
		this.token = token ;
	}
	public String getData(){
		return this.data;
	}
	public void setData(String data){
		this.data = data ;
	}
}
