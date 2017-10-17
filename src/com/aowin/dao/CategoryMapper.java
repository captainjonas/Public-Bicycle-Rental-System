package com.aowin.dao;

import java.util.List;

import com.aowin.model.BikeCategory;

public interface CategoryMapper {
	public List<BikeCategory> getCategories();
	public int deleteCate(int catagory_id);
	public int updateCategory(BikeCategory cate);
	public int addCate(BikeCategory cate);
	public int getDetailId(int catagory_id);

}
