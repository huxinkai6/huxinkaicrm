package com.hxk.service;

import java.util.List;

import com.hxk.entity.Modules;
import com.hxk.entity.Rolemodules;

public interface ModulesService {
	List<Modules> getAllMenu(String moduleIds) ;

	//���
	int addroles(Modules modules);

	//�޸�
	int updateroles(Modules modules);

	//ɾ��
	int delroles(String id);

	//ͨ����ɫID����ȡģ��
	List<Rolemodules> getModulesId(String rolesId);

	//���
	//int addroles(String id, String title);



}
