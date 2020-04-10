package com.hxk.service;

import java.util.List;

import com.hxk.entity.Modules;
import com.hxk.entity.Rolemodules;

public interface ModulesService {
	List<Modules> getAllMenu(String moduleIds) ;

	//添加
	int addroles(Modules modules);

	//修改
	int updateroles(Modules modules);

	//删除
	int delroles(String id);

	//通过角色ID来获取模块
	List<Rolemodules> getModulesId(String rolesId);

	//添加
	//int addroles(String id, String title);



}
