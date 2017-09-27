package cn.xclick.bestsudokuserver.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.xclick.bestsudokuserver.dao.CommonDao;
import cn.xclick.bestsudokuserver.model.Activity;
import cn.xclick.bestsudokuserver.model.Application;
import cn.xclick.bestsudokuserver.model.Parameter;
import cn.xclick.bestsudokuserver.model.UserSuggestion;
import cn.xclick.bestsudokuserver.utils.Utils;

@Service
public class CommonServiceImpl implements CommonService {
	private static final Logger logger = Logger.getLogger(CommonServiceImpl.class);
	
	@Autowired  
	private CommonDao commonDao ; 
	
	private Map<Integer,Parameter> parametersMap ;
	
	public String getAdSplashEnable(){
		return getParameterString(Parameter.AD_SPLASH_ENABLE);
	}
	
	public String getAdWallEnable(){
		return getParameterString(Parameter.AD_WALL_ENABLE) ;
	}
	
	public String getAdBannerEnable(){
		return getParameterString(Parameter.AD_BANNER_ENABLE) ;
	}
	
	public String getPauseAdEnable(){
		return getParameterString(Parameter.PAUSE_AD_ENABLE) ;
	}
	
	public String getShareContent() {
		return getParameterString(Parameter.SHARE_CONTENT) ;
	}
	
	public String getShareLink() {
		return getParameterString(Parameter.SHARE_LINK) ;
	}
	
	public void reloadParameters(){
		parametersMap.clear();
		parametersMap = null ;
		initParameters() ;
	}
	
	public Application checkUpdate(String version){
		Application lastVersion = commonDao.getLastVersionApplication() ; 
		if(StringUtils.isEmpty(version)) return lastVersion ;
		String[] vv = version.split("\\-");
		String v = version ;
		if(vv.length>0) v = vv[0];
		if(lastVersion!=null){
			// TODO: Add Number Compare
			if(v.compareTo(lastVersion.getVersion())<0){
				return lastVersion ;
			}
		}
		return null ;
	}
	
	public boolean insertActivity(String type, String key, String token, String data, HttpServletRequest request) {
		try{
			if(StringUtils.isEmpty(type)) throw new Exception("Type is empty.");
			Activity activity = new Activity();
			activity.setType(type);
			activity.setKey(key);
			activity.setToken(token);
			String ip = "";
			String userAgent = "";
			if(request!=null){
				ip = Utils.getClientIP(request);
				userAgent = Utils.limitString(request.getHeader("User-Agent"),100);
			}
			activity.setIp(ip);
			activity.setUserAgent(userAgent);
			activity.setData(data);
			activity.setEditTime(new Date());
			commonDao.createActivity(activity);
		}catch(Exception ex){
			logger.error(ex.toString());
			return false ;
		}
		return true ;
	}
	
	private Parameter getParameter(int id){
		initParameters();
		if(parametersMap!=null){
			if(parametersMap.containsKey(id)) return parametersMap.get(id);
		}
		return null ;
	}
	
	private void initParameters(){
		if(parametersMap==null){
			parametersMap = new HashMap<Integer,Parameter>();
			List<Parameter> parameters = commonDao.getParameters();
			if(parameters!=null){
				for(Parameter parameter:parameters){
					parametersMap.put(parameter.getId(), parameter);
				}
			}
		}
	}
	
	private int getParameterInt(int id){
		Parameter p = getParameter(id) ;
		if(p!=null) return Utils.parseInt(p.getContent());
		return 0 ;
	}
	
	private String getParameterString(int id){
		Parameter p = getParameter(id) ;
		if(p!=null) return p.getContent() ; 
		return "" ;
	}
}
