<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 	<SCRIPT LANGUAGE="Javascript">
		function checkEmail(){
			window.location="/profile"
		}
		
		function addToBasket(){
			window.location="/basket"
		}
	</SCRIPT>
<body>
<div>
Please login
<form action="/profile">
Email: <input type="text" name="email"/>
Password: <input type="password" name="password"/>

<input onClick="checkEmail" type="submit" value="Login"/>
</form>
</div>
<br>
<br>
<br>
<br>
<div>
Otherwise please register
<form action="/register" method="post" method="post">
First Name: <input type="text" name="firstName"/><br>
Last Name: <input type="text" name="lastName"/><br>
Email: <input type="text" name="email"/><br>
Address Line 1: <input type="text" name="firstLine"/><br>
Address City: <input type="text" name="city"/><br>
Address PostCode: <input type="text" name="postCode"/><br>
Password: <input type="password" name="password"/><br>
<input type="submit" value="Register"/>
</form>
</div>

</body>
</html>