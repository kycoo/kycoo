<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<c:if test="${empty sessionScope.person.name}">
		<h1>Hello, Spring MVC!</h1>
		</c:if>
		<c:if test="${not empty sessionScope.person.name}">
		<h1>Hello, ${person.name}</h1>
		</c:if>
	</body>
</html>