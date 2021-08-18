<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
        <h1>${dojo.name}</h1>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Age</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items='${ dojo.ninjas }' var='ninja'>
                        <tr>
                            <td>${ninja.first_name}</a></td>
                            <td>${ninja.last_name}</td>
                            <td>${ninja.age}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <hr>
        <div class="container">
            <div class="container">
                <a href="/">Back to the Dojos</a>
            </div>
            <div class="container">
                <a href="/ninja">Create a Ninja</a>
            </div>
        </div>
    </div>
</body>
</html>