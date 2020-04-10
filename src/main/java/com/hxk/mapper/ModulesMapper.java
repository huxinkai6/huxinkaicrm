package com.hxk.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Param;

import com.hxk.annoation.ModulesProvider;
import com.hxk.entity.Modules;
import com.hxk.entity.Rolemodules;

public interface ModulesMapper {
	//获得所有模块
	@SelectProvider(type=ModulesProvider.class,method="getModules")
	public List<Modules> getAllMenu(@Param("moduleIds")String moduleIds);

	//添加
	int addroles(Map<String, Object> map);

	//修改
	int updateroles(Map<String, Object> map);

	//删除
	int delroles(String id);

	//通过中间表得到所有模块的id
		 @SelectProvider(type=ModulesProvider.class,method="getModulesId")
		public List<Rolemodules> getModulesId(@Param("rolesId")String rolesId);

		//public List<Modules> getAllMenu(String moduleIds);
		 
		 
		

}
