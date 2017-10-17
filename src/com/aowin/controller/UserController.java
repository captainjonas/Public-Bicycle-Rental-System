package com.aowin.controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aowin.model.User;
import com.aowin.service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private HttpServletRequest request;
	@Resource
	private HttpSession session;
	@Resource
	private ServletContext application;
	
	@RequestMapping("login.do")
	public String checkUser(){
		int number;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String checkcode=request.getParameter("checkcode");
		User user=new User(username,password);
		boolean flag=userService.checkUser(user);
		boolean fCode=true;
		if(!checkcode.equals("1150"))
			fCode=false;
		if(flag&&fCode){
			session.setAttribute("username", username);
			Object vNum=application.getAttribute("no");
			if(vNum==null){
				number=1;
			}else{
				number=(Integer)vNum+1;
			}
			application.setAttribute("no",number);
			return "index.jsp";
		}else{
			request.setAttribute("logFlag", 0);
			return "login.jsp";
		}
	}
	
	@RequestMapping("logout.do")
	public String logout(){
		session.removeAttribute("username");
		return "index.jsp";
	}
	
	
}
