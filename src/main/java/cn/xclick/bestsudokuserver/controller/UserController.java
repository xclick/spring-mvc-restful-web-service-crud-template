package cn.xclick.bestsudokuserver.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xclick.bestsudokuserver.data.Constants;
import cn.xclick.bestsudokuserver.model.APIResult;
import cn.xclick.bestsudokuserver.model.Application;
import cn.xclick.bestsudokuserver.model.User;
import cn.xclick.bestsudokuserver.model.UserSuggestion;
import cn.xclick.bestsudokuserver.service.CommonService;
import cn.xclick.bestsudokuserver.service.UserService;
import cn.xclick.bestsudokuserver.utils.Utils;

@Controller
public class UserController extends BaseController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping(value = "/user/signin", method = RequestMethod.POST, headers = { "Accept=application/json" })
	@ResponseBody()
	public APIResult signin(@RequestBody Map<String,Object> data, HttpServletRequest request) {
		String szData = Utils.mapToString(data) ;
		logger.info("/user/signin：data="+szData);
		String deviceid = Utils.getMapValue(data, "deviceid");
		String fromIp = Utils.getClientIP(request);
		commonService.insertActivity(Constants.ACTIVITY_SIGNIN, deviceid, "", szData, request);
		
		APIResult result = new APIResult();
		StringBuilder token = new StringBuilder();
		StringBuilder nickName = new StringBuilder();
		StringBuilder userId = new StringBuilder();
		String code = userService.signIn(data, fromIp, token,nickName,userId);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("token", token.toString());
		map.put("nickname", nickName.toString());
		map.put("user_id", userId.toString());
		map.put("ad_splash", commonService.getAdSplashEnable());
		map.put("ad_wall", commonService.getAdWallEnable());
		map.put("ad_banner", commonService.getAdBannerEnable());
		map.put("pause_ad", commonService.getPauseAdEnable());
		map.put("share_content", commonService.getShareContent());
		map.put("share_link", commonService.getShareLink());
		result.setMap(map);
		result.setCode(code);
		return result ;
	}
	
	@RequestMapping(value = "/user/submit_suggestion", method = RequestMethod.POST, headers = { "Accept=application/json" })
	@ResponseBody()
	public APIResult submitSuggestion(@RequestBody Map<String,Object> data, HttpServletRequest request) {
		String szData = Utils.mapToString(data) ;
		logger.info("/user/submit_suggestion: data="+szData);
		
		String token = Utils.getMapValue(data, "token");
		String suggestion = Utils.getMapValue(data, "suggestion");
		
		commonService.insertActivity(Constants.ACTIVITY_SUBMIT_SUGGESTION, "", token, szData, request);
		
		APIResult result = new APIResult();
		long tokenUserId = userService.verifyUserToken(token);
		if(tokenUserId < 0 ){
			result.setCode(Constants.ERROR_INVALID_TOKEN);
			return result ;
		}
		
		User tokenUser = userService.getUser(tokenUserId);
		
		UserSuggestion userSuggestion = new UserSuggestion();
		if(tokenUser!=null)userSuggestion.setUserId(tokenUser.getId());
		userSuggestion.setSuggestion(suggestion);
		String code = userService.submitSuggestion(userSuggestion);
		if(Constants.SUCCESS_CODE.equals(code)){
			result.setMessage("谢谢你的吐槽，我们会很快改进！");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("suggestion_id", userSuggestion.getId());
			result.setMap(map);
		}
		result.setCode(code);
		return result ;
	}
	
	@RequestMapping(value = "/user/get_suggestions", method = RequestMethod.POST, headers = { "Accept=application/json" })
	@ResponseBody()
	public APIResult getSuggestions(@RequestBody Map<String,Object> data, HttpServletRequest request) {
		String szData = Utils.mapToString(data) ;
		logger.info("/user/get_suggestions：data="+szData);
		
		String token = Utils.getMapValue(data, "token");
		String id = Utils.getMapValue(data, "id");
		
		commonService.insertActivity(Constants.ACTIVITY_GET_SUGGESTIONS, id, token, szData, request);
		
		APIResult result = new APIResult();
		long tokenUserId = userService.verifyUserToken(token);
		if(tokenUserId < 0 ){
			result.setCode(Constants.ERROR_INVALID_TOKEN);
			return result ;
		}
		
		User tokenUser = userService.getUser(tokenUserId);

		if(tokenUser==null || !tokenUser.isValid()){
			result.setCode(Constants.ERROR_INVALID_USER);
			return result ;
		}
		List<UserSuggestion> suggestions = userService.getSuggestions(id);
		Map<String,Object> map = new HashMap<String,Object>();
		if(suggestions!=null&&suggestions.size()>0){
			List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
			for(UserSuggestion suggestion:suggestions){
				Map<String,Object> d = new HashMap<String,Object>();
				d.put("id", String.valueOf(suggestion.getId()));
				d.put("nickname", suggestion.getUserNickname());
				d.put("time", String.valueOf(suggestion.getCreateTime().getTime()));
				d.put("suggestion", suggestion.getSuggestion());
				d.put("user_id", String.valueOf(suggestion.getUserId()));
				dataList.add(d);
			}
			map.put("suggestions", dataList);
		}
		result.setMap(map);
		return result ;
	}
	
	@RequestMapping(value = "/user/update_nickname", method = RequestMethod.POST, headers = { "Accept=application/json" })
	@ResponseBody()
	public APIResult updateNickname(@RequestBody Map<String,Object> data, HttpServletRequest request) {
		String szData = Utils.mapToString(data) ;
		logger.info("/user/update_nickname：data="+szData);
		
		String token = Utils.getMapValue(data, "token");
		String new_nickname = Utils.getMapValue(data, "new_nickname");
		
		commonService.insertActivity(Constants.ACTIVITY_UPDATE_NICKNAME, new_nickname, token, szData, request);
		
		APIResult result = new APIResult();
		long tokenUserId = userService.verifyUserToken(token);
		if(tokenUserId < 0 ){
			result.setCode(Constants.ERROR_INVALID_TOKEN);
			return result ;
		}
		
		User tokenUser = userService.getUser(tokenUserId);

		if(tokenUser==null || !tokenUser.isValid()){
			result.setCode(Constants.ERROR_INVALID_USER);
			return result ;
		}
		tokenUser.setNickName(new_nickname);
		String code = userService.updateUserNickname(tokenUser);
		Map<String,Object> map = new HashMap<String,Object>();
		if(Constants.SUCCESS_CODE.equals(code)){
			map.put("new_nickname", new_nickname);
		}
		result.setMap(map);
		return result ;
	}
}
