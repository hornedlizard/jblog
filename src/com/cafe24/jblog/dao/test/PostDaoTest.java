package com.cafe24.jblog.dao.test;

import java.util.List;

import com.cafe24.jblog.dao.CategoryDao;
import com.cafe24.jblog.dao.PostDao;
import com.cafe24.jblog.dao.UserDao;
import com.cafe24.jblog.vo.PostVo;
import com.cafe24.jblog.vo.UserVo;

public class PostDaoTest {

	public static void main(String[] args) {
		PostVo post = new PostVo();
		
		CategoryDao categoryDao = new CategoryDao();
		UserVo user = new UserVo();
		UserDao userDao = new UserDao();
		
		user = userDao.login("bitbit64", "12345").get(true);
		post.setCategoryVo(categoryDao.getCategory(1));
		post.setTitle("흐아암");
		post.setContent("11111111111111111111111");
		post.setUserVo(user);
		updateTest(post);

		user = userDao.login("bitbit64", "12345").get(true);
		post.setCategoryVo(categoryDao.getCategory(1));
		post.setTitle("두번째");
		post.setContent("22222222222222222222222");
		post.setUserVo(user);
		updateTest(post);
		
		getListTest(1);
	}
	
	public static void updateTest(PostVo post) {
		PostDao dao = new PostDao();
		dao.insertPost(post);
	}
	
	public static void getListTest(long userNo) {
		PostDao dao = new PostDao();
		List<PostVo> posts = dao.getListPost(userNo);
		
		System.out.println("=============================================================");
		System.out.println("포스트");
		System.out.println("=============================================================");
		System.out.println("-------------------------------------------------------------");
		for (PostVo post : posts) {
			System.out.println("제목: "+post.getTitle()
							+"\n내용: "+post.getContent()
							+"\n등록일: "+post.getRegdate()
							+"\n카테고리: "+post.getCategoryVo().getTitle()
							+"\n작성자: "+post.getUserVo().getId());
			System.out.println("-------------------------------------------------------------");
		}
		System.out.println("=============================================================");
	}
}
