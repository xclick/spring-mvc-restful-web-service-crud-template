package cn.xclick.bestsudokuserver.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.xclick.bestsudokuserver.dao.UserDao;
import cn.xclick.bestsudokuserver.data.Constants;
import cn.xclick.bestsudokuserver.model.User;
import cn.xclick.bestsudokuserver.model.UserLogin;
import cn.xclick.bestsudokuserver.model.UserLoginLog;
import cn.xclick.bestsudokuserver.model.UserSuggestion;
import cn.xclick.bestsudokuserver.utils.Utils;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired  
	private UserDao userDao; 
	
	public User getUserById(Long id){
		return userDao.getUserById(id);
	}
	
	public User getUserByDeviceUid(String deviceUid){
		return userDao.getUserByDeviceUid(deviceUid);
	}
	
	/**
	 * 登录：
	 * 提供自动注册功能（通过deviceuid）
	 */
	public String signIn(Map<String,Object> data, String fromIp, StringBuilder token, StringBuilder nickName,
			StringBuilder userId){
		try{
			if(token==null)token = new StringBuilder();
			token.setLength(0);
			if(nickName==null) nickName = new StringBuilder();
			nickName.setLength(0);
			if(userId==null) userId = new StringBuilder();
			userId.setLength(0);
			
			if(data==null) throw new Exception("user data is Null.");
			String deviceuid = Utils.getMapValue(data, "deviceid");
			String platform = Utils.getMapValue(data, "platform");
			String os = Utils.getMapValue(data, "os");
			String osversion = Utils.getMapValue(data, "osversion");
			String version = Utils.getMapValue(data, "version");
			Date now = new Date();
			
			User user = null ;
			
			if(!StringUtils.isEmpty(deviceuid)){
				user = userDao.getUserByDeviceUid(deviceuid) ;
				if(user==null){
					user = new User();
					user.setDeviceUid(deviceuid);
					String nn = newUserNickname();
					user.setNickName(nn);
					user.setStatus(Constants.ACTIVE_ACTIVE);
					user.setPlatform(platform);
					user.setOs(os);
					user.setOsVersion(osversion);
					user.setEditTime(now);
					user.setCreateTime(now);
					user.setAppVersion(version);
					userDao.createUser(user);
				}
			}
			
			String newToken = Utils.newToken() ;
			token.append(newToken);
			{
				UserLogin userLogin = new UserLogin();
				userLogin.setToken(newToken);
				if(user!=null) userLogin.setUserId(user.getId());
				userLogin.setFromIp(fromIp);
				userLogin.setLoginTime(now);
				userLogin.setLastActiveTime(now);
				Date expiredTime = new Date();
				expiredTime.setTime(expiredTime.getTime()+Constants.TOKEN_EXPIRED_SECONDS*1000);
				userLogin.setExpireTime(expiredTime);
				userLogin.setActive(Constants.ACTIVE_ACTIVE);
				userDao.createUserLogin(userLogin);
			}
			{
				UserLoginLog userLoginLog = new UserLoginLog();
				if(user!=null) userLoginLog.setUserId(user.getId());
				userLoginLog.setAction(Constants.LOGIN_ACTION_GET_TOKEN);
				userLoginLog.setFromIp(fromIp);
				userLoginLog.setStatus(Constants.STATUS_YES);
				userLoginLog.setActionTime(now);
				userLoginLog.setToken(newToken);
				userLoginLog.setData(Utils.mapToString(data));
				userDao.createUserLoginLog(userLoginLog);
			}
			if(user!=null)nickName.append(user.getNickName());
			if(nickName.length()==0) nickName.append(newUserNickname());
			if(user!=null) userId.append(String.valueOf(user.getId()));
			return Constants.SUCCESS_CODE ;
		}catch(Exception ex){
			logger.error(ex.toString());
		}
		return Constants.FAILURE_CODE ;
	}
	
	/**
	 * 校验用户令牌
	 * 成功返回用户编号，否则返回 INVALID_USER_ID
	 */
	public long verifyUserToken(String token){
		UserLogin userLogin = userDao.getUserLoginByToken(token);
		if(userLogin==null) return Constants.INVALID_USER_ID ;
		/*
		if(!Constants.ACTIVE_ACTIVE.equalsIgnoreCase(userLogin.getActive())) 
			return Constants.INVALID_USER_ID ;
		Date now = new Date();
		if(now.compareTo(userLogin.getExpireTime()) > 0 ){
			return Constants.INVALID_USER_ID ;
		}*/
		return userLogin.getUserId() ;
	}
	/**
	 * 用户吐槽
	 */
	public String submitSuggestion(UserSuggestion userSuggestion){
		try{
			Date now = new Date();
			userSuggestion.setCreateTime(now);
			userSuggestion.setEditTime(now);
			userDao.createUseSuggestion(userSuggestion);
			return Constants.SUCCESS_CODE ;
		}catch(Exception ex){
			logger.error(ex.toString());
		}
		return Constants.FAILURE_CODE ;
	}
	/**
	 * 更新用户昵称
	 */
	public String updateUserNickname(User user){
		try{
			Date now = new Date();
			user.setEditTime(now);
			userDao.updateUserNickname(user);
			return Constants.SUCCESS_CODE ;
		}catch(Exception ex){
			logger.error(ex.toString());
		}
		return Constants.FAILURE_CODE ;
	}
	/**
	 *  根据用户编号获取用户信息
	 */
	public User getUser(long userId){
		User user = userDao.getUserById(userId);
		if(user==null) user = new User() ;
		return user ;
	}
	/**
	 * 获取用户吐槽列表
	 */
	public List<UserSuggestion> getSuggestions(String id){
		try{
			int n = Utils.parseInt(id);
			return userDao.getSuggestions(n);
		}catch(Exception ex){
			logger.error(ex.toString());
		}
		return null ;
	}
	/**
	 * 生成用户昵称
	 */
	private String newUserNickname(){
		String prefix = "玩家";
		Map<String,Object> data = userDao.getNicknameSeqWithoutUse();
		int seq = 1 ;
		if(data==null){
			seq = 100000 + (int)(Math.random() * 10000000);
		}else{
			seq = Utils.getMapInt(data,"seq",seq);
			int id = Utils.getMapInt(data,"id",0);
			userDao.updateNicknameSeqUsed(id);
		}
		return prefix + String.valueOf(seq);
	}
	////
	
	public static void updateUser(User user){
		user.setId(100L);
	}
	
	public static void main(String[] args) {
		User user = new User();
		updateUser(user);
		System.out.print("user:id="+String.valueOf(user.getId()));
	}
}
