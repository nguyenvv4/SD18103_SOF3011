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
<body>
<div class="mb-3">
    <label for="exampleFormControlInput1" class="form-label">Email address</label>
    <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
</div>
<div class="mb-3">
    <label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
</div>

<p>Thong tin user</p>
<p>ID: ${user.id}</p>
<p>Name: ${user.name}</p>
<p>Age: ${user.age}</p>
<p>Add: ${user.address}</p>
<p>Danh sach nhan vien: </p>

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
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>