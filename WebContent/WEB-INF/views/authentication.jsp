<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authentication</title>
</head>
<body>
	<c:if test="${param.error != null}">
		<p>Invalid username/password</p>
	</c:if>
	
	<c:if test="${param.logout != null}">
		<p>You just loggedout!</p>
	</c:if>
	
	<form:form action="authenticate">
		<Label>Username<input type="text" name="username" /></Label> <br/>
		<Label>Password<input type="password" name="password" /> </Label> <br/>
		<input type="submit" value="login" />
	</form:form>	
</body>
</html>