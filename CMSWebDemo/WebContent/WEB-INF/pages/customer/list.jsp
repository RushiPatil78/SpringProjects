<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<!--  <link href="<c:url value="/resources/css/cms.css" />" rel="stylesheet"> -->
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" >	
</head>
<div class="container">
<h1>Manage Customers </h1>

<table class="table table-striped">
	<tr>
		<th>ID</th>
		<th>NAME</th>	
		<th>Action</th>	
	</tr>
	<c:forEach items="${customerList}" var="customer">
		<tr>
			<td>${customer.customerId}</td>
			<td>${customer.name}</td>
			<td><a href="edit.htm?id=${customer.customerId}">Edit</a></td>
		</tr>
	</c:forEach>	
</table>
<a href="new.htm" class="btn btn-primary">New</a>
</div>