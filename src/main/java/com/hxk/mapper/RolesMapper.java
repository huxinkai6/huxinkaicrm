package com.hxk.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.hxk.entity.Roles;

public interface RolesMapper {
	//获得角色
	List<Roles> getAllRoles(Map<String, Object> map);
	//获得总条数
	int getCountRoles();
	//添加用户
	int addroles(Map<String, Object> map);
	//修改角色
	int updataRoles(Map<String, Object> map);
	//删除
	int delete(String id);
	//删除权限
	@Delete("delete from rolemodules where roleid = #{role_id}")
	void delRoleModulesByRoleId(String role_id);

	//添加权限
	
		@Insert("insert into rolemodules values(uuid(),#{role_id},#{module_id})")
		int addRolemodulesByRoleId(@Param("role_id") String role_id, @Param("module_id") int module_id);

}
