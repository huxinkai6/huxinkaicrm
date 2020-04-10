package com.hxk.service;

import java.util.List;

import com.hxk.entity.Roles;
import com.hxk.mapper.RolesMapper;


public interface RolesService {
	List<Roles> getAllRoles(Integer page, Integer limit);
	
	//���������
	int getCountRoles();
	
	//��ӽ�ɫ
	int addroles(Roles roles);
	//�޸Ľ�ɫ
	int updataRoles(Roles roles);
	//ɾ����ɫ
	int delete(String id);

	//��������Ȩ��
	int addRolemodulesByRoleId(String role_id, int module_id, int a);
}
