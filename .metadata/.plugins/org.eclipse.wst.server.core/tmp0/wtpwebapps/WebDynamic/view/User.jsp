<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.User" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
<div>
<%
    List<User> listUser =(ArrayList) request.getAttribute("listUser");
%>
<form action="UserServlet" method="POST">
	username: <input name="username"><br>
	password: <input name="password" type="password"><br>
	email:<input name="email"><br>
	gender:
	<label for="male">
		<input type="radio" name="gender" id="male" value=0> male
	</label>
	<label for="famale">
		<input type="radio" name="gender" id="famale" value=1> famale
	</label>
	<br>
	<input type="submit" value="Create"><br>
</form>
</div>
<hr>
    <table border="1" >
        <thead>
            <tr> 
                <th>ID</th>
                <th>Username</th>
                <th>Gender</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
        if (listUser != null) {
            for (User user : listUser) { 
        %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getUsername() %></td>
                <td><%= user.isGender()==true ? "Female":"Male" %></td>
                <td><%= user.getEmail() %></td>
                <td>
                    <a href="delete?id=<%= user.getId() %>"><button>Delete</button></a>
                    <a href="edit?id=<%= user.getId() %>"><button>Edit</button></a>
                </td>
            </tr>
        <% 
            }
        } 
        %>
        </tbody>
    </table>
</body>
</html>