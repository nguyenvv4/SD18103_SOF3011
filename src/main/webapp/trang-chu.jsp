<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 30/06/2023
  Time: 09:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <c:set--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body class="container">
<form action="/add" method="post">
    <label class="form-label">ID</label>
    <input type="text" class="form-control" name="id">
    <label class="form-label">Name</label>
    <input type="text" class="form-control" name="name">
    <label class="form-label">Age</label>
    <input type="text" class="form-control" name="age">
    <label class="form-label">Address</label>
    <input type="text" class="form-control" name="address">
    <button type="submit"class="btn btn-primary">Submit</button>
</form>
<table class="table">
    <thead>
    <tr>
        <td>ID</td>
        <td>Ten</td>
        <td>Tuoi</td>
        <td>Dia chi</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>${u.age}</td>
            <td>${u.address}</td>
            <td>
                <a href="/delete?id=${u.id}" class="btn btn-primary">Xoa</a>
                <a href="/detail?id=${u.id}" class="btn btn-primary">Detail</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
