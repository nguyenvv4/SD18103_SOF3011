<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 21/07/2023
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>San pham</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body class="container">
<form action="/save" method="post">
    <label class="form-label">Id</label>
    <input type="text" class="form-control" value="${sanPham.id}" type="hidden" name="id">
    <label class="form-label">Ma</label>
    <input type="text" class="form-control" value="${sanPham.ma}" name="ma">
    <label class="form-label">Ten</label>
    <input type="text" class="form-control" value="${sanPham.ten}" name="ten">
    <label class="form-label">Gia Ban</label>
    <input type="text" class="form-control" value="${sanPham.giaBan}" name="giaBan">
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<table class="table">
    <thead>
    <tr>
        <td>ID</td>
        <td>Ma</td>
        <td>Ten</td>
        <td>Gia Ban</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.ma}</td>
            <td>${u.ten}</td>
            <td>${u.giaBan}</td>
            <td>
                <a href="/delete?id=${u.id}" class="btn btn-primary">Xoa</a>
                <a href="/detailSp?id=${u.id}" class="btn btn-primary">Detail</a>
                <a href="/addToCart?id=${u.id}" class="btn btn-primary">Thêm giỏ hàng</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
