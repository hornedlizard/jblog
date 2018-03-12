package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.jblog.vo.CommentVo;
import com.cafe24.jblog.vo.UserVo;

public class CommentDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public void insertComment(CommentVo vo) {
		conn = MyConnection.getConnection();
		
		String sql = "insert into comment values(null, ?, now(), ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getContent());
			pstmt.setLong(2, vo.getPostNo());
			pstmt.setLong(3, vo.getUserVo().getUserNo());
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
	
	public List<CommentVo> getListComment(long postNo) {
		conn = MyConnection.getConnection();
		ResultSet rs = null;
		List<CommentVo> comments = new ArrayList<>();
		String sql = "select b.no, b.content, b.regdate, a.title, a.user_no, c.id "
					+ "from post a, comment b, user c where b.post_no = ? and b.user_no = c.no";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, postNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CommentVo comment = new CommentVo();
				UserVo user = new UserVo();
				comment.setCommentNo(rs.getLong(1));
				comment.setContent(rs.getString(2));
				comment.setRegdate(rs.getString(3));
				comment.setPostTitle(rs.getString(4));
				user.setUserNo(rs.getLong(5));
				user.setId(rs.getString(6));
				comment.setUserVo(user);
				
				comments.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ClosingConn.closingConnection(rs, pstmt, conn);
		}
		return comments;
	}
}
