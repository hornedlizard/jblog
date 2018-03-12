package com.cafe24.jblog.dao.test;

import java.util.List;

import com.cafe24.jblog.dao.CommentDao;
import com.cafe24.jblog.dao.UserDao;
import com.cafe24.jblog.vo.CommentVo;
import com.cafe24.jblog.vo.UserVo;

public class CommentDaoTest {

	public static void main(String[] args) {
		long postNo1 = 1;
		CommentVo comment = new CommentVo();
		UserVo user = new UserVo();
		UserDao userDao = new UserDao();
		user = userDao.login("bitbit64", "12345").get(true);
		comment.setUserVo(user);
		comment.setPostNo(postNo1);
		comment.setContent("ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
		updateTest(comment);

		user = userDao.login("bitbit64", "12345").get(true);
		comment.setUserVo(user);
		comment.setPostNo(postNo1);
		comment.setContent("oooooooooooooo");
		updateTest(comment);

		long postNo2 = 2;
		user = userDao.login("bitbit64", "12345").get(true);
		comment.setUserVo(user);
		comment.setPostNo(postNo2);
		comment.setContent("ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
		updateTest(comment);
		
		user = userDao.login("bitbit64", "12345").get(true);
		comment.setUserVo(user);
		comment.setPostNo(postNo2);
		comment.setContent("oooooooooooooo");
		updateTest(comment);
		
		getListTest(postNo1);
		getListTest(postNo2);
	}
	
	public static void updateTest(CommentVo comment) {
		CommentDao dao = new CommentDao();
		dao.insertComment(comment);
	}
	
	public static void getListTest(long postNo) {
		CommentDao dao = new CommentDao();
		List<CommentVo> comments = dao.getListComment(postNo);
		
		System.out.println("=============================================================");
		System.out.println("댓글");
		System.out.println("=============================================================");
		System.out.println("-------------------------------------------------------------");
		for (CommentVo comment : comments) {
			System.out.println("댓글번호: " + comment.getCommentNo()
							+" | "+comment.getUserVo().getId()+"님의 댓글"
							+"\n등록일"+comment.getRegdate()
							+"\n"+comment.getContent());
			System.out.println("-------------------------------------------------------------");
		}
		System.out.println("=============================================================");
	}
}
