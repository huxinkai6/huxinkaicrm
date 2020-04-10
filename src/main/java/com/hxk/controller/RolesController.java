package com.hxk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxk.entity.Roles;
import com.hxk.service.RolesService;
import com.hxk.service.UserService;
import com.hxk.tools.LayUiTableData;

@Controller
@CrossOrigin
@RequestMapping("/roles")
public class RolesController {
	@Autowired
	RolesService rolesservice;

	@PostMapping(value = "/roles")
	@ResponseBody
	public Map<String, Object> roles(Integer page, Integer limit) {
		page = (page - 1) * limit;
		List<Roles> list = rolesservice.getAllRoles(page, limit);
		int count = rolesservice.getCountRoles();
		return LayUiTableData.toClient(0, "", count, list);
	}

	
	//���
	 @PostMapping(value = "/addroles")
	 @ResponseBody
	 public Map<String, Object> addroles(Roles roles){
		 int n = rolesservice.addroles(roles);
		 return LayUiTableData.toClient(0, "��ӳɹ�");
		 
	 }
	 //�޸�
	 @PostMapping(value = "/update")
	 @ResponseBody
	 public Map<String, Object> update(Roles roles){
		 int n = rolesservice.updataRoles(roles);
		 return LayUiTableData.toClient(0, "�޸ĳɹ�");
		 
	 }
	 //ɾ����ɫ
	 @PostMapping(value = "/delete")
	 @ResponseBody
	 public Map<String, Object> delete(String id){
		 int n = rolesservice.delete(id);
		 return LayUiTableData.toClient(0, "ɾ���ɹ�");
		 
	 }
	 //����Ȩ��
	 @PostMapping(value = "/addrolesbuyid")
	 @ResponseBody
	 public int addRolemodulesByRoleId(String role_id, @RequestParam(value = "checkedData[]") int[] arr) {
			System.out.println("������");
		 List<Integer> count = new ArrayList<Integer>();
			int a = 0;
			for (int i = 0; i < arr.length; i++) {
				int module_id = arr[i];
				// ��ӽ�ɫ��Ȩ��
				a += 1;
				int n = rolesservice.addRolemodulesByRoleId(role_id, module_id, a);
				if (n != 0) {
					count.add(n);
				}
			}
			if (count.size() != 0) {
				return 0;
			} else {
				return 1;
			}

		}
	 
	 
	

}






















