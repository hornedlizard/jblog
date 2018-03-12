package com.cafe24.jblog.dao.test;

import java.util.ArrayList;
import java.util.List;

import com.cafe24.jblog.dao.CategoryDao;
import com.cafe24.jblog.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		CategoryVo category = new CategoryVo();
		category.setTitle("맛집");
		category.setComm("지원받았습니다.");
		updateTest(category);
		category.setTitle("영화리뷰");
		category.setComm("노잼들");
		updateTest(category);
		category.setTitle("책리뷰");
		category.setComm("노잼들");
		updateTest(category);
		
		getListTest();
		
		
	}
	
	public static void updateTest(CategoryVo category) {
		CategoryDao dao = new CategoryDao();
		dao.insertCategory(category);
	}

	public static void getListTest() {
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> categorys = new ArrayList<>();
		categorys = dao.getListCategory();
		
		System.out.println("=============================================================");
		System.out.println("카테고리 목록");
		System.out.println("=============================================================");
		for (CategoryVo category : categorys) {
			System.out.println("-------------------------------------------------------------");
			System.out.println(category.getCategoryNo()+". "+category.getTitle()
							+"\n"+category.getComm());
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("=============================================================");
	}
}
