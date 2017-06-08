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
	<SCRIPT LANGUAGE="Javascript">
		
		function find(){
			console.log("search?");
			window.location="/browse";
		}

		function logout(id){
			window.location="/logout?id=" + id;
		}
		
		function editDetails(id){
			window.location="/edit?id="+ id;
		}

	</SCRIPT>

	
	<h1 > Welcome ${customer.firstName}</h1><br>
	
	<h2> These are the account details we have for you currently:</h2><br>
	First Name:${customer.firstName}<br>
	Surname: ${customer.lastName}<br>
	Email: ${customer.email}<br>
	Address:${customer.firstLine}<br>
	${customer.city}<br>
	${customer.postCode}<br>
	<br/>
	<br/>
	<button onClick="find()">Browse</button>
	<button onclick="logout(${customer.id})">Logout</button>
	<button onclick="editDetails(${customer.id})">Amend details</button>
</body>
</html>