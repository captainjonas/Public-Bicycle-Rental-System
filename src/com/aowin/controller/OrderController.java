package com.aowin.controller;

import java.math.BigDecimal;
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
import com.aowin.model.BikeCategory;
import com.aowin.model.Business;
import com.aowin.model.Order;
import com.aowin.model.OrderDetail;
import com.aowin.model.User;
import com.aowin.model.Vender;
import com.aowin.service.CategoryService;
import com.aowin.service.OrderService;
import com.aowin.service.UserService;

@Controller
public class OrderController {
	@Resource
	private HttpServletRequest request;
	@Resource
	private OrderService orderService;
	@Resource
	private HttpSession session;
	@Resource 
	private CategoryService cateService;
	@Resource
	private UserService userService;
	
	@RequestMapping("order.do")
	public String addOrder(){
		String order_code=request.getParameter("order_code");
		int vender_id=Integer.valueOf(request.getParameter("vender_id"));
		String buy_date=request.getParameter("buy_date");
		int buy_num=Integer.valueOf(request.getParameter("buy_num"));
		BigDecimal buy_price=BigDecimal.valueOf(Double.valueOf(request.getParameter("buy_price")));
		String person_in_charge=request.getParameter("person_in_charge");
		String invoice_no=request.getParameter("invoice_no");
		String username=(String)session.getAttribute("username");
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String operator_time=sdf.format(date);
		String remark=request.getParameter("remark");
		Order order=new Order(order_code,vender_id,buy_date,buy_num,buy_price,person_in_charge,invoice_no,username,operator_time,remark);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("order", order);
		Bicycle bicycle=new Bicycle(operator_time,username);
		map.put("bicycle",bicycle);
		Business business=new Business(operator_time,buy_price,username,order_code);
		map.put("business", business);
		ArrayList<OrderDetail> list=new ArrayList<OrderDetail>();
		String[] ids=request.getParameter("catagory_id").split(";");
		String[] dates=request.getParameter("create_date").split(";");
		String[] batches=request.getParameter("batch_no").split(";");
		String[] prices=request.getParameter("price").split(";");
		String[] remarks=request.getParameter("dRemark").split(";");
		for(int i=0;i<buy_num;i++){
			int catagory_id=Integer.valueOf(ids[i]);
			String create_date=dates[i];
			String batch_no=batches[i];
			BigDecimal price=BigDecimal.valueOf(Double.valueOf(prices[i]));
			String mark;
			if(remarks[i].equals("0")){
				mark="";
			}else{
				mark=remarks[i];
			}
			OrderDetail detail=new OrderDetail(catagory_id,order_code,create_date,batch_no,price,mark);
			list.add(detail);
		}
		map.put("details",list);
		orderService.insertOrder(map);
		request.setAttribute("addorder",1);
		return "vender.do";	
	}
	
	@RequestMapping("vender.do")
	public String getVender(){
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
			List<BikeCategory> bike=new ArrayList<BikeCategory>();
			bike=cateService.selectCategories();
			request.setAttribute("bikes",bike);
			List<Vender> list=new ArrayList<Vender>();
			list=orderService.getVenders();
			request.setAttribute("cl",list);
			return "manage/order.jsp";
		}
		
	}
	
	@RequestMapping("new.do")
	public String getPileVenders(){
		List<Vender> list=new ArrayList<Vender>();
		list=orderService.getPileVenders();
		request.setAttribute("cz", list);
		return "station/newStation.jsp";
	}
	
	@RequestMapping("alterInfo.do")
	public String selectPileVenders(){
		List<Vender> list=new ArrayList<Vender>();
		list=orderService.getPileVenders();
		request.setAttribute("cz", list);
		Object station_id=session.getAttribute("stationId");
		session.removeAttribute("stationId");
		return "getStation.do?station_id="+station_id;
	}
	
}
