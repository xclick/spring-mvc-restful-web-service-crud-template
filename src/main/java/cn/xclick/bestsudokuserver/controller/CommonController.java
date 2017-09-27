package cn.xclick.bestsudokuserver.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xclick.bestsudokuserver.data.Constants;
import cn.xclick.bestsudokuserver.model.APIResult;
import cn.xclick.bestsudokuserver.model.Application;
import cn.xclick.bestsudokuserver.model.User;
import cn.xclick.bestsudokuserver.service.CommonService;
import cn.xclick.bestsudokuserver.service.UserService;
import cn.xclick.bestsudokuserver.utils.Utils;

@Controller
public class CommonController extends BaseController {
	private static final Logger logger = Logger.getLogger(CommonController.class);
	
	@RequestMapping(value = "/application/check_update", method = RequestMethod.POST, headers = { "Accept=application/json" })
	@ResponseBody()
	public APIResult checkUpdate(@RequestBody Map<String,Object> data, HttpServletRequest request) {
		String szData = Utils.mapToString(data) ;
		logger.info("/application/check_update：data="+szData);
		
		String token = Utils.getMapValue(data, "token");
		String version = Utils.getMapValue(data, "version");
		
		commonService.insertActivity(Constants.ACTIVITY_CHECK_UPDATE, version, token, szData, request);
		
		APIResult result = new APIResult();
		long tokenUserId = userService.verifyUserToken(token);
		if(tokenUserId < 0 ){
			result.setCode(Constants.ERROR_INVALID_TOKEN);
			return result ;
		}
		
		Application lastVersion = commonService.checkUpdate(version);
		Map<String,Object> map = new HashMap<String,Object>();
		String last_version = "";
		String release_note = "";
		String download_url = "";
		if(lastVersion!=null){
			last_version = lastVersion.getVersion();
			release_note = lastVersion.getReleaseNote();
			download_url = lastVersion.getDownloadUrl();
		}
		map.put("last_version", last_version);
		map.put("release_note", release_note);
		map.put("download_url", download_url);
		result.setMap(map);
		return result ;
	}
	
	
}
