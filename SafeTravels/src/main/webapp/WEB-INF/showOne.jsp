<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/js/script.js"></script>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Safe Travels</title>
</head>
<body>
	<div class="card">
		<div class="card-header">
			<h1>Expense Name: <c:out value="${travel.expenseName}"/></h1>		
		</div>
		<div class="card-body">
			<h2>Vendor: <c:out value="${travel.vendor}"/></h2>
			<h2>Amount: $<c:out value="${travel.amount}"/></h2>
			<h2>Description: <c:out value="${travel.description}"/></h2>		
		</div>
	</div>
	<a href="/expenses">Go back</a>
</body>
</html>