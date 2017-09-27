package cn.xclick.bestsudokuserver.service;

import javax.servlet.http.HttpServletRequest;

import cn.xclick.bestsudokuserver.model.Application;

public interface CommonService {
	public String getAdSplashEnable() ;
	public String getAdWallEnable() ;
	public String getAdBannerEnable() ;
	public String getPauseAdEnable();
	public String getShareContent() ;
	public String getShareLink() ;
	
	public void reloadParameters();
	public Application checkUpdate(String versoin);
	public boolean insertActivity(String type, String key, String token, String data, HttpServletRequest request);
}
