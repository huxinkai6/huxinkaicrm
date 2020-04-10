package com.hxk.service;

import java.util.List;

import com.hxk.entity.Roles;
import com.hxk.entity.Users;

public interface UserService {
	//查询所有用户
	List<Users> findAllStu(Integer page, Integer limit, Users users);

	//判断用户是否存在
	Users getUser(String name, String pass);

	//通过用户的id获取角色
	List<Roles> findUsersRolesById(String uid);
//获得所有数量
	int findCount();

	//添加
	int addStu(Users users);

	//修改
	int editUser(Users users);

	//删除
	int deleteUser(String id);

	//锁定
	int lockUser(String id, String isLockout, String d);

	//解锁
	int unLockUser(String id, String isLockout, String d);

}
