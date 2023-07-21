<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 21/07/2023
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>

<body class="container">
<form action="#" method="post">
    <label class="form-label">Id</label>
    <input type="text" class="form-control" value="${sanPham.id}" type="hidden" name="id">
    <label class="form-label">Ma</label>
    <input type="text" class="form-control" value="${sanPham.ma}" name="name">
    <label class="form-label">Ten</label>
    <input type="text" class="form-control" value="${sanPham.ten}" name="age">
    <label class="form-label">Gia Ban</label>
    <input type="text" class="form-control" value="${sanPham.giaBan}" name="address">
    <button type="submit" class="btn btn-primary">Update</button>
</form>
</body>
</html>
