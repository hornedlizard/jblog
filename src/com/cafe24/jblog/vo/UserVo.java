package com.cafe24.jblog.vo;

public class UserVo {

	private long userNo;
	private String id;
	private String password;
	
	public long getUserNo() {
		return userNo;
	}
	public void setUserNo(long userNo) {
		this.userNo = userNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", id=" + id + ", password=" + password + "]";
	}
	
}
