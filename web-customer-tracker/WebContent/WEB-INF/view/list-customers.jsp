<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
	<title>List Customer</title>
	
	<!-- reference our style sheet  -->
	<link type = "text/css" rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/style.css" />
		  
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">	  
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	
	<div id = "wrapper">
		<div id = "header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>	
	</div>
	
		
	<div id = "container">
	
		<div id = "content">
		
			<div class="row">
				<div class="col-md-4">
						<!-- put new button -->
						<input type = "button" value = "Add Customer" 
						onClick="window.location.href='showFormForAdd'; return false" class="add-button">
				</div>
				<div class="col-md-8">				
					<form:form action="search" method="POST">
		                Search customer: <input type="text" name="theSearchName" />
		                
		            	<input type="submit" value="Search" class="add-button" />
		            
		            </form:form>
				</div>
			</div>
			
			<!-- add our html table here -->
			<table>
				<tr>
					<th> First Name </th>
					<th> Last Name </th>
					<th> Email </th>
					<th> Action </th>
				
				</tr>	

				<!-- loop over and print our customers -->
				<c:forEach var ="customer" items="${customers}">
				
					<!-- construct an "update link with customer id -->
					<c:url var = "updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${customer.id }" />
					</c:url>
					
					<!-- construct an "delete link with customer id -->
					<c:url var = "deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${customer.id }" />
					</c:url>
					<tr> 
						<td> ${customer.firstName } </td>
						<td> ${customer.lastName } </td>
						<td> ${customer.email } </td>
						
						<td> 
							<!-- display the update and Delete link  -->
							<a href="${updateLink}">Update</a> |
							 <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this?'))) return false">Delete</a>
						</td>						
					</tr>
					
				</c:forEach>
			
			</table>
		
		</div>
		
	</div>
	
</body>
</html>