package cn.xclick.web.restful.template.rest.crud.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.xclick.web.restful.template.rest.crud.model.User;

public interface UserMapper {
	int create(User user);
	int delete(int id);
	List<User> getAll(@Param("offset")int offset, @Param("count")int count);
	List<User> get(User user);
	int update(User user);
}
