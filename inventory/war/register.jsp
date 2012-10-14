<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>create seminar</title>
</head>
<body>
	<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    if (user != null) {
%>
<form action="/seminar/register" method="post">
<input type="hidden" name="SNO" value="<%=request.getParameter("SNO") %>" />
<input type="hidden" name="NAME" value="<%=user.getNickname() %>" />
目前登入帳號為:<%=user.getNickname() %><p>
<input type="submit" value="確定報名" /><p>
</form>

<%
    } else {
%>
<p>請
<a href="<%= userService.createLoginURL(request.getRequestURI()) %>">登入</a>
您的google帳號</p>
<%
    }
%>

</body>
</html>