package cn.xclick.bestsudokuserver.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.xclick.bestsudokuserver.model.User;
import cn.xclick.bestsudokuserver.model.UserLogin;
import cn.xclick.bestsudokuserver.model.UserLoginLog;
import cn.xclick.bestsudokuserver.model.UserSuggestion;

public interface UserDao {
	public void createUser(User user);
	public void createUserLogin(UserLogin data);
	public void createUserLoginLog(UserLoginLog data);
	public User getUserById(Long id);
	public User getUserByDeviceUid(String deviceUid);
	public Map<String, Object> getNicknameSeqWithoutUse();
	public void updateNicknameSeqUsed(@Param("id")int id);
	public UserLogin getUserLoginByToken(String token) ;
	public List<User> getTotalUserList();
	public void createUseSuggestion(UserSuggestion data);
	public void updateUserNickname(User user);
	public List<UserSuggestion> getSuggestions(int id);
}
