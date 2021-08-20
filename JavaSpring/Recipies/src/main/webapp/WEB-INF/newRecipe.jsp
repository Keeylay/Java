<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Recipe</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container">
    <h1>Create New Recipe!</h1>
    <p><c:out value="${error}" /></p>
    <form:form method="POST" action="/recipes/new" modelAttribute="newRecipe">
        <p>
            <form:label path="menuItem">Menu Item:</form:label>
            <form:errors path="menuItem"/>
            <form:input type="textarea" path="menuItem"/>
            
            <form:label path="description">Description:</form:label>
            <form:errors path="description"/>
            <form:input type="textarea" path="description"/>
        </p>
        <input type="submit" value="Create!"/>
    </form:form>
    <a href="/recipes">Dashboard</a>
  <a href="/logout">Log out</a>
  </div>
</body>
</html>