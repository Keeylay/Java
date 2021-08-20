<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <title>Show</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container">
    <h1>${recipe.menuItem}</h1>
    <p>Created by:     ${recipe.user.firstName}</p>
    <p>Description: ${recipe.description}</p>
    
    <h1>Users who liked your idea</h1>
    <table>
    	<tr>
    		<th>Name</th>
    	</tr>
    	<c:forEach items="${recipe.usersLiked}" var="user">
    		<tr>
    			<td>${user.firstName}</td>
    		</tr>
    	</c:forEach>
    </table>
  </div>
  <a href="/recipes/${recipe.id}/edit" class="btn btn-info" role="button">Edit</a>
  <a href="/recipes">Dashboard</a>
  <a href="/logout">Log out</a>
</body>
</html>