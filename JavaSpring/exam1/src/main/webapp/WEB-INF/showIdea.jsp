<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container">
    <h1>${idea.content}</h1>
    <p>Created by:     ${idea.user.name}</p>
    
    <h1>Users who liked your idea</h1>
    <table>
    	<tr>
    		<th>Name</th>
    	</tr>
    	<c:forEach items="${idea.usersLiked}" var="user">
    		<tr>
    			<td>${user.name}</td>
    		</tr>
    	</c:forEach>
    </table>
  </div>
  <a href="/ideas/${idea.id}/edit" class="btn btn-info" role="button">Edit</a>
  <a href="/ideas">Dashboard</a>
  <a href="/logout">Log out</a>
</body>
</html>