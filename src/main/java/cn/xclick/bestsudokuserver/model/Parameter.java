package cn.xclick.bestsudokuserver.model;

import java.util.Date;

public class Parameter {
	public static final int AD_SPLASH_ENABLE = 1001 ;
	public static final int AD_WALL_ENABLE = 1002 ;
	public static final int AD_BANNER_ENABLE = 1003 ;
	public static final int PAUSE_AD_ENABLE = 1004 ;
	public static final int SHARE_CONTENT = 1011 ;
	public static final int SHARE_LINK = 1012 ;
	
	private int id ;
	private String content ;
	private String remark ;
	private Date editTime ;
	
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id ;
	}
	public String getContent(){
		return this.content;
	}
	public void setContent(String content){
		this.content = content ;
	}
	public String getRemark(){
		return this.remark;
	}
	public void setRemark(String remark){
		this.remark = remark ;
	}
	public Date getEditTime(){
		return this.editTime;
	}
	public void setEditTime(Date editTime){
		this.editTime = editTime ;
	}
}
