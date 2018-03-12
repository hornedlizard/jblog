package com.cafe24.jblog.vo;

public class BlogVo {

	private UserVo user; // userNo == blogNo
	private String title;
	
	public UserVo getUserVo() {
		return user;
	}
	public void setUserVo(UserVo user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "BlogVo [user=" + user + ", title=" + title + "]";
	}
	
}
