<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GreatIdeas Dashboard</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous"></head>
<body>
<div class="container">
    <h1>Hello, ${loggedIn.name}</h1>
    <h2>Great Ideas!</h2>
    <p>${notAllowed}</p>
    <table class="table">
    	<tr>
    		<th>GreatIdea</th>
    		<th>Created By:</th>
    		<th>Likes</th>
    		<th>Action</th>
    	</tr>
   		<c:forEach items="${greatIdeas}" var="greatIdea">
   		<tr>
   			<td><a href="/greatIdeas/${greatIdea.id}">${greatIdea.idea}</a></td>
   			<td>${greatIdea.user.name}</td>
   			<td>${greatIdea.usersLiked.size()} </td>
   			<td><a href="/greatIdeas/${greatIdea.id}/like">like</a></td>
   		</tr>
   		</c:forEach>
    </table>
    <input type="button" onclick="location.href='/greatIdeas/new';" value="Create a GreatIdea" />
    <input type="button" onclick="location.href='/logout';" value="Log out" />
  </div>
</body>
</html>