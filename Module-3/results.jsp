<!--Alisa Steensen Module 3-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Job Application</title>
    <link rel="stylesheet" type="text/css" href="module3.css">
</head>
<body>
    <h1>Job Application Information</h1>

    <%
        // Retrieving information from the request
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");
        String phone = request.getParameter("phone");
        String position = request.getParameter("position");
        String linkedin = request.getParameter("linkedin");
        String resume = request.getParameter("resume");
        String reference = request.getParameter("reference");
    %>

    <!--Table Data-->
    <table border="1">
        <tr><td><strong>Full Name:</strong></td><td><%= fullname %></td></tr>
        <tr><td><strong>Email:</strong></td><td><%= email %></td></tr>
        <tr><td><strong>Address:</strong></td><td><%= address %></td></tr>
        <tr><td><strong>City:</strong></td><td><%= city %></td></tr>
        <tr><td><strong>State:</strong></td><td><%= state %></td></tr>
        <tr><td><strong>Zipcode:</strong></td><td><%= zipcode %></td></tr>
        <tr><td><strong>Phone Number:</strong></td><td><%= phone %></td></tr>
        <tr><td><strong>Job Position:</strong></td><td><%= position %></td></tr>
        <tr><td><strong>LinkedIn Profile:</strong></td><td><%= linkedin %></td></tr>
        <tr><td><strong>Resume:</strong></td><td><pre><%= resume %></pre></td></tr>
        <tr><td><strong>Reference:</strong></td><td><%= reference %></td></tr>
    </table>
</body>
</html>
