<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%> <!-- Tells us meta info, what language we're using.. etc.. we can add edits later. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="/js/script.js"></script>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Safe Travels</title>
</head>
<body>

<div class=card>
	<div class=card-header>
		<h2>Edit an Expense</h2>
	</div>
	<form:form action="/expenses/edit/${travel.id}/submit" method="post" modelAttribute="travel" class="mx-5 my-2">
	<input type="hidden" name="_method" value="put">
	<div class="errors">
		<form:errors path="expenseName" class="error"/>
		<form:errors path="vendor" class="error"/>
		<form:errors path="amount" class="error"/>
		<form:errors path="description" class="error"/>
	</div>
		<div class="form-group mb-4">
	    	<form:label path="expenseName">Expense Name</form:label>
	    	<form:input type="text" class="form-control" path="expenseName" />
	  	</div>
		<div class="form-group mb-4">
	    	<form:label path="vendor">Vendor</form:label>
	    	<form:input type="text" class="form-control" path="vendor" />
	  	</div>
		<div class="form-group mb-4">
	    	<form:label path="amount">Amount</form:label>
	    	<form:input type="number" class="form-control" path="amount"/>
	  	</div>
		<div class="form-group mb-4">
	    	<form:label path="description">Description</form:label>
	    	<form:textarea type="text" class="form-control" path="description"/>
	  	</div>
	  	<input class="btn btn-primary" type="submit" value="submit"/>	
	</form:form>
</div>
	<a class="btn btn-primary w-10 mt-4" href="/expenses">Go back</a>
</body>
</html>