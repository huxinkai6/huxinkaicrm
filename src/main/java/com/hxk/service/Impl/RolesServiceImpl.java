package com.hxk.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxk.entity.Roles;
import com.hxk.mapper.RolesMapper;
import com.hxk.mapper.UserMapper;
import com.hxk.service.RolesService;
@Service
@Transactional
public class RolesServiceImpl implements RolesService{
	@Autowired
	private RolesMapper rolesMapper;

	public List<Roles> getAllRoles(Integer page, Integer limit) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("limit", limit);
		return rolesMapper.getAllRoles(map);
	}

	public int getCountRoles() {
		// TODO Auto-generated method stub
		return rolesMapper.getCountRoles();
	}

	//添加角色
	public int addroles(Roles roles) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", roles.getName());
		map.put("id", roles.getId());
		return rolesMapper.addroles(map);
	}
	//修改角色

	public int updataRoles(Roles roles) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", roles.getName());
		map.put("id", roles.getId());
		return rolesMapper.updataRoles(map);
	}

	//删除角色
	public int delete(String id) {
		return rolesMapper.delete(id);
	}

	//穿梭框添加权限
	public int addRolemodulesByRoleId(String role_id, int module_id, int a) {
		// TODO Auto-generated method stub
		if (a == 0) {
			rolesMapper.delRoleModulesByRoleId(role_id);
		}
		return rolesMapper.addRolemodulesByRoleId(role_id, module_id);
		
	
	}
	

	

	

	

	

}
