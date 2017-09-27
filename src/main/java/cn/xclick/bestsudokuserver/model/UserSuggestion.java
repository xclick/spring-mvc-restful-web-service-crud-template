package cn.xclick.bestsudokuserver.model;

import java.util.Date;

public class UserSuggestion {
	private int id ;
	private long userId ;
	private String suggestion ;
	private String confirm ;
	private Date createTime ;
	private Date editTime ;
	//
	private String userNickname ;
	
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
	public String getSuggestion(){
		return this.suggestion;
	}
	public void setSuggestion(String suggestion){
		this.suggestion = suggestion ;
	}
	public String getConfirm(){
		return this.confirm;
	}
	public void setConfirm(String confirm){
		this.confirm = confirm ;
	}
	public String getUserNickname(){
		return this.userNickname;
	}
	public void setUserNickname(String userNickname){
		this.userNickname = userNickname ;
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
}
