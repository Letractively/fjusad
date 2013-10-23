<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="javax.jdo.Query" %>
<%@ page import="java.util.List" %>
<%@ page import="shared.MyDateUtil" %>
<%@ page import="shared.PMF" %>
<%@ page import="seminar.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>所有講座</title>
</head>
<body>

<table border="1">
<%
PersistenceManager pm = PMF.get().getPersistenceManager();
Query query = pm.newQuery(Seminar.class);
//query.setFilter("inventory > 0");
//query.setOrdering("hireDate desc");
//query.declareParameters("String lastNameParam");

try {
    List<Seminar> results = (List<Seminar>) query.execute();
    if (!results.isEmpty()) {
%>
<tr><td>講座</td><td>日期</td><td>名額</td><td>報名人數</td><td></td><td></td>
<%
        for (Seminar s : results) {
%>
<tr>
<td><%=s.getName() %></td>
<td><%=MyDateUtil.format(s.getDate()) %></td>
<td><%=s.getMaxRegistrations() %></td>
<td><%=s.getCount() %></td>
<td><a href="/register.jsp?SNO=<%=s.getId()%>">報名</a></td>
<td><a href="/listAllRegistrations.jsp?SNO=<%=s.getId()%>">所有報名資料</a></td>
</tr>
<% 
        }// for
    } else {
    	out.println("無講座資料!");
    }
} finally {
    query.closeAll();
    pm.close();
}
%>
</table>
<a href="sem_index.jsp">回到首頁</a>
</body>
</html>