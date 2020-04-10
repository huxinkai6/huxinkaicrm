package com.hxk.service;

import java.util.List;

import com.hxk.entity.Roles;
import com.hxk.mapper.RolesMapper;


public interface RolesService {
	List<Roles> getAllRoles(Integer page, Integer limit);
	
	//获得总条数
	int getCountRoles();
	
	//添加角色
	int addroles(Roles roles);
	//修改角色
	int updataRoles(Roles roles);
	//删除角色
	int delete(String id);

	//穿梭框添加权限
	int addRolemodulesByRoleId(String role_id, int module_id, int a);
}
