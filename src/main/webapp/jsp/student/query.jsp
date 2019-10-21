<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/query.css">
    <title>学生信息</title>
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
   <div class="row">
    <div class="col-sm-2 sidebar">
        <ul class="nav nav-sidebar">
            <li class="li1"><a href="#">学生信息</a></li>
            <li class="li2"><a href="#">宿舍管理</a></li>
            <li class="li2"><a href="#">考试成绩</a></li>
            <li class="li2"><a href="#">课程安排</a></li>
        </ul>
    </div>
    <div class="col-sm-10 query">
        <h1 class="page-header">学生信息</h1>
        <a class="btn btn-primary insertbutton" href="${pageContext.request.contextPath }/student/insert.action">新增 </a>
        <table class="table table-striped">
            <tr>
                <th>姓名</th>
                <th>学号</th>
                <th>性别</th>
                <th>出生日期</th>
                <th>专业</th>
                <th>联系方式</th>
                <th>地址</th>
                <th>操作</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${pageUtil.list}" var="student">
                <tr>
                    <td>${student.name }</td>
                    <td>${student.number }</td>
                    <td>${student.gender }</td>
                    <td><fmt:formatDate value="${student.DOB }" pattern="yyyy-MM-dd"/></td>
                    <td>${student.major}</td>
                    <td>${student.phone }</td>
                    <td>${student.address }</td>
                    <td><a href="${pageContext.request.contextPath }/student/update.action?id=${student.id}">修改</a></td>
                    <td><a href="${pageContext.request.contextPath }/student/delete.action?id=${student.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
        <p class="p1">共${pageUtil.pageNumber}页,当前第${pageUtil.pageCurrent}页,信息条数:${pageUtil.pageCount}条</p>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li><a href="${pageContext.request.contextPath}/student/query.action?pageCurrent=1">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/student/query.action?pageCurrent=${pageUtil.pageBefore}">上一页</a></li>
                <li><a href="${pageContext.request.contextPath}/student/query.action?pageCurrent=${pageUtil.pageAfter}">下一页</a></li>
                <li><a href="${pageContext.request.contextPath}/student/query.action?pageCurrent=${pageUtil.pageNumber}">尾页</a></li>
            </ul>
        </nav>

    </div>
   </div>
</div>
</body>
</html>