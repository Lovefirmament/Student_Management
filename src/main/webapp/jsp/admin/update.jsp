<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/update.css">
<title>修改</title>
</head>
<body>

   <div class="navbar  navbar-fixed-top navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
            <span class="navbar-brand">学生信息管理系统</span>
        </div>
        <div id="navbar" >
          <ul class="nav navbar-nav navbar-right">
            <li><a>当前用户：${sessionScope.name}</a></li>
            <li><a href="${pageContext.request.contextPath }/logout.action?">退出</a>
          </ul>
        </div>
      </div>
    </div>
       <div class="container-fluid">
    <div class="col-sm-4">
    </div>
    <div class="col-sm-3">
   <form id="studentForm"  action="${pageContext.request.contextPath }/admin/updateSubmit.action" method="post" enctype="multipart/form-data">
  <input  type="hidden" name="id" value="${student.id }"/>
	  <div class="form-group">
      <label for="studentname">姓名</label>
      <input type="text" class="form-control" id="studentname" name="name" value="${student.name }"/>
		</div>
       <div class="form-group">
           <label for="studentnumber">学号</label>
           <input type="text" class="form-control" id="studentnumber"name="number"  value="${student.number }"/>
       </div>
	   <div class="form-group">
      <label for="studentgender">性别</label>
      <input type="text" class="form-control" id="studentgender"name="gender"  value="${student.gender }"/>
      </div>
      <div class="form-group">
      <label for="studentDOB">出生日期</label>
      <input type="Date" class="form-control" id="studentDOB"name="DOB" value="<fmt:formatDate value='${student.DOB }' pattern='yyyy-MM-dd'/>"/>
      </div>
	  <div class="form-group">
      <label for="studentmajor">专业</label>
      <input type="text" class="form-control" id="studentmajor"name="major" value="${student.major}"/>
      </div>
      <div class="form-group">
      <label for="studentphone">联系方式</label>
      <input type="text" class="form-control" id="studentphone"name="phone" value="${student.phone}"/>
      </div>
	  <div class="form-group">
      <label for="studentaddress">家庭地址</label>
      <input type="text" class="form-control" id="studentaddress"name="address" value="${student.address }"/>
      </div>
       <div class="form-group">
           <label for="studentpic">个人照片</label>
               <c:if test="${student.pic !=null}">
                   <img src="/pic/${student.pic}" width=100 height=100/>
                   <br/>
               </c:if>
           <input type="file"  id="studentpic" name="pictureFile"/>
       </div>
     <input class="btn btn-primary btn-lg btn1" type="submit" value="提交"  /> 

    </form>
    </div>
    </div>
</body>
</html>