<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>create product</title>
</head>
<body>
<form action="/inventory/add" method="post">
類別:<select name="category">
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
</select><p>
描述:<input type="text" name="desc" /><p>
庫存量:<input type="text" name="inventory" /><p>
安全存量:<input type="text" name="reorderPoint" /><p>
<input type="submit" value="新增" /><p>
</form>

</body>
</html>