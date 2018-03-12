package com.cafe24.jblog.vo;

public class PostVo {

	private long postNo;
	private String title;
	private String content;
	private String regdate;
	private CategoryVo categoryVo;
	private UserVo userVo;
	
	public long getPostNo() {
		return postNo;
	}
	public void setPostNo(long postNo) {
		this.postNo = postNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public CategoryVo getCategoryVo() {
		return categoryVo;
	}
	public void setCategoryVo(CategoryVo categoryVo) {
		this.categoryVo = categoryVo;
	}
	public UserVo getUserVo() {
		return userVo;
	}
	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}
	
	@Override
	public String toString() {
		return "PostVo [postNo=" + postNo + ", title=" + title + ", content=" + content + ", regdate=" + regdate
				+ ", categoryVo=" + categoryVo + ", userVo=" + userVo + "]";
	}
	
}
