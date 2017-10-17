package com.aowin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.BikeMapper;
import com.aowin.dao.BusinessMapper;
import com.aowin.dao.OrderDetailMapper;
import com.aowin.dao.OrderMapper;
import com.aowin.model.Bicycle;
import com.aowin.model.Business;
import com.aowin.model.Order;
import com.aowin.model.OrderDetail;
import com.aowin.model.Vender;

@Service
public class OrderService {
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private OrderDetailMapper detailMapper;
	@Resource
	private BikeMapper bikeMapper;
	@Resource
	private BusinessMapper businessMapper;

	
	public BusinessMapper getBusinessMapper() {
		return businessMapper;
	}

	public void setBusinessMapper(BusinessMapper businessMapper) {
		this.businessMapper = businessMapper;
	}

	public BikeMapper getBikeMapper() {
		return bikeMapper;
	}

	public void setBikeMapper(BikeMapper bikeMapper) {
		this.bikeMapper = bikeMapper;
	}

	public OrderDetailMapper getDetailMapper() {
		return detailMapper;
	}

	public void setDetailMapper(OrderDetailMapper detailMapper) {
		this.detailMapper = detailMapper;
	}

	public OrderMapper getOrderMapper() {
		return orderMapper;
	}

	public void setOrderMapper(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}
	
	public List<Vender> getVenders(){
		return orderMapper.selectVenders();
	}
	
	public List<Vender> getPileVenders(){
		return orderMapper.getPileVender();
	}
	
	public int getBikeNum(Map<String,Object> map){
		return orderMapper.getBuyNum(map);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertOrder(Map<String,Object> map){
		Order order=(Order)map.get("order");
		orderMapper.insertOrder(order);
		Business b=(Business)map.get("business");
		businessMapper.insertBuy(b);
		Bicycle bicycle=(Bicycle)map.get("bicycle");
		ArrayList<OrderDetail> details=(ArrayList<OrderDetail>)map.get("details");
		for(OrderDetail detail:details){
			detailMapper.insertDetail(detail);
			bikeMapper.buyBike(bicycle);
		}
	}
	
	
	
}
