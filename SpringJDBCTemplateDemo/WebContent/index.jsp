<%@page import="java.util.List"%>
<%@page import="com.rushikesh.service.BookService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import="com.rushikesh.util.*"%>
<%@ page import="com.rushikesh.dto.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	ApplicationContext applicationContext = SpringUtil.getApplicationContext();
	BookService bookService = applicationContext.getBean("bookServiceImpl", BookService.class);
	List<Book> bookList = bookService.getAll();
	pageContext.setAttribute("bookList", bookList);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Add Book</h3>
	<form method="POST" action="AddBookServlet">
		<table>
			<tr>
				<td><input placeholder="Enter Book Name" type="text" id="name"
					name="name" required/></td>
			</tr>
			<tr>
				<td><input placeholder="Enter Book Code" type="text" id="code"
					name="code" required/></td>
			</tr>
			<tr>
				<td><input type="submit" id="Submit" name="Submit"
					value="Add Book" /></td>
			</tr>
		</table>

	</form>
	</br>
	</br>
	<c:if test="${fn:length(pageScope.bookList)>0}">
		<table border="1">
			<tr>
				<td>ID</td>
				<td>NAME</td>
				<td>CODE</td>
				<td>Action</td>
			</tr>
			<c:forEach var="book" items="${pageScope.bookList}">
				<tr>
					<td>${book.id}</td>
					<td>${book.name}</td>
					<td>${book.code}</td>
					<td><a href="EditBook.jsp?id=${book.id}">Edit</a>&nbsp;&nbsp;<a
						href="DeleteBookServlet?id=${book.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${fn:length(pageScope.bookList)<=0}">
	<%="No Data Found!" %>
	</c:if>
</body>
</html>