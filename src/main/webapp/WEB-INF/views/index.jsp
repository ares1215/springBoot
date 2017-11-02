<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<h1>${msg}</h1>
	<br>
	<c:if test="${pageContext.request.userPrincipal.name == null}">
		<a href="/login">login</a>
	</c:if>
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<form action="/logout" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit" value="logout">
		</form>
	</c:if>
</body>
</html>