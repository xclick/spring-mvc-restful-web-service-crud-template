package cn.xclick.bestsudokuserver.dao;

import java.util.List;

import cn.xclick.bestsudokuserver.model.Activity;
import cn.xclick.bestsudokuserver.model.Application;
import cn.xclick.bestsudokuserver.model.Parameter;
import cn.xclick.bestsudokuserver.model.UserSuggestion;

public interface CommonDao {
	public List<Parameter> getParameters(); 
	public Application getLastVersionApplication() ;
	public void createActivity(Activity data);
}
