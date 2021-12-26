<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit idea</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h1>Edit <c:out value="${show.showName}"/></h1>

    <form:form action="/shows/${show.id}/edit" method="post" modelAttribute="show">
        <input type="hidden" name="_method" value="put">
        <p>
            <form:label path="showName">Title:</form:label>
            <form:errors path="showName"/>
            <form:input class="form-control" path="showName"/>
        </p>
        <p>
            <form:label path="network">Network:</form:label>
            <form:errors path="network"/>
            <form:input class="form-control" path="network"/>
        </p>
        <button class="btn btn-success">Update</button>
    </form:form>
    <form  action="/shows/${show.id}/delete" method="post">
        <input type="hidden" name="_method" value="delete">
        <button class="btn btn-warning mt-2">Delete</button>
    </form>
</div>



</body>
</html>