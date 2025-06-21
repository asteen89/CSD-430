<!-- Alisa Steensen Module 6-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Form to Create</title>
    <link rel="stylesheet" type="text/css" href="Create.css">
</head>
<body>

  <h1>Crud Create</h1>
  
  <jsp:useBean id='myDB' class='database.DbBean' />
  
  <br /> <a href="index.html">index.html</a> <br />
  
  <%
  if(request.getMethod().equals("GET")){
  	
  	String value = myDB.formGetCreateOnly("CRUD_Create.jsp");
  	
  	out.print(value);
  }
  %>
  
  <%
  if(request.getMethod().equals("POST")){
  	
  	myDB.createRecord(request.getParameter("stateName"),
  			request.getParameter("capital"),
  			Double.parseDouble(request.getParameter("population")),
  			request.getParameter("stateBird"),
  			request.getParameter("stateFlower"));
  	
  	out.print(myDB.readAll());
  }
  %>
  
</body>
</html>
