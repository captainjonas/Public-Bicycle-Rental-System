package com.aowin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aowin.model.Pile;
import com.aowin.model.Station;
import com.aowin.service.PileService;
import com.aowin.service.StationService;

@Controller
@RequestMapping("/search/*")
public class AJAXController {
@Resource
private StationService stationService;
@Resource
private PileService pileService;

	
	@RequestMapping(value="ajax.do",method=RequestMethod.POST)
	@ResponseBody
	public List<Station> ajaxData(HttpServletRequest request,HttpServletResponse response){
		int station_id;
		int bicycle_pile_num;
		String id=request.getParameter("station_id");
		if(id.equals("")||id==null){
			station_id=0;
		}else{
			station_id=Integer.valueOf(id);
		}
		String station_code=request.getParameter("station_code");
		String station_name=request.getParameter("station_name");
		String num=request.getParameter("bicycle_pile_num");
		if(num.equals("")||num==null){
			bicycle_pile_num=0;
		}else{
			bicycle_pile_num=Integer.valueOf(num);
		}
		String address=request.getParameter("address");
		String person_in_charge=request.getParameter("person_in_charge");
		Station s=new Station(station_id,station_code,station_name,bicycle_pile_num,address,person_in_charge);
		List<Station> sl=new ArrayList<Station>();
		sl=stationService.search(s);
		return sl;
	}
	
	@RequestMapping(value="seekPile.do",method=RequestMethod.POST)
	@ResponseBody
	public List<Pile> pileData(HttpServletRequest request,HttpServletResponse response){
		int station_id=Integer.valueOf(request.getParameter("station_id"));
		List<Pile> pileData=new ArrayList<Pile>();
		pileData=pileService.vacantPiles(station_id);
		return pileData;
	}
	

}
