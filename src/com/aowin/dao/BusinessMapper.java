package com.aowin.dao;

import com.aowin.model.Business;

public interface BusinessMapper {
	public int insertRecord(Business business);
	public int insertBuy(Business business);
	public int inPile(Business business);

}
