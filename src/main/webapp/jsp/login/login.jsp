<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css">
<title>修改</title>
</head>
<body>
    <div class="navbar navbar-default navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
            <span class="navbar-brand">学生信息管理系统</span>
        </div>
        <div id="navbar" >
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">注册</a></li>
          </ul>
        </div>
      </div>
    </div>
    
    
    <div class="container-fluid">
    <div class="col-sm-4">
    </div>
    <div class="col-sm-3">
    	<div class="row">
       <form class="login"  action="${pageContext.request.contextPath }/login.action" method="post">
         <div class="form-group">
         <p class="lable">用户名</p>
         <input type="text" class="form-control form1" name="name" >
         </div>
         <div class="form-group">
         <p class="lable">密码</p>
         <input type="password" class="form-control form1" name="password" >
         </div>
		  <input class="btn btn-primary btn1" type="submit" value="登录">
        </form>
      </div>
    </div>
     <div class="col-sm-5">
    </div>
   </div>
</body>
</html>