package com.aowin.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aowin.dao.StationMapper;
import com.aowin.model.Page;

public class PageUtil<E> {
	public static <E> Page<E> selectPage(StationMapper<E> mapper,int currentPage,Map<String,Object> map){
		Page<E> page=new Page<E>();
		int totalCount=mapper.selectCount(map);
		page.setTotalCount(totalCount);
		Object pageSize=map.get("pageSize");
		if(pageSize==null){
			page.setPageSize(3);    //默认每页显示3条信息
		}else{
			page.setPageSize((Integer)pageSize); 
		}
		
		int totalPage=-1;
		if(totalCount%page.getPageSize()==0){
			totalPage=totalCount/page.getPageSize();
		}else{
			totalPage=totalCount/page.getPageSize()+1;
		}
		page.setTotalPage(totalPage);
		if(currentPage<=0||currentPage>totalPage){
			currentPage=1;
		}
		page.setCurrentPage(currentPage);
		if(map==null){
			map=new HashMap<String,Object>();
		}
		map.put("startNo", (currentPage-1)*page.getPageSize()+1);
		map.put("endNo", currentPage*page.getPageSize());
		List<E> dataList=mapper.selectData(map);
		
		page.setDataList(dataList);
		return page;
	
	}

}
