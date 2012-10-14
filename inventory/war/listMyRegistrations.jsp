<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="javax.jdo.Query" %>

<%@ page import="java.util.List" %>
<%@ page import="seminar.*" %>
<%@ page import="shared.*" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>list all my registrations</title>
</head>
<body>
<table border="1">
<tr><td>講座</td><td>日期</td>
<%
UserService userService = UserServiceFactory.getUserService();
User user = userService.getCurrentUser();

PersistenceManager pm = PMF.get().getPersistenceManager();
Query query = pm.newQuery(Seminar.class);
//Query query = pm.newQuery(Registration.class);
//query.setFilter("username == nameParam");
//query.declareParameters("String nameParam");

try{
//List<Registration> results = (List<Registration>) query.execute(user.getNickname());
//List<Registration> results = (List<Registration>) query.execute();
//for (Registration r:results){
	//Seminar s = r.getSeminar();
	
	List<Seminar> results = (List<Seminar>) query.execute();
	for (Seminar s:results){
		if (s.checkRegistration(user.getNickname())){
%>
<tr>
	<td><%=s.getName()%></td>
	<td><%=s.getDate()%></td>
</tr>
<%	
		} // if
	}// for

} finally {
    query.closeAll();
    pm.close();
}

%>
</table>
<a href="sem_index.jsp">回到首頁</a>
</body>
</html>