package cn.xclick.bestsudokuserver.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

public class Utils {
	private static final Logger logger = Logger.getLogger(Utils.class);
	
	public static String getMapValue(Map<String,Object> map, String key){
		return getMapValue(map,key,"");
	}
	
	public static String getMapValue(Map<String,Object> map, String key, String def){
		if(map!=null && map.containsKey(key)){
			return map.get(key).toString();
		}
		return def ;
	}
	
	public static int getMapInt(Map<String,Object> map, String key, int def){
		try{
			int r = Integer.parseInt(getMapValue(map,key,String.valueOf(def))) ;
			return r ;
		}catch(Exception ex){
			logger.error(ex);
		}
		return def ;
	}
	
	public static int parseInt(Object obj) {
		try {
			String str = obj.toString();
			return Integer.parseInt(str);
		} catch (Exception ex) {
			logger.error(ex);	
		}
		return 0;
	}
	
	public static String formatDateTime(Date date){
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return fmt.format(date);
	}
	
	public static String mapToString(Map<String,Object> map){
		if(map==null||map.isEmpty()) return "{}";
		String str = "";
		for(Map.Entry<String, Object> entry:map.entrySet()){
			if(StringUtils.isEmpty(str)) str = "{" + entry.getKey()+"="+entry.getValue().toString();
			else str += "; " + entry.getKey()+"="+entry.getValue().toString();
		}
		str += "}" ;
		return str ;
	}
	
	public static String limitString(String source, int length){
		if(StringUtils.isEmpty(source)) return "" ;
		if(source.length()>length) return source.substring(0, length);
		return source ;
	}
	
	public static String newToken(){
		return UUID.randomUUID().toString().toLowerCase();
	}
	
	public static String getClientIP(HttpServletRequest request){
		String fromSource = "X-Real-IP";
		String ip = request.getHeader("X-Real-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For");
			fromSource = "X-Forwarded-For";
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
			fromSource = "Proxy-Client-IP";
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			fromSource = "WL-Proxy-Client-IP";
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			fromSource = "request.getRemoteAddr";
		}
		logger.debug("Client IP: "+ip+", fromSource: "+fromSource);
		return ip;
	}
}
