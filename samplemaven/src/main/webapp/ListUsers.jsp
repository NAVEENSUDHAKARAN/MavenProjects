<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.chainsys.samplemaven.model.UserDetails"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
<style>
    body {
        font-family: "Poppins", sans-serif;
        background-color: #eee;
        margin: 0;
        padding: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    tr:hover {
        background-color: #f1f1f1;
    }
    a, button {
        text-decoration: none;
        color: #007bff;
        cursor: pointer;
        padding: 8px 16px; 
        border: 1px solid #007bff;
        background-color: #3c455c;
        color: white;
        border-radius: 3px;
        transition: background-color 0.3s, color 0.3s;
        display: inline-block; 
        margin-right: 10px; 
    }
    a:hover, button:hover {
        background-color: black;
        border-color: #0056b3;
    }
    form {
        display: inline-block;
        margin: 0;
    }
    
    .search-container {
        margin-bottom: 20px;
    }
    
    .search {
        position: relative;
        box-shadow: 0 0 40px rgba(51, 51, 51, .1);
        width: 100%;
        max-width: 600px;
        margin: 0 auto;
    }
    
    .search input {
        height: 40px;
        width: calc(100% - 120px);
        text-indent: 25px;
        border: 2px solid #d6d4d4;
        border-radius: 3px;
        font-size: 16px;
    }
    
    .search input:focus {
        outline: none;
        border-color: blue;
    }
    
    .search .fa-search {
        position: absolute;
        top: 20px;
        left: 16px;
        color: #ccc;
    }
    
    .search button {
        position: absolute;
        top: 0;
        right: 0;
        height: 45px;
        width: 130px;
        left: 80%;
        background: #3c455c;
        color: white;
        border: none;
        border-radius: 3px;
        cursor: pointer;
        font-size: 16px;
    }
    
    .search button:hover {
        background-color: black;
    }
</style>
</head>
<body>
<a href="Register.jsp" >Home</a>
<div class="search-container">
    <div class="search">
        <i class="fa fa-search"></i>
        <input type="text" class="form-control" placeholder="Have a question? Ask Now">
        <button type="submit" class="btn btn-primary">Search</button>
    </div>
</div>

<table>
    <thead>
        <tr>
            <th>UserName</th>
            <th>Mail</th>
            <th>Password</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<UserDetails> readUser = (List<UserDetails>) request.getAttribute("userDetails");
            for(UserDetails user : readUser){
        %>
        <tr>
            <td><%= user.getUserName() %></td>
            <td><%= user.getMail() %></td>
            <td><%= user.getPassword() %></td>
            <td>
                <a href="UpdatePage.jsp?mail=<%= user.getMail() %>" >Update</a>
                <form action="DeleteUser" method="post">
                    <input type="hidden" name="mailid" value="<%= user.getMail() %>" >
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
        <% } %>
    </tbody>
</table>
</body>
</html>
