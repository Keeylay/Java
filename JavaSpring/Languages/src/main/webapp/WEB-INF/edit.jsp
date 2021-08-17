<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <title>Edit ${language.name}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

    <div class="container d-flex justify-content-between">
        <a href="/languages/delete/${language.id}">Delete</a>
        <a href="/languages">Dasboard</a>
    </div>


    <div class="container">
        <form:form action="/languages/update/${language.id}" method="post" modelAttribute="language">
        <p>
            <form:label path="name">Name</form:label>
            <form:errors class="text-danger" path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="creator">Creator</form:label>
            <form:errors class="text-danger" path="creator"/>
            <form:input path="creator"/>
        </p>
        <p>
            <form:label path="version">Version</form:label>
            <form:errors class="text-danger" path="version"/>     
            <form:input type="number" path="version"/>
        </p>    
        <input type="submit" value="Submit"/>
    </form:form>    
    </div>

    

</body>
</html>