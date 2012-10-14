<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="javax.jdo.Query" %>
<%@ page import="java.util.List" %>
<%@ page import="inventory.*" %>
<%@ page import="shared.PMF" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>�i�ѳf�ӫ~</title>
</head>
<body>

<table border="1">
<%
PersistenceManager pm = PMF.get().getPersistenceManager();
Query query = pm.newQuery(Product.class);
query.setFilter("inventory > 0");
//query.setOrdering("hireDate desc");
//query.declareParameters("String lastNameParam");

try {
    List<Product> results = (List<Product>) query.execute();
    if (!results.isEmpty()) {
%>
<tr><td>���~�s��</td><td>���O</td><td>���~�y�z</td><td>�s�q</td><td>�w���s�q</td><td></td>
<%
        for (Product p : results) {
%>
<tr>
<td><%=p.getId() %></td>
<td><%=p.getCategory() %></td>
<td><%=p.getDesc() %></td>
<td><%=p.getInventory() %></td>
<td><%=p.getReorderPoint() %></td>
<td><a href="/inventory/sell?PNO=<%=p.getId()%>">�P�f</a>
</tr>
<% 
        }// for
    } else {
    	out.println("�L�ӫ~���!");
    }
} finally {
    query.closeAll();
    pm.close();
}
%>
</table>
<a href="inv_index.jsp">�^�쭺��</a>
</body>
</html>