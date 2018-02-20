<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="/resources/js/script.js"></script>
<script type="text/javascript">
	$(function() {
		test();
	});
</script>

</head>
<body>
	<div>list</div>
	<div>
		<c:forEach var="user" items="${user.content}">
			<div>${user.id}, ${user.name}</div>
		</c:forEach>
	</div>
</body>
</html>