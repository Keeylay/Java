<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

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
    <h1>Hello, ${name}</h1>
    <p>${error}</p>
    <h2>Ideas</h2>
    <table class="table">
    	<tr>
    		<th>Idea</th>
    		<th>Created By:</th>
    		<th>Likes</th>
    		<th>Action</th>
    	</tr>
    		<c:forEach items="${ideas}" var="idea">
    		<tr>
    			<td><a href="/ideas/${idea.id}">${idea.content}</a></td>
    			<td>${idea.user.name}</td>
    			<td>${fn:length(idea.usersLiked)}</td>
    			<td><a href="/ideas/${idea.id}/like">like</a></td>
    		</tr>
    		</c:forEach>
    </table>
    
    <input type="button" onclick="location.href='/ideas/new';" value="Create an idea" />
    <a href="/logout">Log out</a>
  </div>
</body>
</html>