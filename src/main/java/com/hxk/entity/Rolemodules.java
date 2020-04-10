package com.hxk.entity;

public class Rolemodules {
	
	private String Id;
	private String RoleId;
	private Integer ModuleId;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getRoleId() {
		return RoleId;
	}
	public void setRoleId(String roleId) {
		RoleId = roleId;
	}
	public Integer getModuleId() {
		return ModuleId;
	}
	public void setModuleId(Integer moduleId) {
		ModuleId = moduleId;
	}
	public Rolemodules(String id, String roleId, Integer moduleId) {
		super();
		Id = id;
		RoleId = roleId;
		ModuleId = moduleId;
	}
	public Rolemodules() {
		super();
	}
	@Override
	public String toString() {
		return "Rolemodules [Id=" + Id + ", RoleId=" + RoleId + ", ModuleId=" + ModuleId + "]";
	}
	
	
	
}
