<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/addBook" method="post">
	Title: <input type="text" name="title"/><br>
	Author: <input type="text" name="author"/><br>
	ISBN: <input type="text" name="ISBN"/><br>
	Catagory: <input type="text" name="catagory"/><br>
	Stock Number<input type="text" name="stock_number"/><br>
	ebook available: <input type="checkbox" name="ebook_available"/><br>
	Synopsis: <input type="text" name="synopsis"/><br>
	
	<input type="submit"/>

</form>
</body>
</html>