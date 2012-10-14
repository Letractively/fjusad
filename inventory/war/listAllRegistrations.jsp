<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="java.util.List" %>
<%@ page import="seminar.*" %>
<%@ page import="shared.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>list all registrations</title>
</head>
<body>
<table border="1">
<tr><td>姓名</td>
<%
String seminarID_S = request.getParameter("SNO");
Long seminarID = 0L;
try{
	seminarID = Long.parseLong(seminarID_S);
}
catch (NumberFormatException e){
	//implementation is needed
}

PersistenceManager pm = PMF.get().getPersistenceManager();
Seminar s = pm.getObjectById(Seminar.class, seminarID);
List<Registration> reg = s.getAllRegistrations();
for (Registration r:reg){
%>
<tr>
<td><%=r.getName()%></td>

</tr>
<%}// for
    pm.close();%>
</table>
<a href="sem_index.jsp">回到首頁</a>
</body>
</html>