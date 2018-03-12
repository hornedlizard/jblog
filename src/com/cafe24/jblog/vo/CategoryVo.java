package com.cafe24.jblog.vo;

public class CategoryVo {

	private long categoryNo;
	private String title;
	private String comm;
	
	public long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComm() {
		return comm;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
	
	@Override
	public String toString() {
		return "CategoryVo [categoryNo=" + categoryNo + ", title=" + title + ", comm=" + comm + "]";
	}
	
}
