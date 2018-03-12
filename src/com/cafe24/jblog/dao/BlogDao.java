package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.UserVo;

public class BlogDao{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public void insertBlog(BlogVo vo) {
		conn = MyConnection.getConnection();
		String sql = "insert into blog values(?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, vo.getUserVo().getUserNo());
			pstmt.setString(2, vo.getTitle());
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("실패");
			} else {
				System.out.println("성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ClosingConn.closingConnection(pstmt, conn);
		}
	}
	
	public List<BlogVo> getListBlog() {
		conn = MyConnection.getConnection();
		ResultSet rs = null;
		List<BlogVo> blogs = new ArrayList<>();
		String sql = "select a.no, b.id, a.title from blog a, user b where a.no = b.no";
		try {
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(parameterIndex, x);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BlogVo blog = new BlogVo();
				UserVo user = new UserVo();
				user.setUserNo(rs.getLong(1));
				user.setId(rs.getString(2));
				blog.setUserVo(user);
				blog.setTitle(rs.getString(3));
				blogs.add(blog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ClosingConn.closingConnection(rs, pstmt, conn);
		}
		return blogs;
	}	

}
