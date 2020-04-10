package com.hxk.service;

import java.util.List;

import com.hxk.entity.Roles;
import com.hxk.entity.Users;

public interface UserService {
	//��ѯ�����û�
	List<Users> findAllStu(Integer page, Integer limit, Users users);

	//�ж��û��Ƿ����
	Users getUser(String name, String pass);

	//ͨ���û���id��ȡ��ɫ
	List<Roles> findUsersRolesById(String uid);
//�����������
	int findCount();

	//���
	int addStu(Users users);

	//�޸�
	int editUser(Users users);

	//ɾ��
	int deleteUser(String id);

	//����
	int lockUser(String id, String isLockout, String d);

	//����
	int unLockUser(String id, String isLockout, String d);

}
