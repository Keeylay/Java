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
        <h1>Ninjas</h1>
        <c:forEach items='${ allNinjas }' var='p'>
            <div>
                ${p.first_name}
                ${p.last_name}
                ${p.age}
            </div>
        </c:forEach>
    </div>

    <div class="container">
        <h3>New Ninja</h3>
        <form:form class="form-group" action="/ninja/create" method="post" modelAttribute="ninja">
        <div>
            <form:label path="first_name">First Name</form:label>
            <form:errors class="text-danger" path="first_name"/>
            <form:input class="form-control" path="first_name"/>
        </div>
        <div>
            <form:label path="last_name">Last Name</form:label>
            <form:errors class="text-danger" path="last_name"/>
            <form:input class="form-control" path="last_name"/>
        </div>
        <div>
            <form:label path="age">Age</form:label>
            <form:errors class="text-danger" path="age"/>
            <form:input class="form-control" path="age"/>
        </div>
        <div>
            <form:label path="dojo">Dojo</form:label>
            <form:errors class="text-danger" path="dojo"/>
            <form:select class="form-select" path="dojo">
                <c:forEach items='${ allDojos }' var='p'>
                    <option value="${p.id}">${p.name}</option>
                </c:forEach>
            </form:select>
        </div>
        <input type="submit" value="Submit"/>
    </form:form>    
    </div>

    <div class="container">
        <a href="/">Back to the Dojos</a>
    </div>
</body>
</html>