package cn.xclick.web.restful.template.rest.crud.model;

public class User {
	private String id ;
	private String name ;
	
	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id ;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name ;
	}
}
