package pers.ssm.loginInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
  @Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	// 获取请求的url
	  String url=request.getRequestURI();
	  //判断url是否是公开地址
	  if(url.indexOf("login.action")>=0) {
		  return true;
	  }
	  //判断session
	  
	  HttpSession session=request.getSession();
	  String name=(String)session.getAttribute("name");
	  if(name!=null)
	  {
		  return true;
	  }
	  request.getRequestDispatcher("/jsp/login/login.jsp").forward(request, response);
	return false;
}
}
