package cn.xclick.bestsudokuserver.model;

import java.util.Date;

import cn.xclick.bestsudokuserver.data.Constants;

public class User {
	private Long id = Constants.INVALID_USER_ID ;
	private String userName ;
	private String password ;
	private String firstName ;
	private String lastName ;
	private String nickName ;
	private String status ;
	private String email1 ;
	private String email2 ;
	private String email3 ;
	private String phone1 ;
	private String phone2 ;
	private String phone3 ;
	private String deviceUid ;
	private String platform ;
	private String os ;
	private String osVersion ;
	private String appVersion ;
	private Date createTime ;
	private Date editTime ;
	
	public Long getId(){
		return this.id;
	}
	public void setId(Long id){
		this.id = id ;
	}
	public String getUserName(){
		return this.userName;
	}
	public void setUserName(String userName){
		this.userName = userName ;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password = password ;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName ;
	}
	public String getLastName(){
		return this.lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName ;
	}
	public String getNickName(){
		return this.nickName;
	}
	public void setNickName(String nickName){
		this.nickName = nickName ;
	}
	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status){
		this.status = status ;
	}
	public String getEmail1(){
		return this.email1;
	}
	public void setEmail1(String email1){
		this.email1 = email1 ;
	}
	public String getEmail2(){
		return this.email2;
	}
	public void setEmail2(String email2){
		this.email2 = email2 ;
	}
	public String getEmail3(){
		return this.email3;
	}
	public void setEmail3(String email3){
		this.email3 = email3 ;
	}
	public String getPhone1(){
		return this.phone1;
	}
	public void setPhone1(String phone1){
		this.phone1 = phone1 ;
	}
	public String getPhone2(){
		return this.phone2;
	}
	public void setPhone2(String phone2){
		this.phone2 = phone2 ;
	}
	public String getPhone3(){
		return this.phone3;
	}
	public void setPhone3(String phone3){
		this.phone3 = phone3 ;
	}
	public String getDeviceUid(){
		return this.deviceUid;
	}
	public void setDeviceUid(String deviceUid){
		this.deviceUid = deviceUid ;
	}
	public String getPlatform(){
		return this.platform;
	}
	public void setPlatform(String platform){
		this.platform = platform ;
	}
	public String getOs(){
		return this.os;
	}
	public void setOs(String os){
		this.os = os ;
	}
	public String getOsVersion(){
		return this.osVersion;
	}
	public void setOsVersion(String osVersion){
		this.osVersion = osVersion ;
	}
	public String getAppVersion(){
		return this.appVersion;
	}
	public void setAppVersion(String appVersion){
		this.appVersion = appVersion ;
	}
	public Date getCreateTime(){
		return this.createTime;
	}
	public void setCreateTime(Date createTime){
		this.createTime = createTime ;
	}
	public Date getEditTime(){
		return this.editTime;
	}
	public void setEditTime(Date editTime){
		this.editTime = editTime ;
	}
	
	public String toString(){
		return "User:{" + "id=" + String.valueOf(id) + ", deviceUid=" + deviceUid + "}";
	}
	
	public boolean isValid(){
		return ( id > 0 );
	}
}
