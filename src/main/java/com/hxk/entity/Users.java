package com.hxk.entity;


public class Users {
	private String Id;
	private String LoginName;
	private String Password;
	private String IsLockout;
	private String LastLoginTime;
	private String PsdWrongTime;
	private String LockTime;
	private String ProtectEMail;
	private String protectMTel;
	private String CreateTime;





	


	public Users(String id, String loginName, String password, String isLockout, String lastLoginTime,
			String psdWrongTime, String lockTime, String protectEMail, String protectMTel, String createTime) {
		super();
		Id = id;
		LoginName = loginName;
		Password = password;
		IsLockout = isLockout;
		LastLoginTime = lastLoginTime;
		PsdWrongTime = psdWrongTime;
		LockTime = lockTime;
		ProtectEMail = protectEMail;
		this.protectMTel = protectMTel;
		CreateTime = createTime;
	}








	public String getId() {
		return Id;
	}








	public void setId(String id) {
		Id = id;
	}








	public String getLoginName() {
		return LoginName;
	}








	public void setLoginName(String loginName) {
		LoginName = loginName;
	}








	public String getPassword() {
		return Password;
	}








	public void setPassword(String password) {
		Password = password;
	}








	public String getIsLockout() {
		return IsLockout;
	}








	public void setIsLockout(String isLockout) {
		IsLockout = isLockout;
	}








	public String getLastLoginTime() {
		return LastLoginTime;
	}








	public void setLastLoginTime(String lastLoginTime) {
		LastLoginTime = lastLoginTime;
	}








	public String getPsdWrongTime() {
		return PsdWrongTime;
	}








	public void setPsdWrongTime(String psdWrongTime) {
		PsdWrongTime = psdWrongTime;
	}








	public String getLockTime() {
		return LockTime;
	}








	public void setLockTime(String lockTime) {
		LockTime = lockTime;
	}








	public String getProtectEMail() {
		return ProtectEMail;
	}








	public void setProtectEMail(String protectEMail) {
		ProtectEMail = protectEMail;
	}








	public String getProtectMTel() {
		return protectMTel;
	}








	public void setProtectMTel(String protectMTel) {
		this.protectMTel = protectMTel;
	}








	public String getCreateTime() {
		return CreateTime;
	}








	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}








	public Users() {
		super();
	}
	
	

}
