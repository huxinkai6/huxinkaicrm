package com.hxk.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.hxk.entity.Roles;

public interface RolesMapper {
	//��ý�ɫ
	List<Roles> getAllRoles(Map<String, Object> map);
	//���������
	int getCountRoles();
	//����û�
	int addroles(Map<String, Object> map);
	//�޸Ľ�ɫ
	int updataRoles(Map<String, Object> map);
	//ɾ��
	int delete(String id);
	//ɾ��Ȩ��
	@Delete("delete from rolemodules where roleid = #{role_id}")
	void delRoleModulesByRoleId(String role_id);

	//���Ȩ��
	
		@Insert("insert into rolemodules values(uuid(),#{role_id},#{module_id})")
		int addRolemodulesByRoleId(@Param("role_id") String role_id, @Param("module_id") int module_id);

}
