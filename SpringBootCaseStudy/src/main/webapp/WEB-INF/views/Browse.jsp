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
<SCRIPT LANGUAGE=Javascript>
	function logout(){
		window.location="/logout"
	}

</SCRIPT>
	<form action="/searchByTitle">
	Search By Title: <input type="text" name="title">
	<input type="submit" value="Search">
	</form>
	<br/>
	<br/>
	<br/>
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
	<c:forEach items="${allBooks}" var="book">
	<tr>
	<th>
	${book.title}
	</th>
	<th>
	${book.author}
	</th>
	<th>
	${book.ISBN}
	</th>
	<th>
	${book.catagory}
	</th>
	<th>
	${book.stock_number}
	</th>
	<th>
	${book.ebookAvailable}
	</th>
	<th>
	<form action="/more">
	<input type="hidden" name="title" value="${book.title}"/>
	<input type="submit" value="View More"/>
	</form>
	</th>
	<th>
	<form action="/basket">
	<input type="hidden" name="id" value="${book.id}"/>
	<input type="submit" value="Add to Basket"/>
	</form>
	</th>
	</tr>
	</c:forEach>
	</table>
<button onclick="logout()">Logout</button>
</body>
</html>