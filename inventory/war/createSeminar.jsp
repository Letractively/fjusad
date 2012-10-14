<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="shared.MyDateUtil" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>create seminar</title>
</head>
<body>
<%
 %>
<form action="/seminar/add" method="post">
講座名稱:<input type="text" name="SID" /><p>
日期:<input type="text" name="DATE" value=<%=MyDateUtil.getTodayString()%>/>(MM/dd/yyyy)<p><p>
名額:<input type="text" name="MAX" /><p>
<input type="submit" value="新增" /><p>
</form>

</body>
</html>