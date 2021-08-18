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
    <h1>Create New Idea!</h1>
    <p><c:out value="${error}" /></p>
    <form:form method="POST" action="/ideas/new" modelAttribute="newIdea">
        <p>
            <form:label path="content">Content</form:label>
            <form:input type="textarea" path="content"/>

        </p>
        <input type="submit" value="Create!"/>
    </form:form>
    <a href="/ideas">Dashboard</a>
  <a href="/logout">Log out</a>
  </div>
</body>
</html>