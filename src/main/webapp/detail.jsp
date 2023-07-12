<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 12/07/2023
  Time: 09:54
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
<form action="/update" method="post">
    <label class="form-label">Id</label>
    <input type="text" class="form-control" value="${userDetail.id}" type="hidden" name="id">
    <label class="form-label">Name</label>
    <input type="text" class="form-control" value="${userDetail.name}" name="name">
    <label class="form-label">Age</label>
    <input type="text" class="form-control" value="${userDetail.age}" name="age">
    <label class="form-label">Address</label>
    <input type="text" class="form-control" value="${userDetail.address}" name="address">
    <button type="submit" class="btn btn-primary">Update</button>
</form>
</body>
</html>
