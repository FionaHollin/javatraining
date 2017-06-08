<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<SCRIPT LANGUAGE="Javascript">
		function search(){
			window.location="/browse"
		}
		
		function login(){
			window.location="/login"
		}
	</SCRIPT>
<h1>Welcome to Fiona's Book shop</h1>

<button onclick="search()">Browse</button>
<button onclick="login()">Login or Register</button>



</body>
</html>