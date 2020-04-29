<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<form:form action="logout">
		<input type="submit" value="Logout" />
	</form:form>
	
	<form action="csrf" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="submit" value="hi" />
	</form> 
	
	<security:authorize access="hasRole('ADMIN')">
		<a href="admin">Admin</a> <br/>
	</security:authorize>
	<security:authorize access="hasRole('SALE')">
		<a href="sale">Sale</a> <br/>
	</security:authorize>
	<security:authorize access="hasRole('IT')">
		<a href="it">IT</a> <br/>
	</security:authorize>
</body>
</html>