package com.hxk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxk.entity.Modules;
import com.hxk.entity.Rolemodules;
import com.hxk.entity.Roles;
import com.hxk.service.ModulesService;

import com.hxk.tools.LayUiTableData;



@Controller
@CrossOrigin
@RequestMapping("/modules")
public class ModulesController {
	
	@Resource(name = "modulesServiceImpl")
	ModulesService modulesService;
	
	
	
	//获取所有菜单
	@PostMapping(value = "/modules")
	@ResponseBody
	public Object modules(HttpServletRequest request,HttpServletResponse response,String moduleIds) throws Exception{//需要抛出异常
		List<Modules> MenuList = modulesService.getAllMenu(moduleIds);//获取所有的菜单
		//System.out.println("传值"+moduleIds);
		//System.out.println("模块"+MenuList.get(0).getName()+MenuList.get(1).getName());
		List<Modules> list =new ArrayList<Modules>();
		//System.out.println("我输入了"+moduleIds);
		for(int i=0;i<MenuList.size();i++){
			Modules typeEntity =MenuList.get(i);
			if(typeEntity.getParentId()==0){//获取第一级菜单
				list.add(typeEntity);//加入到list
			}
		}
		for(Modules entity1 : list){
			entity1.setChildNodes(getChildNodes(entity1.getId(),MenuList));//根据一级菜单获取二级菜单，并把它加入到list
		}
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();    //定义一个map处理json键名问题
		return fun(list, result);
		//return list;
		//return LayUiTableData.toClient(0, "删除成功!");
	}

	
	
	   private List<Modules> getChildNodes(Integer id, List<Modules> parentMenuList) throws Exception {
			// 子节点
			List<Modules> childList = new ArrayList<Modules>();
			// 把pmid=mid的子节点放到对应mid的父节点上
			for (Modules typeEntity : parentMenuList) {
				//if (typeEntity.getParentId() != null) {
					if (typeEntity.getParentId()==id) {
						childList.add(typeEntity);
					}
				//}
			}
			if (childList.size() == 0) {
				return null;
			}
			// Look up it's child node and fill
			for (Modules entity : childList) {
				entity.setChildNodes(getChildNodes(entity.getId(), parentMenuList));
			}
			return childList;
		}
       private Object fun(List<Modules> list, List<HashMap<String, Object>> result) {
		for(Modules d : list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", d.getId());//id，title，spread等的命名是layui需要的，所以需要把获取到的list重新遍历一遍并命名成layui需要的字段名称
			map.put("title", d.getName());
			map.put("path", d.getPath());
			map.put("spread", false);      //设置是否展开
			List<HashMap<String, Object>> result1 = new ArrayList<HashMap<String, Object>>();
			if(d.getChildNodes()!=null){
				List<Modules> children = d.getChildNodes();    //下级菜单
				//这里可以根据自己需求判断节点默认选中
//				if(d.getPmid() != null || d.getChildNodes().size() == 0){
//					map.put("checked", true);    //设置为选中状态
//				}
				map.put("children", fun(children, result1));
			}
			result.add(map);
		}
		return result;
	}
       //增加
       @PostMapping(value = "/add")
       @ResponseBody
       public Map<String, Object> addroles(Modules modules){
    	   System.out.println(modules.getName());
    	   System.out.println(modules.getParentId());
  		 int n = modulesService.addroles(modules);
  		if (n != 0) {
			return LayUiTableData.toClient(0, "添加成功!");
		} else {
			return LayUiTableData.toClient(1, "添加失败!");
		}
  		 
  	 }
       //修改
       @PostMapping(value = "/update")
       @ResponseBody
       public Map<String, Object> updateroles(Modules modules){
    	   System.out.println(modules.getName());
    	   System.out.println(modules.getParentId());
  		 int n = modulesService.updateroles(modules);
  		if (n != 0) {
			return LayUiTableData.toClient(0, "修改成功!");
		} else {
			return LayUiTableData.toClient(1, "修改失败!");
		}
  		 
  	 }
       //删除
       @PostMapping(value = "/del")
       @ResponseBody
       public Map<String, Object> delroles(String id){
    	   int n = modulesService.delroles(id);
    	   if (n != 0) {
   			return LayUiTableData.toClient(0, "删除成功!");
   		} else {
   			return LayUiTableData.toClient(1, "删除失败!");
   		}
    	  
       }
       
       //通过角色的ID来获取模块
       @PostMapping(value = "/getModulesId")
       @ResponseBody
       public Object getModulesId(String rolesId){
    	   List<Rolemodules> rolemodules = modulesService.getModulesId(rolesId);
    	   return  LayUiTableData.toClient1("0", "", 1, rolemodules);
    	   
       }
       
       
      
       
       
       
}






















