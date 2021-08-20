<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Submitted Info</h1>
	Name: <c:out value="${ name }" />
	Dojo: <c:out value="${ Location_chosen }" />
	Favorite Language: <c:out value="${ favorite_language }" />
	Comment: <c:out value="${ comment }" />
</body>
</html>