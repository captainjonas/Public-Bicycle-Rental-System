package com.aowin.dao;

import java.util.List;
import java.util.Map;

import com.aowin.model.Station;


public interface StationMapper<E> {
	public int selectCount(Map<String,Object> map);
	public List<E> selectData(Map<String,Object> map);
	public int cancelStation(int station_id);
	public int bikeNum(int station_id);
	public int insertStation(Station station);
	public Station getStation(int station_id);
	public int updateStation(Station station);
	public List<Station> search(Station station);
	public List<Station> summary(Map<String,Object> map);
	

}
