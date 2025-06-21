<!-- Alisa Steensen Module 6-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>CRUD Read</title>
    <link rel="stylesheet" type="text/css" href="Create.css">
</head>
<body>

<h1>CRUD Read</h1>

<jsp:useBean id="myDB" class="database.DatabaseBean" />

<a href="index.html">Back to Index</a><br><br>

<%
    if (request.getMethod().equals("GET")) {
        out.print(myDB.formGetPK("CRUD_Read.jsp"));
    }
    else if (request.getMethod().equals("POST")) {
        out.print(myDB.formGetPK("CRUD_Read.jsp"));
        int id = Integer.parseInt(request.getParameter("state_id"));
        out.println("<h3>Single Record:</h3>");
        out.print(myDB.read(id));
        out.println("<br><br><h3>All Records:</h3>");
        out.print(myDB.readAll());
    }
%>

</body>
</html>
