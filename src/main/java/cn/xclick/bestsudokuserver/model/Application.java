package cn.xclick.bestsudokuserver.model;

import java.util.Date;

public class Application {
	private int id ;
	private String version ;
	private String store ;
	private String releaseNote ;
	private String downloadUrl ;
	private Date createTime ;
	private Date editTime ;
	
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id ;
	}
	public String getVersion(){
		return this.version;
	}
	public void setVersion(String version){
		this.version = version ;
	}
	public String getStore(){
		return this.store;
	}
	public void setStore(String store){
		this.store = store ;
	}
	public String getReleaseNote(){
		return this.releaseNote;
	}
	public void setReleaseNote(String releaseNote){
		this.releaseNote = releaseNote ;
	}
	public String getDownloadUrl(){
		return this.downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl){
		this.downloadUrl = downloadUrl ;
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
