package cn.xclick.bestsudokuserver.model;

import java.util.Date;

public class UserLogin {
	private String token ;
	private Long userId ;
	private String fromIp ;
	private Date loginTime ;
	private Date logoutTime ;
	private Date lastActiveTime ;
	private Date expireTime ;
	private String active ;
	
	public String getToken(){
		return this.token;
	}
	public void setToken(String token){
		this.token = token ;
	}
	public Long getUserId(){
		return this.userId;
	}
	public void setUserId(Long userId){
		this.userId = userId ;
	}
	public String getFromIp(){
		return this.fromIp;
	}
	public void setFromIp(String fromIp){
		this.fromIp = fromIp ;
	}
	public Date getLoginTime(){
		return this.loginTime;
	}
	public void setLoginTime(Date loginTime){
		this.loginTime = loginTime ;
	}
	public Date getLogoutTime(){
		return this.logoutTime;
	}
	public void setLogoutTime(Date logoutTime){
		this.logoutTime = logoutTime ;
	}
	public Date getLastActiveTime(){
		return this.lastActiveTime;
	}
	public void setLastActiveTime(Date lastActiveTime){
		this.lastActiveTime = lastActiveTime ;
	}
	public Date getExpireTime(){
		return this.expireTime;
	}
	public void setExpireTime(Date expireTime){
		this.expireTime = expireTime ;
	}
	public String getActive(){
		return this.active;
	}
	public void setActive(String active){
		this.active = active ;
	}
}
