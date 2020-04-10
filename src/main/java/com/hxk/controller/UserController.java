package com.hxk.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hxk.entity.Roles;
import com.hxk.entity.Users;
import com.hxk.service.UserService;
import com.hxk.tools.CommonUtil;
import com.hxk.tools.LayUiTableData;
import com.hxk.tools.RedisTrans;
import com.hxk.tools.Result;
@Controller
@CrossOrigin
@RequestMapping("/stu")
public class UserController {
	@Autowired
	UserService userservice;
	@Resource
	private RedisTrans redisTrans;
	
	

	//��½
	@RequestMapping(method = RequestMethod.POST,value = "/login")
	@ResponseBody
	public Map<String, Object> login(String name,String pass) {
		System.out.println(name);
		System.out.println(pass);
		Map<String, Object> returnMap = CommonUtil.getResultMap();
		//���ж��û��Ƿ����
		Users user = userservice.getUser(name,pass);
		if(user!=null) {
			String uid = user.getId();
			// ��װmessage��Ϣ
			Map<String, Object> messageMap = new HashMap<String, Object>();
			messageMap.put("uid", uid);
			returnMap.put("message", messageMap);
			returnMap.put("success", true);

			redisTrans.setStringAndTimeOut("UserId", uid, 3000);
			redisTrans.setStringAndTimeOut("loginUsername", user.getLoginName(), 3000);
			//System.out.println("qwqee");
			return returnMap;
		}else {
			//String a = redisTrans.getString("userId");
			returnMap.put("message", "�˺Ż����������");
			returnMap.put("success", false);
		}
		return returnMap;
		
	
	} 
	//��ȡ��½��redis��id����������ֵ��ҳ��
	@RequestMapping(method = RequestMethod.POST,value = "/sessionTime")
	@ResponseBody
	public Map<String, Object> sessionTime() {
		//������ͨ��redis��ȡ��½���id������
		return LayUiTableData.toClient1("1", "",redisTrans.getString("UserId"),redisTrans.getString("loginUsername"));
	}
	
	//ͨ��id��ȡ���еĽ�ɫ
	@RequestMapping(method = RequestMethod.POST,value = "/usersRolesById")
	@ResponseBody
	public Map<String, Object> sessionTime(String Uid) {
		String uid = Uid;
		System.out.println("�û�id"+uid+Uid);
		List<Roles> roles = userservice.findUsersRolesById(uid);
		System.out.println(roles);
		return LayUiTableData.toClient1("0", "", 1, roles);
		
	}
	
	
	//��ʾ����
	@PostMapping("/stus")
	@ResponseBody
	public Map<String, Object> getAllUsers(Integer page, Integer limit, Users users) {
		page = (page - 1) * limit;
		List<Users> list = userservice.findAllStu(page, limit, users);
		System.out.println("1111111111111111111111111111111111111111111111111111111111");
		int count = userservice.findCount();
		return Result.toClient("","",count,list);
	}
	
	//���
		@PostMapping("/addStus")
		@ResponseBody
		public Map<String, Object> addUsers(Users users) {
			int a = userservice.addStu(users);
			System.out.println("22222222222222222222222222222222222222222222222222222222222");
			if(a!=0) {
				return Result.toClient(0,"��ӳɹ�");
			}else {
				return Result.toClient(1,"���ʧ��");
			}
			
		}
		//�޸�
		@PostMapping("/updataUser")
		@ResponseBody
		public Map<String, Object> updataUser(Users users) {
			int b = userservice.editUser(users);
			System.out.println("33333333333333333333333333333333333333333333333333333333333");
			if(b!=0) {
				return Result.toClient(0,"�޸ĳɹ�");
			}else {
				return Result.toClient(1,"�޸�ʧ��");
			}
			
		}
		//ɾ��
		@PostMapping("/deleteUser")
		@ResponseBody
		public Map<String, Object> deleteUser(String id) {
			int c = userservice.deleteUser(id);
			System.out.println("444444444444444444444444444444444444444444444444444444444444");
			System.out.println(id);
			if(c>0) {
				return Result.toClient(0,"ɾ���ɹ�");
			}else {
				return Result.toClient(1,"ɾ��ʧ��");
			}
			
		}
	
		//����
		@PostMapping("/lock")
		@ResponseBody
		public Map<String, Object> lockUser(String id,String isLockout) {
			System.out.println("55555555555555555555555555555555555555555555555555555555555");
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String d = sdf.format(date);
			System.out.println(isLockout);
			int n = userservice.lockUser(id, isLockout, d);
			System.out.println(d);
			if(n>0) {
				return Result.toClient(0,"�����ɹ�");
			}else {
				return Result.toClient(1,"����ʧ��");
			}
			
		}
	
		//����
		@PostMapping("/unlock")
		@ResponseBody
		public Map<String, Object> unLockUser(String id,String isLockout) {
			System.out.println("666666666666666666666666666666666666666666666666666666666");
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String d = sdf.format(date);
			int n = userservice.unLockUser(id, isLockout, d);
			if(n>0) {
				return Result.toClient(0,"�����ɹ�");
			}else {
				return Result.toClient(1,"����ʧ��");
			}
			
		}
	
	
	
	
	
	
	
	
	
	
	

}
