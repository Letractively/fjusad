<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="javax.jdo.Query" %>
<%@ page import="java.util.List" %>
<%@ page import="shared.MyDateUtil" %>
<%@ page import="shared.PMF" %>
<%@ page import="seminar.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>�Ҧ����y</title>
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
<tr><td>���y</td><td>���</td><td>�W�B</td><td>���W�H��</td><td></td><td></td>
<%
        for (Seminar s : results) {
%>
<tr>
<td><%=s.getName() %></td>
<td><%=MyDateUtil.format(s.getDate()) %></td>
<td><%=s.getMaxRegistrations() %></td>
<td><%=s.getCount() %></td>
<td><a href="/register.jsp?SNO=<%=s.getId()%>">���W</a></td>
<td><a href="/listAllRegistrations.jsp?SNO=<%=s.getId()%>">�Ҧ����W���</a></td>
</tr>
<% 
        }// for
    } else {
    	out.println("�L���y���!");
    }
} finally {
    query.closeAll();
    pm.close();
}
%>
</table>
<a href="sem_index.jsp">�^�쭺��</a>
</body>
</html>