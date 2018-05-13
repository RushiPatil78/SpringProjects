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
<%
	ApplicationContext applicationContext = SpringUtil.getApplicationContext();
	BookService bookService = applicationContext.getBean("bookServiceImpl", BookService.class);
	Book book = bookService.get(Integer.parseInt(request.getParameter("id")));
	if(book==null)
	{
		response.sendRedirect("index.jsp");
	}
	/* List<Book> bookList = bookService.getAllBook();
	pageContext.setAttribute("book", bookList); */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Edit Book</h3>
	<form method="POST" action="EditBookServlet">
		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" id="editid" name="editid" 
					value="<%=book.getId()%>" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" id="editname" name="editname"
					value="<%= book.getName() %>" /></td>
			</tr>
			<tr>
				<td>Code</td>
				<td><input type="text" id="editcode" name="editcode" 
				    value="<%= book.getCode() %>" /></td>
			</tr>
			<tr>
				<td><input type="submit" id="Submit" name="Submit"
					value="Edit Book" /></td>
			</tr>
		</table>

	</form>
	</br>
	</br>

</body>
</html>