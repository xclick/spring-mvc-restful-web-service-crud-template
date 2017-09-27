package cn.xclick.bestsudokuserver.data;

public class Constants {
	public static final Long INVALID_USER_ID = -1L ;

	public static final String DEFAULT_APP_VERSION = "-";
	// API code
	public static final String SUCCESS_CODE = "0" ;
	public static final String FAILURE_CODE = "-1" ;
	public static final String ERROR_INVALID_DATA = "-101" ;
	public static final String ERROR_TOKEN_EXPIRED = "-111" ;
	public static final String ERROR_NICKNAME_PASSWORD_EMPTY = "-112" ;
	public static final String ERROR_NICKNAME_EXISTS = "-113" ;
	public static final String ERROR_NICKNAME_NOT_EXISTS = "-114" ;
	public static final String ERROR_DEVICEUID_EMPTY = "-115" ;
	public static final String ERROR_PASSWORD_NOT_MATCH = "-116" ;
	public static final String ERROR_INVALID_TOKEN = "-117" ;
	public static final String ERROR_PASSWORD_EMPTY = "-118" ;
	public static final String ERROR_LOGOUT_ALREADY = "-119" ;
	public static final String ERROR_INVALID_USER = "-120" ;
	// Activity Type (Max 40)
	public static final String ACTIVITY_SIGNIN = "SIGNIN";
	public static final String ACTIVITY_CHECK_UPDATE = "CHECK_UPDATE";
	public static final String ACTIVITY_SUBMIT_SUGGESTION = "SUBMIT_SUGGESTION" ;
	public static final String ACTIVITY_UPDATE_NICKNAME = "UPDATE_NICKNAME";
	public static final String ACTIVITY_GET_SUGGESTIONS = "GET_SUGGESTIONS" ;
	
	public static final String ACTIVITY_SIGNOUT = "SIGNOUT";
	public static final String ACTIVITY_RENEW_TOKEN = "RENEW_TOKEN";
	public static final String ACTIVITY_UPDATE_PASSWORD = "UPDATE_PASSWORD";
	// Login Action Type
	public static final String LOGIN_ACTION_GET_TOKEN = "T" ;
	public static final String LOGIN_ACTION_REVOKE_TOKEN = "O" ;
	public static final String LOGIN_ACTION_RENEW_TOKEN = "R" ;
	//
	public static final String ACTIVE_ACTIVE = "A" ;
	public static final String ACTIVE_NOTACTIVE = "N" ; 
	//
	public static final String STATUS_YES = "Y" ;
	public static final String STATUS_NO = "N" ;
	// Token Expired Seconds
	public static final int TOKEN_EXPIRED_SECONDS = 1 * 60 * 60 ;
	
}
