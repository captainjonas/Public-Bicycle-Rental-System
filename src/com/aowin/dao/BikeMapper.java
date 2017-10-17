package com.aowin.dao;

import java.util.List;

import com.aowin.model.Bicycle;
import com.aowin.model.Pile;

public interface BikeMapper {
	public List<Bicycle> brokenBikes();
	public int updateScrap(int bicycle_id);
	public List<Bicycle> newBikes();
	public int buyBike(Bicycle bicycle);
	public Bicycle bikePile(int bicycle_id);
	public int updateStatus(Pile pile);
}
