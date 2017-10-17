package com.aowin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aowin.model.User;
import com.aowin.service.UserService;

@Controller
public class SummaryController {
	@Resource
	private HttpSession session;
	@Resource
	private UserService userService;
	@Resource
	private HttpServletRequest request;
	
	@RequestMapping("summary.do")
	public String checkAuth(){
		String username=(String)session.getAttribute("username");
		if(username==null||username.equals(""))
			return "authority.jsp";
		User user=new User();
		user.setUsername(username);
		int auth_id=userService.getAuthID(user);
		int index=Integer.valueOf(request.getParameter("index"));
		if(auth_id!=1){
			session.removeAttribute("username");
			return "authority.jsp";
		}else{
			if(index==1){
				return "summary/pileSum.jsp";
			}else{
				return "";
			}
		}
	}

}
