<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container d-flex justify-content-around">
    <div class="container form-group">
        <h1>Register!</h1>
        <div class="col-3 alert-warning" role="alert">
            <p><form:errors path="user"/></p>
            <p><c:out value="${errorReg}" /></p>
            <p><c:out value="${error}"></c:out> </p>
        </div>
        <div class="form-group">
            <%--@elvariable id="user" type=""--%>
            <form:form method="POST" action="/registration" modelAttribute="user">
                <p>
                    <form:label path="name">First Name:</form:label>
                    <form:input class="form-control" placeholder="name" type="text" path="name"/>
                </p>

                <p>
                    <form:label path="email">Email:</form:label>
                    <form:input class="form-control" placeholder="example@gmail.com" type="email" path="email"/>
                </p>


                <p>
                    <form:label path="password">Password:</form:label>
                        <form:errors path="password"/>
                        <form:password class="form-control" placeholder="Password" path="password"/>

                <p>
                    <form:label path="passwordConfirmation">Password Confirmation:</form:label>
                    <form:password class="form-control" placeholder="Password" path="passwordConfirmation"/>
                </p>
                <input type="submit" value="Register!"/>
            </form:form>
        </div>
    </div>

    <div class="container">
        <h1>Login</h1>
        <p><c:out value="${errorLogin}" /></p>
        <div class="form-group">
            <form method="post" action="/login">
                <p>
                    <label type="text" for="email">Email</label>
                    <input class="form-control" placeholder="email" type="text" id="email" name="email"/>
                </p>
                <p>
                    <label for="password">Password</label>
                    <input class="form-control" placeholder="Password" type="password" id="password" name="password"/>
                </p>
                <input type="submit" value="Login!"/>
            </form>
        </div>
    </div>

</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
