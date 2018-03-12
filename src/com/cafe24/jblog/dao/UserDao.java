package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cafe24.jblog.vo.UserVo;

public class UserDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public void insertUser(UserVo vo) {
		conn = MyConnection.getConnection();
		String sql = "insert into user values(null, ?, password(?))";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("회원 가입 실패");
			} else {
				System.out.println("회원 가입 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ClosingConn.closingConnection(pstmt, conn);
		}
	}
	
	public List<UserVo> getListUser() {
		conn = MyConnection.getConnection();
		ResultSet rs = null;
		List<UserVo> users = new ArrayList<>();
		String sql = "select no, id from user";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserVo user = new UserVo();
				user.setUserNo(rs.getLong(1));
				user.setId(rs.getString(2));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ClosingConn.closingConnection(rs, pstmt, conn);
		}
		return users;
	}
	
	public UserVo getUser(long userNo) {
		conn = MyConnection.getConnection();
		UserVo user = new UserVo();
		ResultSet rs = null;
		String sql = "select no, id from user where no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, userNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setUserNo(rs.getLong(1));
				user.setId(rs.getString(2));		
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ClosingConn.closingConnection(rs, pstmt, conn);
		}
		return user;
	}
	
	public HashMap<Boolean, UserVo> login(String id, String password) {
		conn = MyConnection.getConnection();
		ResultSet rs = null;
		HashMap<Boolean, UserVo> loginCheck = new HashMap<>();
		String sql = "select no, id " + 
				"from user " + 
				"where id = ? " + 
				"and password = password(?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				UserVo user = new UserVo();
				user.setUserNo(rs.getLong(1));
				user.setId(rs.getString(2));
				loginCheck.put(true, user);
				return loginCheck;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		loginCheck.put(false, null);
		return loginCheck;
	}
	
	public HashMap<Boolean, Long> logout() {
		HashMap<Boolean, Long> loginCheck = new HashMap<>();
		loginCheck.put(false, 0l);
		return loginCheck;
	}
}
