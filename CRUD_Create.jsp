<!-- Alisa Steensen Module 7-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Crud Create</title>
    <link rel="stylesheet" type="text/css" href="Create.css">
</head>
<body>

  <h1>Crud Create</h1>
  
  <jsp:useBean id='myDB' class='database.DatabaseBean' />
  
  <br /> <a href="index.html">index.html</a> <br />
  
  <%
  if(request.getMethod().equals("GET")){
  %> <!-- Form section -->
      <form action="CRUD_Create.jsp" method="post">
          State Name: <input type="text" name="state_name" required><br>
          Capital: <input type="text" name="capital" required><br>
          Population (millions): <input type="text" name="population_millions" required><br>
          State Bird: <input type="text" name="state_bird" required><br>
          State Flower: <input type="text" name="state_flower" required><br>
          <input type="submit" value="Submit">
      </form>
  <%
  }
  
  if(request.getMethod().equals("POST")){
      myDB.createRecord(
          request.getParameter("state_name"),
          request.getParameter("capital"),
          Double.parseDouble(request.getParameter("population_millions")),
          request.getParameter("state_bird"),
          request.getParameter("state_flower")
      );
      out.println("<p>This table shows all U.S. states currently stored in the database.</p>");
      out.print(myDB.readAll());
  }
  %>
  
</body>
</html>

