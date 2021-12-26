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
    <div class="d-flex justify-content-end m-3">
        <h1>Welcome, <c:out value="${user.name}"/> </h1>
        <a href="/logout" class="ml-1"><button class="btn btn-warning mt-2">LogOut</button></a>

    </div>
    <table id="myTable" class="table">
        <thead>
        <tr>
            <th scope="col" onclick="sortTable(1)">Show</th>
            <th scope="col">Network</th>
            <th scope="col">Avg Rating</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${shows}" var="tvShows">
            <tr>
                <td><a href="/shows/${tvShows.id}"><c:out value="${tvShows.showName}"></a> </c:out></td>
                <td><c:out value="${tvShows.network}"/></td>
                <td><c:out value="${tvShows.averageRating}"/> </td>
                <td>
                    <c:set value="${tvShows.raties}" var="raties"/>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/shows/new"><button>Create a show</button></a>


</div>

<script type="text/javascript" src="${pageContext.request.contextPath}js/table.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
