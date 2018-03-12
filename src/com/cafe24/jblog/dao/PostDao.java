package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;
import com.cafe24.jblog.vo.UserVo;

public class PostDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public void insertPost(PostVo vo) {
		conn = MyConnection.getConnection();
		
		String sql = "insert into post values(null, ?, ?, now(), ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			long cno = vo.getCategoryVo().getCategoryNo();
			pstmt.setLong(3, cno);
			pstmt.setLong(4, vo.getUserVo().getUserNo());
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("포스팅 실패");
			} else {
				System.out.println("포스팅 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ClosingConn.closingConnection(pstmt, conn);
		}
	}
	
	public List<PostVo> getListPost(long userNo) { // userNo == blogNo
		conn = MyConnection.getConnection();
		ResultSet rs = null;
		List<PostVo> posts = new ArrayList<>();
		String sql = "select no, title, content, regdate, category_no, user_no "
					+ "from post where user_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, userNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PostVo post = new PostVo();
				post.setPostNo(rs.getLong(1));
				post.setTitle(rs.getString(2));
				post.setContent(rs.getString(3));
				post.setRegdate(rs.getString(4));

				CategoryDao categoryDao = new CategoryDao();
				CategoryVo categoryVo = new CategoryVo();
				categoryVo = categoryDao.getCategory(rs.getLong(5));
				post.setCategoryVo(categoryVo);
				
				UserDao userDao = new UserDao();
				UserVo user = new UserVo();
				user = userDao.getUser(userNo);
				post.setUserVo(user);
				
				posts.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ClosingConn.closingConnection(rs, pstmt, conn);
		}
		return posts;
	}
}
