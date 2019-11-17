package pers.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.ssm.po.Login;
import pers.ssm.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@CrossOrigin
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login")
	public String login(Model mdoel,HttpSession session,HttpServletRequest http) {
		String name=http.getParameter("name");
		String password=http.getParameter("password");
		int type=Integer.parseInt(http.getParameter("type"));
		Login login=new Login();
		login.setName(name);
		login.setPassword(password);
		login.setType(type);
		if(loginService.query(login)&&type==1)
		{
			session.setAttribute("name", name);
			return "redirect:/publish/admin/query.html";
		}
		else if(loginService.query(login)&&type==0)
		{
			session.setAttribute("name", name);
			return "redirect:/publish/user/query.html";
		}
		else {
			return "redirect:/publish/login/login.html";
		}
	}
	@RequestMapping("/logout")
	public String logout(Model model,HttpSession session)
	{
		session.invalidate();
		return "redirect:/publish/login/login.html";
	}
	@RequestMapping("/success")
	@ResponseBody
	public String success(HttpSession session)
	{
		String name=(String)session.getAttribute("name");
		return name;
	}

}
