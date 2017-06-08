<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<SCRIPT LANGUAGE=Javascript>
	function logout(id){
		window.location="/logout?id=" + id;
	}

</SCRIPT>

<h1>Shopping Basket for ${customer.firstName} ${customer.lastName}</h1>

<h2>${basket.id}</h2>
<h3>${book.title}</h3>
<h3>${book.author}</h3>
<h3>${book.ISBN}</h3>
<h3>${book.synopsis}</h3>

<button onclick="logout(${customer.id})">Logout</button>
</body>
</html>