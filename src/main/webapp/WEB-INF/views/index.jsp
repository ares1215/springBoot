<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/resources/js/script.js"></script>
<script type="text/javascript">
$(function() {
	test();
});
</script>

</head>
<body>
	<div>
		<c:if test="${pageContext.request.userPrincipal.name == null}">
			<a href="/login">login</a>
		</c:if>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			${pageContext.request.userPrincipal.name}
			<sec:authentication property="principal.authorities" />
			<form action="/logout" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> <input type="submit" value="logout">
			</form>
		</c:if>
	</div>
	<div>
		<h1>${msg}</h1>
	</div>
</body>
</html>