<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Recipe</title>
</head>
  <div class="container">
    <h1>Edit ${recipe.menuItem}</h1>
<%--     <p><c:out value="${error}" /></p> --%>
    <form:form method="POST" action="/recipes/${recipe.id}/edit" modelAttribute="recipe">
        <p>
            <form:label path="menuItem">Menu Item:</form:label>
            <form:errors path="menuItem"/>
            <form:input type="textarea" path="menuItem"/>
            
            <form:label path="description"> Description:</form:label>
            <form:errors path="description"/>
            <form:input type="textarea" path="description" />
        </p>
        <input type="submit" value="Update"/>
    </form:form>
    <input type="button" onclick="location.href='/recipes/${recipe.id}/delete';" value="Delete" />
  </div>
  <a href="/recipes">Dashboard</a>
  <a href="/logout">Log out</a>
</html>