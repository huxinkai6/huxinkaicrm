package com.hxk.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hxk.entity.Roles;
import com.hxk.entity.Users;

public interface UserMapper {
	List<Users> getStus();

	//判断用户是否存在
	Users getUser(Map<String, Object> map);

	//通过用户的id获取角色
	List<Roles> findUsersRolesById(@Param("uid")String uid);

	//查询所有用户
	List<Users> getStus1(Map<String, Object> map);

	//获得所有数量
	int getCount();

	//添加
	int addUser(Map<String, Object> map);

	//修改
	int editUser(Map<String, Object> map);

	//删除
	int deleteUser(String id);

	//锁定
	int lockUser(Map<String, Object> map);

	//解锁
	int unLockUser(Map<String, Object> map);

	

}
