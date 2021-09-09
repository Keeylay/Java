<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Showing one Great Idea at a time</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>${greatIdea.idea}</h1>
    <p>Created by: ${greatIdea.user.name}</p>
    <h4>Who like this Idea</h4>
    <table class="table">
    	<tr>
    		<th>Name</th>
    	</tr>
    	<c:forEach items="${greatIdea.usersLiked}" var="user">
    		<tr>
    			<td>${user.name}</td>
    		</tr>
    	</c:forEach>
    </table>
    <hr>
  <input type="button" onclick="location.href='/greatIdeas/${greatIdea.id}/edit';" value="Edit" />
  <input type="button" onclick="location.href='/greatIdeas';" value="Dashboard" />
  </div>
</body>
</html>