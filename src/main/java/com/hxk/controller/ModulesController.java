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
	
	
	
	//��ȡ���в˵�
	@PostMapping(value = "/modules")
	@ResponseBody
	public Object modules(HttpServletRequest request,HttpServletResponse response,String moduleIds) throws Exception{//��Ҫ�׳��쳣
		List<Modules> MenuList = modulesService.getAllMenu(moduleIds);//��ȡ���еĲ˵�
		//System.out.println("��ֵ"+moduleIds);
		//System.out.println("ģ��"+MenuList.get(0).getName()+MenuList.get(1).getName());
		List<Modules> list =new ArrayList<Modules>();
		//System.out.println("��������"+moduleIds);
		for(int i=0;i<MenuList.size();i++){
			Modules typeEntity =MenuList.get(i);
			if(typeEntity.getParentId()==0){//��ȡ��һ���˵�
				list.add(typeEntity);//���뵽list
			}
		}
		for(Modules entity1 : list){
			entity1.setChildNodes(getChildNodes(entity1.getId(),MenuList));//����һ���˵���ȡ�����˵������������뵽list
		}
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();    //����һ��map����json��������
		return fun(list, result);
		//return list;
		//return LayUiTableData.toClient(0, "ɾ���ɹ�!");
	}

	
	
	   private List<Modules> getChildNodes(Integer id, List<Modules> parentMenuList) throws Exception {
			// �ӽڵ�
			List<Modules> childList = new ArrayList<Modules>();
			// ��pmid=mid���ӽڵ�ŵ���Ӧmid�ĸ��ڵ���
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
			map.put("id", d.getId());//id��title��spread�ȵ�������layui��Ҫ�ģ�������Ҫ�ѻ�ȡ����list���±���һ�鲢������layui��Ҫ���ֶ�����
			map.put("title", d.getName());
			map.put("path", d.getPath());
			map.put("spread", false);      //�����Ƿ�չ��
			List<HashMap<String, Object>> result1 = new ArrayList<HashMap<String, Object>>();
			if(d.getChildNodes()!=null){
				List<Modules> children = d.getChildNodes();    //�¼��˵�
				//������Ը����Լ������жϽڵ�Ĭ��ѡ��
//				if(d.getPmid() != null || d.getChildNodes().size() == 0){
//					map.put("checked", true);    //����Ϊѡ��״̬
//				}
				map.put("children", fun(children, result1));
			}
			result.add(map);
		}
		return result;
	}
       //����
       @PostMapping(value = "/add")
       @ResponseBody
       public Map<String, Object> addroles(Modules modules){
    	   System.out.println(modules.getName());
    	   System.out.println(modules.getParentId());
  		 int n = modulesService.addroles(modules);
  		if (n != 0) {
			return LayUiTableData.toClient(0, "��ӳɹ�!");
		} else {
			return LayUiTableData.toClient(1, "���ʧ��!");
		}
  		 
  	 }
       //�޸�
       @PostMapping(value = "/update")
       @ResponseBody
       public Map<String, Object> updateroles(Modules modules){
    	   System.out.println(modules.getName());
    	   System.out.println(modules.getParentId());
  		 int n = modulesService.updateroles(modules);
  		if (n != 0) {
			return LayUiTableData.toClient(0, "�޸ĳɹ�!");
		} else {
			return LayUiTableData.toClient(1, "�޸�ʧ��!");
		}
  		 
  	 }
       //ɾ��
       @PostMapping(value = "/del")
       @ResponseBody
       public Map<String, Object> delroles(String id){
    	   int n = modulesService.delroles(id);
    	   if (n != 0) {
   			return LayUiTableData.toClient(0, "ɾ���ɹ�!");
   		} else {
   			return LayUiTableData.toClient(1, "ɾ��ʧ��!");
   		}
    	  
       }
       
       //ͨ����ɫ��ID����ȡģ��
       @PostMapping(value = "/getModulesId")
       @ResponseBody
       public Object getModulesId(String rolesId){
    	   List<Rolemodules> rolemodules = modulesService.getModulesId(rolesId);
    	   return  LayUiTableData.toClient1("0", "", 1, rolemodules);
    	   
       }
       
       
      
       
       
       
}






















