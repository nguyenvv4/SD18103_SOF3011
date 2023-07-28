<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 28/07/2023
  Time: 09:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h1>Login Form</h1>
<form action="/login" method="POST">
    <p>Username: <input name="username"/></p>
    <p>Password: <input name="password"/></p>
    <input type="submit" value="Login"/>
</form>
</body>
</html>