package pers.ssm.loginInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
  @Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	// ��ȡ�����url
	  String url=request.getRequestURI();
	  //�ж�url�Ƿ��ǹ�����ַ
	  if(url.indexOf("login.action")>=0) {
		  return true;
	  }
	  //�ж�session
	  
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
