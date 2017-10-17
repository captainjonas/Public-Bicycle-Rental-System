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

import com.aowin.model.Bicycle;
import com.aowin.model.Business;
import com.aowin.model.Deploy;
import com.aowin.model.Pile;
import com.aowin.model.User;
import com.aowin.service.BikeService;
import com.aowin.service.PileService;
import com.aowin.service.UserService;

@Controller
public class BikeController {
	@Resource
	private BikeService bikeService;
	@Resource
	private HttpSession session;
	@Resource
	private HttpServletRequest request;
	@Resource
	private PileService pileService;
	@Resource
	private UserService userService;
	
	@RequestMapping("destroy.do")
	public String destroy(){
		String username=(String)session.getAttribute("username");
		if(username==null||username.equals(""))
			return "authority.jsp";
		User user=new User();
		user.setUsername(username);
		int auth_id=userService.getAuthID(user);
		if(auth_id==5||auth_id==4){
			session.removeAttribute("username");
			return "authority.jsp";
		}else{
			List<Bicycle> list=new ArrayList<Bicycle>();
			list=bikeService.getBrokenBikes();
			request.setAttribute("list",list);
			return "manage/destroy.jsp";
		}
	}
	
	@RequestMapping("newBike.do")
	public String newbike(){
		String username=(String)session.getAttribute("username");
		if(username==null||username.equals(""))
			return "authority.jsp";
		User user=new User();
		user.setUsername(username);
		int auth_id=userService.getAuthID(user);
		if(auth_id==5){
			session.removeAttribute("username");
			return "authority.jsp";
		}else{
			List<Bicycle> al=new ArrayList<Bicycle>();
			al=bikeService.newBikes();
			request.setAttribute("al", al);
			return "manage/intoPile.jsp";
		}
		
	}
	
	@RequestMapping("scrap.do")
	public String scrap(){
		int bicycle_id=Integer.valueOf(request.getParameter("id"));
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		String create_time=sdf.format(date);
		String username=(String)session.getAttribute("username");
		Business business=new Business(create_time,bicycle_id,username);
		System.out.println(business);
		bikeService.scrap(business);
		return "destroy.do";
	}
	
	@RequestMapping("toPile.do")
	public String inPile(){
		String bid=request.getParameter("bid");
		int bicycle_id=Integer.valueOf(bid);
		int pile_id=Integer.valueOf(request.getParameter("pid"));
		Pile pile=new Pile(pile_id,bicycle_id);
		pile.setBicycle_id(bid);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("pile", pile);
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		String to_time=sdf.format(date);
		Deploy deploy=new Deploy(bicycle_id,pile_id,to_time);
		map.put("deploy", deploy);
		String username=(String)session.getAttribute("username");
		Business business=new Business(to_time,bicycle_id,pile_id,username);
		map.put("business", business);
		pileService.toPile(map);
		request.setAttribute("topile",1);
		return "newBike.do";
	}

}
