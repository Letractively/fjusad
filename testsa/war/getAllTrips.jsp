<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="trip.Trip"%>
<%@ page import="trip.PersistenceTrip"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有的旅程資料</title>
</head>
<body>
<table border="1">
<tr><td>編號</td><td>旅程類型</td><td>旅程名稱</td><td>日數</td><td>公里數</td><td>費用</td></tr>
<%List<Trip> results = PersistenceTrip.getAllTrips();
for (Trip t : results) {%>
<tr>
<td><%=t.getId()%></td>
<td><%=t.getCategory()%></td>
<td><%=t.getName()%></td>
<td><%=t.getDays()%></td>
<td><%=t.getKilometers()%></td>
<td><%=t.getCharge()%></td>
</tr>
<%
}

%>
</table>
<a href="createTrip.jsp">新增旅程</a>
</body>
</html>