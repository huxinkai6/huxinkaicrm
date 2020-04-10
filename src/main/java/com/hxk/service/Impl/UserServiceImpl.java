package com.hxk.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxk.entity.Roles;
import com.hxk.entity.Users;

import com.hxk.mapper.UserMapper;
import com.hxk.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper usermapper;

	public List<Users> findAllStu() {
		// TODO Auto-generated method stub
		return usermapper.getStus();
	}
//判断用户是否存在
	public Users getUser(String name, String pass) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("pass", pass);
		return usermapper.getUser(map);
	}
	
	//通过用户的id获取角色
	public List<Roles> findUsersRolesById(String uid) {
		System.out.println("imple"+uid);
		return usermapper.findUsersRolesById(uid);
	}
	public List<Users> findAllStu(Integer page, Integer limit, Users users) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("limit", limit);
		map.put("Id", users.getId());
		map.put("LoginName", users.getLoginName());
		map.put("Password", users.getPassword());
		map.put("IsLockout", users.getIsLockout());
		map.put("LastLoginTime", users.getLastLoginTime());
		map.put("PsdWrongTime", users.getPsdWrongTime());
		map.put("LockTime", users.getLockTime());
		map.put("ProtectEMail", users.getProtectEMail());
		map.put("protectMTel", users.getProtectMTel());
		map.put("CreateTime", users.getCreateTime());
		return usermapper.getStus1(map);
	}
	public int findCount() {
		// TODO Auto-generated method stub
		return usermapper.getCount();
	}
	public int addStu(Users users) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("LoginName", users.getLoginName());
		map.put("Password", users.getPassword());
		map.put("IsLockout", users.getIsLockout());
		map.put("LockTime", users.getLockTime());
		map.put("LastLoginTime", users.getLastLoginTime());
		map.put("PsdWrongTime", users.getPsdWrongTime());
		map.put("ProtectEMail", users.getProtectEMail());
		map.put("protectMTel", users.getProtectMTel());
		map.put("CreateTime", users.getCreateTime());
		map.put("Id", users.getId());
		return usermapper.addUser(map);
	}
	public int editUser(Users users) {
		// TODO Auto-generated method stub
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("LoginName", users.getLoginName());
				map.put("Password", users.getPassword());
				map.put("IsLockout", users.getIsLockout());
				map.put("LockTime", users.getLockTime());
				map.put("LastLoginTime", users.getLastLoginTime());
				map.put("PsdWrongTime", users.getPsdWrongTime());
				map.put("ProtectEMail", users.getProtectEMail());
				map.put("protectMTel", users.getProtectMTel());
				map.put("CreateTime", users.getCreateTime());
				map.put("Id", users.getId());
				return usermapper.editUser(map);
	}
	public int deleteUser(String id) {
		// TODO Auto-generated method stub
		return usermapper.deleteUser(id);
	}
	public int lockUser(String id, String isLockout, String d) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("IsLockout", isLockout);
		map.put("lockTime", d);
		map.put("Id", id);
		return usermapper.lockUser(map);
	}
	public int unLockUser(String id, String isLockout, String d) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("IsLockout", isLockout);
		map.put("lockTime", d);
		map.put("Id", id);
		return usermapper.unLockUser(map);
	}
	

}
