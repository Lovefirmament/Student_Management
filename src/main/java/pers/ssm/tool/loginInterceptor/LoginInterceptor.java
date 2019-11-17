package pers.ssm.tool.loginInterceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
  @Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	//获取请求的url
	  String url=request.getRequestURI();
	  //判断url是否为公开地址
	  if(url.indexOf("login")>=0) {
		  return true;
	  }
	  //判断session
	  
	  HttpSession session=request.getSession();
	  String name=(String)session.getAttribute("name");
	  if(name!=null)
	  {
		  return true;
	  }
	  request.getRequestDispatcher("/publish/login/login.html").forward(request, response);
	return false;
}
}
