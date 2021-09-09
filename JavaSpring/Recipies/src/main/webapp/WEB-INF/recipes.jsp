<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recipe</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container">
    <h1>Hello, ${loggedIn.firstName}</h1>
    <p>${error}</p>
    <h2>Recipes</h2>
    <table class="table">
    	<tr>
    		<th>Recipe</th>
    		<th>Created By:</th>
    		<th>Likes</th>
    		<th>Action</th>
    	</tr>
    		<c:forEach items="${recipes}" var="recipe">
    		<tr>
    			<td><a href="/recipes/${recipe.id}">${recipe.menuItem}</a></td>
    			<td>${recipe.user.firstName}</td>
    			<td>${recipe.usersLiked.size()} </td>
    			<td><a href="/recipes/${recipe.id}/like">like</a></td>
    		</tr>
    		</c:forEach>
    </table>
    
    <input type="button" onclick="location.href='/recipes/new';" value="Create a Recipe" />
    <a href="/logout">Log out</a>
  </div>
</body>
</html>