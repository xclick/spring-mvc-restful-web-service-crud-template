package cn.xclick.bestsudokuserver.service;

import java.util.List;
import java.util.Map;

import cn.xclick.bestsudokuserver.model.User;
import cn.xclick.bestsudokuserver.model.UserSuggestion;

public interface UserService {
	public String signIn(Map<String,Object> data, String fromIp, StringBuilder token, StringBuilder nickName,
			StringBuilder userId);
	public long verifyUserToken(String token);
	public String submitSuggestion(UserSuggestion userSuggestion);
	public String updateUserNickname(User user);
	public User getUser(long userId);
	public List<UserSuggestion> getSuggestions(String id);
}
