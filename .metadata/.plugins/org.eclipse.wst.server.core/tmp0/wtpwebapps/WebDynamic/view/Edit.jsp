<%@page import="model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>

<%
    User user = (User) request.getAttribute("user");
%>
<form action="edit" method="POST">
    id: <input readonly="readonly" value="<%= user.getId() %>" name="id" /><br>
    username: <input name="username" value="<%= user.getUsername() %>"><br>
    password: <input name="password" type="password" value="<%= user.getPassword()%>"><br>
    email: <input name="email" value="<%= user.getEmail() %>"><br>
    gender:
    <label for="male">
        <input type="radio" name="gender" id="male" value=0 <%= !user.isGender() ? "checked" : "" %>> male
    </label>
    <label for="female">
        <input type="radio" name="gender" id="female" value=1 <%= user.isGender() ? "checked" : "" %>> female
    </label>
    <br>
    <a href="UserServlet">cancel</a>
    <input type="submit" value="Edit"><br>
</form>
</body>
</html>
