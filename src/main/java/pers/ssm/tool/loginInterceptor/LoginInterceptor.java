package pers.ssm.tool.loginInterceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
  @Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	//��ȡ�����url
	  String url=request.getRequestURI();
	  //�ж�url�Ƿ�Ϊ������ַ
	  if(url.indexOf("login")>=0) {
		  return true;
	  }
	  //�ж�session
	  
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
