package com.aowin.controller;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aowin.model.BikeCategory;
import com.aowin.model.User;
import com.aowin.service.CategoryService;
import com.aowin.service.UserService;

@Controller
public class CategoryController {
@Resource
private CategoryService cateService;
@Resource
private HttpServletRequest request;
@Resource
private HttpSession session;
@Resource
private UserService userService;


	@RequestMapping("cate.do")
	public String getCates(){
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
			List<BikeCategory> bikes=new ArrayList<BikeCategory>();
			bikes=cateService.selectCategories();
			request.setAttribute("cate",bikes);
			String del=request.getParameter("delFlag");
			request.setAttribute("delFlag", del);
			return "station/category.jsp";
		}
		
	}
	
	@RequestMapping("delcate.do")
	public String deleCategory(){
		int catagory_id=Integer.valueOf(request.getParameter("id"));
		System.out.println(catagory_id);
		int flag=cateService.delCategory(catagory_id);
		return "cate.do?delFlag="+flag;
	}
	
	@RequestMapping("updcate.do")
	public String updCategory(){
		int catagory_id=Integer.valueOf(request.getParameter("id"));
		String catagory_name=request.getParameter("name");
		String tire_type=request.getParameter("tire");
		String ring_type=request.getParameter("ring");
		String backseat=request.getParameter("backseat");
		String bicycle_seat=request.getParameter("seat");
		String username=(String)session.getAttribute("username");
	    Date date=new Date();
	    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String operator_time=format.format(date);
		BikeCategory category=new BikeCategory(catagory_id,catagory_name,tire_type,ring_type,backseat,bicycle_seat,username,operator_time);
		cateService.updateCate(category);
		return "cate.do";
	}
	
	@RequestMapping("increase.do")
	public String addCategory(){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String catagory_name=request.getParameter("name");
		String frame_type=request.getParameter("frame");
		String tire_type=request.getParameter("tire");
		double weight=Double.valueOf(request.getParameter("weight"));
		double height=Double.valueOf(request.getParameter("height"));
		double length=Double.valueOf(request.getParameter("length"));
		String ring_type=request.getParameter("ring");
		String basket=request.getParameter("basket");
		String backseat=request.getParameter("backseat");
		String bicycle_seat=request.getParameter("seat");
		String handBrake=request.getParameter("brake");
		String remark=request.getParameter("remark");
		String username=(String)session.getAttribute("username");
	    Date date=new Date();
	    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String operator_time=format.format(date);
		BikeCategory category=new BikeCategory(catagory_name,frame_type,tire_type,weight,height,length,ring_type,basket,backseat,bicycle_seat,handBrake,remark,username,operator_time);
		cateService.insertCate(category);
		return "cate.do";
	}
	
}
