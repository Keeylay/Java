<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Language Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>

<body>

    <div class="container">
        <h1>All Languages</h1>
    </div>

    <div class="container">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Creator</th>
                    <th scope="col">Version</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items='${ allLanguages }' var='p'>
                    <tr>
                        <td><a href="/languages/info/${p.id}">${p.name}</a></td>
                        <td>${p.creator}</td>
                        <td>${p.version}</td>
                        <td><a href="/languages/edit/${p.id}">Edit</a> | <a href="/languages/delete/${p.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="container">
        <form:form action="/languages/create" method="post" modelAttribute="language">
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