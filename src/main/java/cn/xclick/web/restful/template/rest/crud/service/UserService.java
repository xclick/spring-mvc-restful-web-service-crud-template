package cn.xclick.web.restful.template.rest.crud.service;

import java.util.List;

import cn.xclick.web.restful.template.rest.crud.model.User;

public interface UserService {
	boolean create(User user);
	boolean delete(int id);
	List<User> getAll(int offset, int count);
	User get(int id);
	boolean update(User user);
	boolean exists(User user);
}
