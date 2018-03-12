package com.cafe24.jblog.dao.test;

import java.util.HashMap;
import java.util.List;

import com.cafe24.jblog.dao.UserDao;
import com.cafe24.jblog.vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) {
		UserVo user = new UserVo();
		user.setId("bitbit64");
		user.setPassword("12345");
		updateTest(user);
		getListTest();
		login("bitbit64", "12345");
	}
	
	public static void updateTest(UserVo vo) {
		UserDao dao = new UserDao();
		dao.insertUser(vo);
	}
	
	public static void getListTest() {
		UserDao dao = new UserDao();
		List<UserVo> users = dao.getListUser();
		
		System.out.println("=============================================================");
		System.out.println("회원 목록");
		System.out.println("=============================================================");
		for (UserVo user : users) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("회원 번호: " + user.getUserNo() + " | "+"회원 ID: "+user.getId());
		}
		System.out.println("-----------------------------------------------------------");
		System.out.println("=============================================================");
	}
	
	public static void login(String id, String password) {
		UserDao dao = new UserDao();
		HashMap<Boolean, UserVo> loginCheck = new HashMap<>();
		loginCheck = dao.login(id, password);
		loginCheck.containsKey(true);
		System.out.println("=============================================================");
		System.out.println(loginCheck.get(true).getId()+"님이 로그인 하였습니다.");
		System.out.println("=============================================================");
	}
}
