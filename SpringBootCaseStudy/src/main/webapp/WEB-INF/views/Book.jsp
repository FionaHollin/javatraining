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
		function returnToBrowse(){
			window.location="/browse"
		}
		
		function addToBasket(){
			window.location="/basket"
		}
		function logout(){
			window.location="/logout"
		}

	</SCRIPT>

<table>
	<caption>
	Books currently available to purchase
	</caption>
	<tr>
	<th>
	Title
	</th>
	<th>
	Author
	</th>
	<th>
	ISBN
	</th>
	<th>
	Catagory
	</th>
	<th>
	Remaining Stock
	</th>
	<th>
	Ebook availability
	</th>
	<th>
	</th>
	<th>
	</th>
	</tr>
	<c:forEach items="${book}" var="b">
	<tr>
	<th>
	${b.title}
	</th>
	<th>
	${b.author}
	</th>
	<th>
	${b.ISBN}
	</th>
	<th>
	${b.catagory}
	</th>
	<th>
	${b.stock_number}
	</th>
	<th>
	${b.ebookAvailable}
	</th>
	</tr>
	</c:forEach>
	</table>
	<button onClick="returnToBrowse()">Return to Browsing</button>
	<button onClick="addToBasket()">Add to Basket</button>


<button onclick="logout()">Logout</button>
</body>
</html>