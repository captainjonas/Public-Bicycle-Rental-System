package com.aowin.dao;

import java.util.List;
import java.util.Map;

import com.aowin.model.Order;
import com.aowin.model.Vender;

public interface OrderMapper {
	public int insertOrder(Order order);
	public List<Vender> selectVenders();
	public List<Vender> getPileVender();
	public int getBuyNum(Map<String,Object> map);

}
