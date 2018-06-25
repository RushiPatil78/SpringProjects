<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
	.error{
		color:red;
	}
</style>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" >
<script>
	function checkData(){
		alert(document.getElementById("name").value);
		return false;
	}
</script>
<div class="container">
<div class="alert alert-info">
  ${msg}
</div>
<a href="list.htm" class="btn btn-primary">Manage Customer</a>
<form:form name="frmCustomer" modelAttribute="customer" action="save.htm" method="post">
	<table class="table">
		<tr>
			<td>Customer Id: </td>
			<td><form:input path="customerId" type="text" name="customerId" id="customerId" /></td>			
		</tr>
		<tr>
			<td>Customer Name: </td>			
			<td><form:input path="name" type="text" name="name" id="name" /></td>			
		</tr>
		<tr>
			<td colspan="2"><button class="btn btn-primary" type="submit" onClick="checkData()">Save</button></td>			
		</tr>
	</table>
</form:form>
</div>

