package com.cafe24.jblog.vo;

public class CommentVo {

	private long commentNo;
	private String content;
	private String regdate;
	private long postNo;
	private String postTitle;
	private UserVo userVo;
	
	public long getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(long commentNo) {
		this.commentNo = commentNo;
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
	public long getPostNo() {
		return postNo;
	}
	public void setPostNo(long postNo) {
		this.postNo = postNo;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public UserVo getUserVo() {
		return userVo;
	}
	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}
	
	@Override
	public String toString() {
		return "CommentVo [commentNo=" + commentNo + ", content=" + content + ", regdate=" + regdate + ", postNo="
				+ postNo + ", postTitle=" + postTitle + ", userVo=" + userVo + "]";
	}

}
