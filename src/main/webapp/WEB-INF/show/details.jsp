<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ideas</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h1><c:out value="${show.showName}"/> </h1>
    <p>Network: <c:out value="${show.network}"/></p>

    <h2>Users who rated this show:</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name:</th>
            <th scope="col">Rating:</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="raties" items="${show.raties}">
            <tr>
                <td><c:out value="${raties.name}"/> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="d-flex justify-content-around">
        <a href="/shows/${show.id}/edit"><button>Edit</button></a>
    </div>





</div>

</body>
</html>