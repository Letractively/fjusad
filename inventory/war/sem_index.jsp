<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>���y�޲z</title>
</head>
<body>
<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    if (user != null) {
%>
<p>�z�ثe�O�H�� <%= user.getNickname() %>�n�J! �p�G�o���O�z���b��,�z�i�H
<a href="<%= userService.createLogoutURL(request.getRequestURI()) %>">�n�X</a>,�A���s�n�J!</p>
<%
    } else {
%>
<p>��
<a href="<%= userService.createLoginURL(request.getRequestURI()) %>">�n�J</a>,
�H�K�d�ݭӤH�����y���W���p</p>
<%
    }
%>


	<ul>
		<ol><a href="listAllSeminars.jsp">���y��T</a></ol>
		<ol><a href="createSeminar.jsp">�s�W���y</a></ol>
		<ol><a href="listMyRegistrations.jsp">�ڪ����W</a></ol>
	</ul>
</body>
</html>
