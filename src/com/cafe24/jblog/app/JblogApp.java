package com.cafe24.jblog.app;

import com.cafe24.jblog.dao.CategoryDao;
import com.cafe24.jblog.dao.UserDao;
import com.cafe24.jblog.dao.test.BlogDaoTest;
import com.cafe24.jblog.dao.test.CategoryDaoTest;
import com.cafe24.jblog.dao.test.CommentDaoTest;
import com.cafe24.jblog.dao.test.PostDaoTest;
import com.cafe24.jblog.dao.test.UserDaoTest;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.CommentVo;
import com.cafe24.jblog.vo.PostVo;
import com.cafe24.jblog.vo.UserVo;

public class JblogApp {

	public static void main(String[] args) {
		
		UserVo user = new UserVo();
		user.setId("bitbit64");
		user.setPassword("12345");
		UserDaoTest.updateTest(user);
		UserDaoTest.getListTest();
		UserDaoTest.login("bitbit64", "12345");
		
		BlogVo blog = new BlogVo();
		user = new UserVo();
		UserDao userDao = new UserDao();
		user = userDao.login("bitbit64", "12345").get(true);
		blog.setUserVo(user);
		blog.setTitle("블랙 컨슈머의 블로그");
		BlogDaoTest.updateTest(blog);
		BlogDaoTest.getListTest();
		
		CategoryVo category = new CategoryVo();
		category.setTitle("맛집");
		category.setComm("지원받았습니다.");
		CategoryDaoTest.updateTest(category);
		category.setTitle("영화리뷰");
		category.setComm("노잼들");
		CategoryDaoTest.updateTest(category);
		category.setTitle("책리뷰");
		category.setComm("노잼들");
		CategoryDaoTest.updateTest(category);
		CategoryDaoTest.getListTest();
		
		PostVo post = new PostVo();
		CategoryDao categoryDao = new CategoryDao();
		user = new UserVo();
		userDao = new UserDao();
		user = userDao.login("bitbit64", "12345").get(true);
		post.setCategoryVo(categoryDao.getCategory(1));
		post.setTitle("흐아암");
		post.setContent("11111111111111111111111");
		post.setUserVo(user);
		PostDaoTest.updateTest(post);
		user = userDao.login("bitbit64", "12345").get(true);
		post.setCategoryVo(categoryDao.getCategory(1));
		post.setTitle("두번째");
		post.setContent("22222222222222222222222");
		post.setUserVo(user);
		PostDaoTest.updateTest(post);
		PostDaoTest.getListTest(1);
		
		long postNo1 = 1;
		CommentVo comment = new CommentVo();
		user = new UserVo();
		userDao = new UserDao();
		user = userDao.login("bitbit64", "12345").get(true);
		comment.setUserVo(user);
		comment.setPostNo(postNo1);
		comment.setContent("ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
		CommentDaoTest.updateTest(comment);

		user = userDao.login("bitbit64", "12345").get(true);
		comment.setUserVo(user);
		comment.setPostNo(postNo1);
		comment.setContent("oooooooooooooo");
		CommentDaoTest.updateTest(comment);

		long postNo2 = 2;
		user = userDao.login("bitbit64", "12345").get(true);
		comment.setUserVo(user);
		comment.setPostNo(postNo2);
		comment.setContent("ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
		CommentDaoTest.updateTest(comment);
		
		user = userDao.login("bitbit64", "12345").get(true);
		comment.setUserVo(user);
		comment.setPostNo(postNo2);
		comment.setContent("oooooooooooooo");
		CommentDaoTest.updateTest(comment);
		
		CommentDaoTest.getListTest(postNo1);
		CommentDaoTest.getListTest(postNo2);
	}
}
