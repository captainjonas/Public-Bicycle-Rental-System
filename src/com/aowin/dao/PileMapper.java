package com.aowin.dao;

import java.util.List;

import com.aowin.model.Pile;

public interface PileMapper {
	public List<Pile> selectPile(int station_id);
	public int insertPile(Pile pile);
	public int addPile(Pile pile);
	public int deletePiles(int station_id);
	public int selectID();
	public List<Pile> availablePiles(int station_id);
	public int bikein(Pile pile);

}
