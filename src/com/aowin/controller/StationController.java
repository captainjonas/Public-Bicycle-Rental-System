package com.aowin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aowin.model.Page;
import com.aowin.model.Pile;
import com.aowin.model.Station;
import com.aowin.model.User;
import com.aowin.model.Vender;
import com.aowin.service.BikeService;
import com.aowin.service.OrderService;
import com.aowin.service.PileService;
import com.aowin.service.StationService;
import com.aowin.service.UserService;

@Controller
public class StationController {
@Resource
private HttpServletRequest request;
@Resource
private StationService stationService;
@Resource
private HttpSession session;
@Resource
private PileService pileService;
@Resource
private OrderService orderService;
@Resource
private BikeService bikeService;
@Resource
private UserService userService;

@RequestMapping("stations.do")
public String showStations(){
	String username=(String)session.getAttribute("username");
	if(username==null||username.equals(""))
		return "authority.jsp";
	User user=new User();
	user.setUsername(username);
	int auth_id=userService.getAuthID(user);
	if(auth_id==3||auth_id==5){
		session.removeAttribute("username");
		return "authority.jsp";
	}else{
		boolean flag=true;
		int currentPage;
		String p=request.getParameter("page");
		String sign=request.getParameter("sign");
		if(p==null||p.equals("")){
			currentPage=1;
		}else{
			currentPage=Integer.valueOf(p);
		}
		String sql=request.getParameter("sql");
		if(sql!=null){
			session.removeAttribute("param");
			session.setAttribute("param", sql);
		}	
		if(sign.equals("1")&&sql==null){
			sql=(String)session.getAttribute("param");
		}
		if((sql==null&&sign==null)||sign.equals("0")){
			sql="select * from bicycle_station";
		}else{
			flag=false;
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("condition", sql);
		Page<Station> page=stationService.selectPage(currentPage, map);
		request.setAttribute("page", page);
		if(flag){
			return "station/station.jsp";
		}else{
			return "station/queryStation.jsp";
		}
	}
}


@RequestMapping("cancelStation.do")
public String delStation(){
	int station_id=Integer.valueOf(request.getParameter("id"));
	boolean flag=stationService.cancelStation(station_id);
	if(flag){
		return "station/queryStation.jsp?cancel=1";
	}else{
		return "station/queryStation.jsp?cancel=0";
	}
}

@RequestMapping("newstation.do")
public String addStation(){
	String station_code=request.getParameter("station_code");
	String station_name=request.getParameter("station_name");
	double longitude=Double.valueOf(request.getParameter("longitude"));
	double latitude=Double.valueOf(request.getParameter("latitude"));
	int bicycle_pile_num=Integer.valueOf(request.getParameter("bicycle_pile_num"));
	String address=request.getParameter("address");
	String person_in_charge=request.getParameter("person_in_charge");
	String build_time=request.getParameter("build_time");
	String run_time=request.getParameter("run_time");
	String username=(String)session.getAttribute("username");
	Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String operator_time=sdf.format(date);
	String remark=request.getParameter("remark");
	Station station=new Station(station_code,station_name,longitude,latitude,bicycle_pile_num,address,person_in_charge,build_time,run_time,operator_time,remark,username);
	Map<String,Object> map=new HashMap<String,Object>();
	map.put("station", station);
	ArrayList<Pile> piles=new ArrayList<Pile>();
	String[] codes=request.getParameter("codes").split(";");
	String[] venders=request.getParameter("venders").split(";");
	String[] install_times=request.getParameter("install_times").split(";");
	String[] remarks=request.getParameter("remarks").split(";");
	for(int i=0;i<codes.length;i++){
		String pile_code=codes[i];
		int vender_id=Integer.valueOf(venders[i]);
		String install_time=install_times[i];
		String mark;
		if(remarks[i].equals("0")){
			mark="";
		}else{
			mark=remarks[i];
		}
		Pile pile=new Pile(vender_id,pile_code,install_time,operator_time,mark,username,station_code);
		piles.add(pile);
	}
	map.put("piles", piles);
	stationService.insertStation(map);
	request.setAttribute("addstation",1);
	return "new.do";
}

@RequestMapping("getStation.do")
public String stationInfo(){
	int station_id=Integer.valueOf(request.getParameter("station_id"));
	session.setAttribute("stationId", station_id);
	List<Pile> piles=new ArrayList<Pile>();
	piles=pileService.getPile(station_id);
	Station s=stationService.getStation(station_id);
	List<Vender> list=new ArrayList<Vender>();
	list=orderService.getPileVenders();
	int pileId=pileService.getID();
	request.setAttribute("id", pileId);
	request.setAttribute("cz", list);
	request.setAttribute("station", s);
	request.setAttribute("piles", piles);
	return "station/modify.jsp";
}

@RequestMapping("changeStation.do")
public String alterStation(){
	boolean f=true;
	int station_id=Integer.valueOf(request.getParameter("station_id"));
	String station_code=request.getParameter("station_code");
	String station_name=request.getParameter("station_name");
	double longitude=Double.valueOf(request.getParameter("longitude"));
	double latitude=Double.valueOf(request.getParameter("latitude"));
	int bicycle_pile_num=Integer.valueOf(request.getParameter("bicycle_pile_num"));
	String address=request.getParameter("address");
	String person_in_charge=request.getParameter("person_in_charge");
	String run_time=request.getParameter("run_time");
	String remark=request.getParameter("remark");
	Station station=new Station(station_id,station_code,station_name,longitude,latitude,bicycle_pile_num,address,person_in_charge,run_time,remark);
	Map<String,Object> map=new HashMap<String,Object>();
	map.put("sta", station);
	String username=(String)session.getAttribute("username");
	Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String operator_time=sdf.format(date);
	ArrayList<Pile> piles=new ArrayList<Pile>();
	String[] ids=request.getParameter("ids").split(";");
	String[] codes=request.getParameter("codes").split(";");
	String[] venders=request.getParameter("venders").split(";");
	String[] statuses=request.getParameter("statuses").split(";");
	String[] install_times=request.getParameter("install_times").split(";");
	String[] bikeids=request.getParameter("bikeids").split(";");
	String[] remarks=request.getParameter("remarks").split(";");
	for(int i=0;i<codes.length;i++){
		int bikeId=0;
		int pile_id=Integer.valueOf(ids[i]);
		String pile_code=codes[i];
		String vender_name=venders[i];
		int status=Integer.valueOf(statuses[i]);
		String install_time=install_times[i];
		String bicycle_id;
		String mark;
		if(bikeids[i].equals("0")){
			bicycle_id="";
		}else{
			bicycle_id=bikeids[i];
			bikeId=Integer.valueOf(bicycle_id);
			f=bikeService.checkBike(bikeId, pile_id);
			if(!f)
				break;
		}
		if(remarks[i].equals("0")){
			mark="";
		}else{
			mark=remarks[i];
		}
		Pile pile=new Pile(pile_id,pile_code,status,install_time,operator_time,bicycle_id,mark,vender_name,username,station_id);
		pile.setBikeId(bikeId);
		piles.add(pile);
	}
	if(!f){
		request.setAttribute("bikePile", 0);
	}else{
		map.put("piles", piles);
		stationService.updateStation(map);
		request.setAttribute("alterstation",1);
	}
	return "alterInfo.do";
}

@RequestMapping("search.do")
public String searchStation(){
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
	request.setAttribute("CD", sl);
	return "manage/intoPile.jsp";
	
}





}
