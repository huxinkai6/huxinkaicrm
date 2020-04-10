package com.hxk.annoation;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.hxk.entity.Modules;



public class ModulesProvider {

	
	public String updataModules(Modules modules) {

		final Map<String, Object> params = new HashMap<String, Object>();

		params.put("Id", modules.getId());
		params.put("Name", modules.getName());
		params.put("ParentId", modules.getParentId());
		params.put("Path", modules.getPath());
		params.put("Weight", modules.getWeight());
		SQL sql = new SQL() {
			{
				INSERT_INTO("modules");
				if (params.get("Id") != null) {
					VALUES("Id", "#{Id}");
				}
				if (params.get("Name") != null) {
					VALUES("Name", "#{Name}");
				}
				if (params.get("ParentId") != null) {
					VALUES("ParentId", "#{ParentId}");
				}
				if (params.get("Path") != null) {
					VALUES("Path", "#{Path}");
				}
				if (params.get("Weight") != null) {
					VALUES("Weight", "#{Weight}");
				}
			}
		};
		return sql.toString();
	}

	public String delModules(final Map<String, Object> params) {
		SQL sql = new SQL() {
			{

				if (params.get("Id") != null) {

					DELETE_FROM("modules");
				}

				WHERE("Id = #{Id}");

			}
		};
		return sql.toString();
	}
	
	
	
	public String editModules(final Map<String, Object> params) {

		SQL sql = new SQL() {
			{
				UPDATE("modules");
				if (params.get("Name") != null) {
					SET("Name = #{Name}");
				}
				WHERE("Id = #{Id}");
			}
		};
		return sql.toString();
	}
	
	
	public String getModulesId(final Map<String, Object> params) {
		
		String[] roleId =((String) params.get("rolesId")).split(",");
		
		String sql = "select ModuleId from  rolemodules where roleId in (" ;
		
		for (int i = 0; i < roleId.length; i++) {
			if(i == 0) {
				sql+= " '"+roleId[i]+"'";
			}else {
				sql+= " ,'"+roleId[i]+"'";
			}
		}
		sql+=" )";
		return sql;
	}
	
	public String getModules(final Map<String, Object> params) {
		
		
		
		String sql = "select * from  modules " ;
		
		
		if(params.get("moduleIds")!=null) {
			
			String[] moduleIds =((String) params.get("moduleIds")).split(",");
			
			sql+="  where Id in (";
			
			for (int i = 0; i < moduleIds.length; i++) {
				if(i == 0) {
					sql+= " '"+moduleIds[i]+"'";
				}else {
					sql+= " ,'"+moduleIds[i]+"'";
				}
			}
			
			
			sql+=" ) or ParentId in(";
			for (int i = 0; i < moduleIds.length; i++) {
				if(i == 0) {
					sql+= " '"+moduleIds[i]+"'";
				}else {
					sql+= " ,'"+moduleIds[i]+"'";
				}
			}
			sql+=")";
			
		}
		return sql;
	}

	
	
	/*
	 * <select id="getModules" resultType="com.ysd.model.Modules">
	 * 
	 * SELECT * FROM modules <where> <if test="rolesId != null and rolesId != ''">
	 * Id in (SELECT ModuleId FROM rolemodules WHERE roleid in #{rolesId}) </if>
	 * </where> </select>
	 */
}
