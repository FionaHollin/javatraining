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
	function returnhome(){
		window.location="/"
	}

</SCRIPT>
<h1>Goodbye ${customer.firstName}</h1>
<h2>You have successfully logged out</h2>
<button onclick="returnhome()">Return to home page</button>
</body>
</html>