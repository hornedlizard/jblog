package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.jblog.vo.CategoryVo;

public class CategoryDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public void insertCategory(CategoryVo vo) {
		conn = MyConnection.getConnection();
		String sql = "insert into category values(null, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getComm());
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("카테고리 등록 실패");
			} else {
				System.out.println("카테고리 등록 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ClosingConn.closingConnection(pstmt, conn);
		}
	}
	
	public List<CategoryVo> getListCategory() {
		conn = MyConnection.getConnection();
		ResultSet rs = null;
		List<CategoryVo> categorys = new ArrayList<>();
		String sql = "select no, title, memo from category";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CategoryVo category = new CategoryVo();
				category.setCategoryNo(rs.getLong(1));
				category.setTitle(rs.getString(2));
				category.setComm(rs.getString(3));
				categorys.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ClosingConn.closingConnection(rs, pstmt, conn);
		}
		return categorys;
	}
	
	public CategoryVo getCategory(long categoryNo) {
		conn = MyConnection.getConnection();
		CategoryVo category = new CategoryVo();
		ResultSet rs = null;
		String sql = "select no, title, memo from category where no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, categoryNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				category.setCategoryNo(rs.getLong(1));
				category.setTitle(rs.getString(2));
				category.setComm(rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ClosingConn.closingConnection(rs, pstmt, conn);
		}
		return category;
	}
}
