package com.aowin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.BikeMapper;
import com.aowin.dao.PileMapper;
import com.aowin.dao.StationMapper;
import com.aowin.model.Page;
import com.aowin.model.Pile;
import com.aowin.model.Station;
import com.aowin.util.PageUtil;

@Service
public class StationService {
@Resource
private StationMapper<Station> stationMapper;
@Resource
private PileMapper pileMapper;
@Resource
private BikeMapper bikeMapper;



public PileMapper getPileMapper() {
	return pileMapper;
}



public void setPileMapper(PileMapper pileMapper) {
	this.pileMapper = pileMapper;
}



public StationMapper<Station> getStationMapper() {
	return stationMapper;
}



public void setStationMapper(StationMapper<Station> stationMapper) {
	this.stationMapper = stationMapper;
}



public int count(Map<String,Object> map){
	return stationMapper.selectCount(map);
}

public Page<Station> selectPage(int currentPage,Map<String,Object> map){
	return PageUtil.selectPage(stationMapper, currentPage, map);
}

public List<Station> search(Station station){
	return stationMapper.search(station);
}

public boolean cancelStation(int station_id){
	int num=stationMapper.bikeNum(station_id);
	if(num>0){
		return false;
	}else{
		stationMapper.cancelStation(station_id);
		return true;
	}
}

@Transactional(propagation=Propagation.REQUIRED)
public void insertStation(Map<String,Object> map){
	Station station=(Station)map.get("station");
	stationMapper.insertStation(station);
	ArrayList<Pile> piles=(ArrayList<Pile>)map.get("piles");
	for(Pile p:piles){
		pileMapper.insertPile(p);
	}
}

public Station getStation(int station_id){
	return stationMapper.getStation(station_id);
}

public List<Station> summary(Map<String,Object> map){
	return stationMapper.summary(map);
}

@Transactional(propagation=Propagation.REQUIRED)
public void updateStation(Map<String,Object> map){
	Station sta=(Station)map.get("sta");
	stationMapper.updateStation(sta);
	pileMapper.deletePiles(sta.getStation_id());
	ArrayList<Pile> piles=(ArrayList<Pile>)map.get("piles");
	for(Pile p:piles){
		pileMapper.addPile(p);
		if(p.getBikeId()!=0)
			bikeMapper.updateStatus(p);
	}
}
	
}
