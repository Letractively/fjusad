<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增旅程資料</title>
</head>
<body>
<form action="/trip/add" method="post">
旅程類別:<select name="category">
<option value="RegularTrip">一般旅程</option>
<option value="HolidayTrip">假日旅程</option>
</select><p>
旅程名稱:<input type="text" name="name" /><p>
公里數:<input type="text" name="kilometers" /><p>
日數:<input type="text" name="days" /><p>
<input type="submit" value="新增" /><p>
</form>

</body>
</html>