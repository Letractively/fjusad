<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>講座管理</title>
</head>
<body>
<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    if (user != null) {
%>
<p>您目前是以為 <%= user.getNickname() %>登入! 如果這不是您的帳號,您可以
<a href="<%= userService.createLogoutURL(request.getRequestURI()) %>">登出</a>,再重新登入!</p>
<%
    } else {
%>
<p>請
<a href="<%= userService.createLoginURL(request.getRequestURI()) %>">登入</a>,
以便查看個人的講座報名狀況</p>
<%
    }
%>


	<ul>
		<ol><a href="listAllSeminars.jsp">講座資訊</a></ol>
		<ol><a href="createSeminar.jsp">新增講座</a></ol>
		<ol><a href="listMyRegistrations.jsp">我的報名</a></ol>
	</ul>
</body>
</html>
