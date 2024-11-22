<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Custom Login Page</h1>
	<h2><c:out value="${error}"></c:out></h2>
	<h2><c:out value="${logout}"></c:out></h2>
	
	<form method="post" action="/login">
		<div>
			<input type="text" name="username" value="admin90">
		</div>
		<div>
			<input type="password" name="password" value="1234">
		</div>
		<div>
			<input type="checkbox" name="remember-me">Remember Me
		</div>
		<div>
			<input type="submit" value="로그인">
		</div>
		
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</body>
</html>