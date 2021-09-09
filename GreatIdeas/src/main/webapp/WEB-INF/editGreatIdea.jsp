<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Great Ideas</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Edit ${greatIdea.idea}</h1>
		<input type="button" onclick="location.href='/greatIdeas';" value="Dashboard" />
		<hr>
		<form:form method="POST" action="/greatIdeas/${greatIdea.id}/edit" modelAttribute="greatIdea">
			<p>
				<form:label path="idea">Idea:</form:label>
				<form:errors path="idea"/>
				<form:input type="textarea" path="idea"/>
			</p>
			<input type="submit" value="Update"/>
			<input type="button" onclick="location.href='/greatIdeas/${greatIdea.id}/delete';" value="Delete" />
		</form:form>
	</div>
</body>
</html>