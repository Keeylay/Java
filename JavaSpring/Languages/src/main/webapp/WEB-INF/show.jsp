<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <title>Language</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

    <div class="container d-flex justify-content-end">
        <a href="/languages">Dasboard</a>
    </div>


    <div class="container">
        <div class="container d-flex align-items-center justify-content-around">
            <h4>ID:</h4>
            <div>${language.id}</div>
        </div>
        <div class="container d-flex align-items-center justify-content-around">
            <h4>Name:</h4>
            <div>${language.name}</div>
        </div>
        <div class="container d-flex align-items-center justify-content-around">
            <h4>Creator:</h4>
            <div>${language.creator}</div>
        </div>
        <div class="container d-flex align-items-center justify-content-around">
            <h4>Version:</h4>
            <div>${language.version}</div>
        </div>
    </div>

    
    <div class="container">
        <a href="/languages/edit/${language.id}">Edit</a>
        <a href="/languages/delete/${language.id}">Delete</a>
    </div>

</body>
</html>