package com.cafe24.jblog.dao.test;

import java.util.List;

import com.cafe24.jblog.dao.BlogDao;
import com.cafe24.jblog.dao.UserDao;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.UserVo;

public class BlogDaoTest {

	public static void main(String[] args) {
		BlogVo blog = new BlogVo();
		UserVo user = new UserVo();
		UserDao userDao = new UserDao();
		user = userDao.login("bitbit64", "12345").get(true);
		blog.setUserVo(user);
		blog.setTitle("블랙 컨슈머의 블로그");
		
		updateTest(blog);
		getListTest();
	}
	
	public static void updateTest(BlogVo blog) {
		BlogDao dao = new BlogDao();
		dao.insertBlog(blog);
	}
	
	public static void getListTest() {
		BlogDao dao = new BlogDao();
		List<BlogVo> blogs = dao.getListBlog();
		
		System.out.println("=============================================================");
		System.out.println("블로그 목록");
		System.out.println("=============================================================");
		for (BlogVo blog : blogs) {
			System.out.println("-------------------------------------------------------------");
			System.out.println(blog.getUserVo().getId()+"님의 블로그"
							+"\n제목: "+blog.getTitle());
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("=============================================================");
	}
}
