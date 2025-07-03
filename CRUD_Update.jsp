<!-- Alisa Steensen Module 7-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Record Here</title>
<link rel="stylesheet" type="text/css" href="Create.css">
</head>
<body>

  <h1>CRUD Update</h1>

  <jsp:useBean id="myDB" class="database.DatabaseBean" />

  <br /> <a href="index.html">Back to Index</a> <br /><br />
    <!--Form Section with dropdown box-->
  <%
  if (request.getMethod().equals("GET")) {
  %>
    <form method="post" action="CRUD_Update.jsp">
      <label>State Name:</label><br />
      <input type="text" name="state_name" /><br /><br />

      <label>Capital:</label><br />
      <input type="text" name="capital" /><br /><br />

      <label>Population (millions):</label><br />
      <input type="text" name="population_millions" /><br /><br />

      <label>State Bird:</label><br />
      <input type="text" name="stateBird" /><br /><br />

      <label>State Flower:</label><br />
      <input type="text" name="stateFlower" /><br /><br />

      <select name="id">
        <%= myDB.idSelection() %>
      </select>

      <input type="submit" value="Update Record" />
    </form>
  <%
  }
  %>

  <%
  if (request.getMethod().equals("POST")) {
      String stateName = request.getParameter("state_name");
      String capital = request.getParameter("capital");
      double populationMillions = Double.parseDouble(request.getParameter("population_millions"));
      String stateBird = request.getParameter("stateBird");
      String stateFlower = request.getParameter("stateFlower");
      int id = Integer.parseInt(request.getParameter("id"));
  
      String updateStatus = myDB.updateRecord_2(stateName, capital, populationMillions, id, stateBird, stateFlower);
      out.println("<b>" + updateStatus + "</b><br /><br />");
  
      out.println("<h3>Updated Record:</h3>");
      out.println(myDB.read(id));
  
      out.println("<br /><h3>All Records:</h3>");
      out.println(myDB.readAll());
  }
  %>
  
</body>
</html>

