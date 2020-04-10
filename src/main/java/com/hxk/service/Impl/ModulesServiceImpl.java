package com.hxk.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxk.entity.Modules;
import com.hxk.entity.Rolemodules;
import com.hxk.mapper.ModulesMapper;
import com.hxk.mapper.RolesMapper;
import com.hxk.service.ModulesService;
@Service
@Transactional
public class ModulesServiceImpl implements ModulesService{
	@Resource
	private ModulesMapper modulesmapper;

	public List<Modules> getAllMenu(String moduleIds) {
		// TODO Auto-generated method stub
		return modulesmapper.getAllMenu(moduleIds);
	}

	public int addroles(Modules modules) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", modules.getName());
		map.put("parentid", modules.getParentId());
		map.put("path",modules.getPath());
		map.put("weight", modules.getWeight());
		
		return modulesmapper.addroles(map);
	}

	//修改
	public int updateroles(Modules modules) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", modules.getName());
		map.put("parentid", modules.getParentId());
		map.put("path",modules.getPath());
		map.put("weight", modules.getWeight());
		
		return modulesmapper.updateroles(map);
	}

	//删除
	public int delroles(String id) {
		return modulesmapper.delroles(id);
	}

	//通过角色id来获取模块ID
	public List<Rolemodules> getModulesId(String rolesId) {
		// TODO Auto-generated method stub
		return modulesmapper.getModulesId(rolesId);
	}

	//添加
	/*
	 * public int addroles(String id, String title) { Map<String, Object> map = new
	 * HashMap<String, Object>(); map.put("id", id); map.put("title", title);
	 * 
	 * return modulesmapper.addroles(map); }
	 */

}























