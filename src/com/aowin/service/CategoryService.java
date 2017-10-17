package com.aowin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aowin.dao.CategoryMapper;
import com.aowin.model.BikeCategory;

@Service
public class CategoryService {
	@Resource
	private CategoryMapper cateMapper;

	public CategoryMapper getCateMapper() {
		return cateMapper;
	}

	public void setCateMapper(CategoryMapper cateMapper) {
		this.cateMapper = cateMapper;
	}
	

	public List<BikeCategory> selectCategories(){
		return cateMapper.getCategories();
	}
	
	public int delCategory(int catagory_id){
		int detail_id=cateMapper.getDetailId(catagory_id);
		System.out.println(detail_id);
		if(detail_id==0){
			cateMapper.deleteCate(catagory_id);
			return 1;
		}else{
			return 0;
		}
	}
	
	public int updateCate(BikeCategory cate){
		return cateMapper.updateCategory(cate);
	}
	
	public int insertCate(BikeCategory cate){
		return cateMapper.addCate(cate);
	}
	
	
}
