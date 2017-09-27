package cn.xclick.bestsudokuserver.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xclick.bestsudokuserver.data.Constants;
import cn.xclick.bestsudokuserver.magiccrypt.MagicCrypt;
import cn.xclick.bestsudokuserver.model.APIResult;
import cn.xclick.bestsudokuserver.utils.Utils;

@Controller
public class CryptController {
	private static final Logger logger = Logger.getLogger(CryptController.class);
	public final static String ENCRYPT_KEY_FOR_KEY = "MW62tGlY";
	public final static String ENCRYPT_KEY_FOR_DATA = "6Mqodw2W";
	
	@RequestMapping(value = "/crypt/encrypt", method = RequestMethod.POST, headers = { "Accept=application/json" })
	@ResponseBody()
	public APIResult doEncrypt(@RequestBody Map<String,Object> data, HttpServletRequest request) {
		String szData = Utils.mapToString(data) ;
		logger.info("/crypt/encrypt：data="+szData);
		
		String content = Utils.getMapValue(data, "content");
		String type = Utils.getMapValue(data, "type");
		APIResult result = new APIResult();
		if("XLTPqlhn".equals(type)){
			result.setCode("1");
			result.setMessage(encrypt(content,ENCRYPT_KEY_FOR_DATA));
		}else if("bqZobSYH".equals(type)){
			result.setCode("2");
			result.setMessage(encrypt(content,ENCRYPT_KEY_FOR_KEY));
		}else{
			result.setCode("3");
			result.setMessage("");
		}
		return result ;
	}
	
	private String encrypt(String source, String key){
		// 只能用128，否则出现invalid key size 的错误
		final MagicCrypt mc = new MagicCrypt(key, 128);
		return mc.encrypt(source);
	}
}
