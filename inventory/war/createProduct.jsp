<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>create product</title>
</head>
<body>
<form action="/inventory/add" method="post">
���O:<select name="category">
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
</select><p>
�y�z:<input type="text" name="desc" /><p>
�w�s�q:<input type="text" name="inventory" /><p>
�w���s�q:<input type="text" name="reorderPoint" /><p>
<input type="submit" value="�s�W" /><p>
</form>

</body>
</html>