package com.hxk.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Param;

import com.hxk.annoation.ModulesProvider;
import com.hxk.entity.Modules;
import com.hxk.entity.Rolemodules;

public interface ModulesMapper {
	//�������ģ��
	@SelectProvider(type=ModulesProvider.class,method="getModules")
	public List<Modules> getAllMenu(@Param("moduleIds")String moduleIds);

	//���
	int addroles(Map<String, Object> map);

	//�޸�
	int updateroles(Map<String, Object> map);

	//ɾ��
	int delroles(String id);

	//ͨ���м��õ�����ģ���id
		 @SelectProvider(type=ModulesProvider.class,method="getModulesId")
		public List<Rolemodules> getModulesId(@Param("rolesId")String rolesId);

		//public List<Modules> getAllMenu(String moduleIds);
		 
		 
		

}
