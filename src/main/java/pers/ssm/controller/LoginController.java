package pers.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pers.ssm.po.Login;
import pers.ssm.service.LoginService;



@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login")
	public String login(Model mdoel, HttpSession session, HttpServletRequest http, Login login) {
		int type=Integer.parseInt(http.getParameter("login"));
		login.setType(type);
		if(loginService.query(login)&&type==1)
		{
			String name=login.getName();
			session.setAttribute("name", name);
			return "redirect:/admin/query.action";
		}else if(loginService.query(login)&&type==0)
		{
			String name=login.getName();
			session.setAttribute("name", name);
			return "redirect:/student/query.action";
		}
		else {
			return "redirect:/jsp/login/login.jsp";
		}
	}
	@RequestMapping("/logout")
	public String logout(Model model,HttpSession session)
	{
		session.invalidate();		
		return "redirect:/jsp/login/login.jsp";
	}
}
