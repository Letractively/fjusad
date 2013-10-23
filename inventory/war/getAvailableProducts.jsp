<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="javax.jdo.Query" %>
<%@ page import="java.util.List" %>
<%@ page import="inventory.*" %>
<%@ page import="shared.PMF" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>可供貨商品</title>
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
<tr><td>產品編號</td><td>類別</td><td>產品描述</td><td>存量</td><td>安全存量</td><td></td>
<%
        for (Product p : results) {
%>
<tr>
<td><%=p.getId() %></td>
<td><%=p.getCategory() %></td>
<td><%=p.getDesc() %></td>
<td><%=p.getInventory() %></td>
<td><%=p.getReorderPoint() %></td>
<td><a href="/inventory/sell?PNO=<%=p.getId()%>">銷貨</a>
</tr>
<% 
        }// for
    } else {
    	out.println("無商品資料!");
    }
} finally {
    query.closeAll();
    pm.close();
}
%>
</table>
<a href="inv_index.jsp">回到首頁</a>
</body>
</html>