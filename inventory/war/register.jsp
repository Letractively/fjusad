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
�ثe�n�J�b����:<%=user.getNickname() %><p>
<input type="submit" value="�T�w���W" /><p>
</form>

<%
    } else {
%>
<p>��
<a href="<%= userService.createLoginURL(request.getRequestURI()) %>">�n�J</a>
�z��google�b��</p>
<%
    }
%>

</body>
</html>