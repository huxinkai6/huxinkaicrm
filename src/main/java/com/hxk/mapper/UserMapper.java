package com.hxk.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hxk.entity.Roles;
import com.hxk.entity.Users;

public interface UserMapper {
	List<Users> getStus();

	//�ж��û��Ƿ����
	Users getUser(Map<String, Object> map);

	//ͨ���û���id��ȡ��ɫ
	List<Roles> findUsersRolesById(@Param("uid")String uid);

	//��ѯ�����û�
	List<Users> getStus1(Map<String, Object> map);

	//�����������
	int getCount();

	//���
	int addUser(Map<String, Object> map);

	//�޸�
	int editUser(Map<String, Object> map);

	//ɾ��
	int deleteUser(String id);

	//����
	int lockUser(Map<String, Object> map);

	//����
	int unLockUser(Map<String, Object> map);

	

}
