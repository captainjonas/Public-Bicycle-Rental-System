package com.aowin.controller;

import java.util.ArrayList;
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
import com.aowin.service.OrderService;
import com.aowin.service.PileService;
import com.aowin.service.StationService;

@Controller
public class PileController {
	@Resource
	private HttpServletRequest request;
	@Resource
	private PileService pileService;
	@Resource
	private HttpSession session;
	@Resource
	private StationService stationService;
	@Resource
	private OrderService orderService;
	
	@RequestMapping("pile.do")
	public String getPiles(){
		int station_id=Integer.valueOf(request.getParameter("station_id"));
		List<Pile> piles=new ArrayList<Pile>();
		piles=pileService.getPile(station_id);
		request.setAttribute("pile", piles);
		return "station/Pile.jsp";
		
	}
	
	@RequestMapping("sum.do")
	public String pileSum(){
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		String time=year+"-"+month;
		String term="select s.station_id,s.station_code,s.station_name,s.longitude,s.latitude,s.bicycle_pile_num,s.address,"
				+ " s.build_time, s.run_time, p.pile_id, p.pile_code,p.install_time from bicycle_station s,bicycle_pile p "
				+ "where s.station_id=p.station_id and s.build_time<='"+time+"' and p.install_time<='"+time+"' order by s.station_id";
		int currentPage;
		String p=request.getParameter("page");
		if(p==null||p.equals("")){
			currentPage=1;
		}else{
			currentPage=Integer.valueOf(p);
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("condition", term);
		map.put("pageSize", 20);
		Page<Station> page=stationService.selectPage(currentPage, map);
		request.setAttribute("page", page);
		map.put("time", time);
		int bikeNum=orderService.getBikeNum(map);
		request.setAttribute("bikeNum", bikeNum);
		request.setAttribute("time", time);
		return "summary/pileSum.jsp";
	}

}
