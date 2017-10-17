package com.aowin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.BikeMapper;
import com.aowin.dao.BusinessMapper;
import com.aowin.model.Bicycle;
import com.aowin.model.Business;

@Service
public class BikeService {
	@Resource
	private BikeMapper bikeMapper;
	@Resource
	private BusinessMapper businessMapper;
	
	public List<Bicycle> getBrokenBikes(){
		return bikeMapper.brokenBikes();
	}
	
	public List<Bicycle> newBikes(){
		return bikeMapper.newBikes();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void scrap(Business business){
		bikeMapper.updateScrap(business.getBicycle_id());
		businessMapper.insertRecord(business);
	}
	
	public boolean checkBike(int bicycle_id,int pile_id){
		boolean flag=true;
		Bicycle bike=bikeMapper.bikePile(bicycle_id);
		int pid=bike.getPile_id();
		String status=bike.getStatus();
		if((pid!=0&&pid!=pile_id)||status.equals("9")||status.equals("8"))
			flag=false;
		return flag;
	}
	

	public BikeMapper getBikeMapper() {
		return bikeMapper;
	}

	public void setBikeMapper(BikeMapper bikeMapper) {
		this.bikeMapper = bikeMapper;
	}

	public BusinessMapper getBusinessMapper() {
		return businessMapper;
	}

	public void setBusinessMapper(BusinessMapper businessMapper) {
		this.businessMapper = businessMapper;
	}
	

}
