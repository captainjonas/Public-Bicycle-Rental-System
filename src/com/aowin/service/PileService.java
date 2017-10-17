package com.aowin.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.BikeMapper;
import com.aowin.dao.BusinessMapper;
import com.aowin.dao.DeployMapper;
import com.aowin.dao.PileMapper;
import com.aowin.model.Business;
import com.aowin.model.Deploy;
import com.aowin.model.Pile;

@Service
public class PileService {
	@Resource
	private PileMapper pileMapper;
	@Resource
	private BikeMapper bikeMapper;
	@Resource
	private DeployMapper deployMapper;
	@Resource
	private BusinessMapper businessMapper;


	public BusinessMapper getBusinessMapper() {
		return businessMapper;
	}

	public void setBusinessMapper(BusinessMapper businessMapper) {
		this.businessMapper = businessMapper;
	}

	public DeployMapper getDeployMapper() {
		return deployMapper;
	}

	public void setDeployMapper(DeployMapper deployMapper) {
		this.deployMapper = deployMapper;
	}

	public BikeMapper getBikeMapper() {
		return bikeMapper;
	}

	public void setBikeMapper(BikeMapper bikeMapper) {
		this.bikeMapper = bikeMapper;
	}

	public PileMapper getPileMapper() {
		return pileMapper;
	}

	public void setPileMapper(PileMapper pileMapper) {
		this.pileMapper = pileMapper;
	}
	
	public List<Pile> getPile(int station_id){
		return pileMapper.selectPile(station_id);
	}
	
	public List<Pile> vacantPiles(int station_id){
		return pileMapper.availablePiles(station_id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void toPile(Map<String,Object> map){
		Pile p=(Pile)map.get("pile");
		bikeMapper.updateStatus(p);
		pileMapper.bikein(p);
		Deploy deploy=(Deploy)map.get("deploy");
		deployMapper.insertDeploy(deploy);
		Business b=(Business)map.get("business");
		System.out.println(b);
		businessMapper.inPile(b);
	}
	
	public int getID(){
		return pileMapper.selectID();
	}

}
