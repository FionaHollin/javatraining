<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 > Welcome ${customer.firstName}</h1><br>
	
	<h2> Please amend your details accordingly:</h2><br>
	<form action="/update">
	First Name: <input value="${customer.firstName}" name="firstName" type="text"/><br>
	Surname: <input value="${customer.lastName}" name="lastName" type="text"/><br>
	Email: <input value="${customer.email}" name="email" type="text"/><br>
	Address:<br>
	First Line: <input value="${customer.firstLine}" name="firstLine" type="text"/><br>
	City: <input value="${customer.city}" name="city" type="text"/><br>
	Post Code:<input value="${customer.postCode}" name="postCode" type="text"/><br>
	Password:<input value="${customer.password}" name="password" type="password"/><br>
	<input value="${customer.id}" name="id" type="hidden"/>
	<input type="submit" value="Save Changes"/>
	</form>
	<br/>
	<br/>
</body>
</html>