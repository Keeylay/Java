<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="/process" method = "POST">
			<div class = "contrainer mx-auto">
				<div class="form-group">
					<label for = "name">Name:</label>
					<input type="text" name = "name" class = "form-control">
				</div>
				<div class="form-group">
					<label for = "dojo_location">Dojo Location:</label>
					<select name = "Location_chosen" class = "form-control">
						<option value="Chicago">Chicago</option>
						<option value="Dallas">Dallas</option>
						<option value="NYC">NYC</option>
						<option value="Seattle">Seattle</option>
					</select>
				</div>
				<div class="form-group">
					<label for = "favorite_language">Favorite Lanugage:</label>
					<select name = "favorite_language" class = "form-control">
						<option value="Python">Python</option>
						<option value="Java">Java</option>
						<option value="JavaScript">JavaScript</option>
						<option value="Ruby">Ruby</option>
					</select>
				</div>
				<div class="form-group">
					<label for = "name">Comments:</label>
					<textarea name = "comment" cols = "50" rows = "10" class = "form-control"></textarea>
				</div>
				
				<button type="submit" class = "btn btn-outline-info">Submit</button>
			</div>
		</form>
</body>
</html>