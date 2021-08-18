<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
	<div class="container">
        <h1>Dojos</h1>
        <c:forEach items='${ allDojos }' var='p'>
            <div>
                <a href="/dojo/${p.id}">${p.name}</a>
                ${p.id}
            </div>
        </c:forEach>
    </div>

    

    <div class="container">
        <h3>New Dojo</h3>
        <form:form class="form-group" action="/dojo/create" method="post" modelAttribute="dojo">
        <div>
            <form:label path="name">Name</form:label>
            <form:errors class="text-danger" path="name"/>
            <form:input class="form-control" path="name"/>
        </div>
        <input type="submit" value="Submit"/>
    </form:form>    
    </div>

    <div class="container">
        <a href="/ninja">Create a Ninja</a>
    </div>

</body>
</html>