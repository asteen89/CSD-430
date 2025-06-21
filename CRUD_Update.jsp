<!-- Alisa Steensen Module 6-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Record Here</title>
</head>
<body>

  <h1>CRUD Update</h1>

  <jsp:useBean id="myDB" class="database.DbBean" />

  <br /> <a href="index.html">Back to Index</a> <br /><br />

  <%
  if (request.getMethod().equals("GET")) {
      String value = myDB.formGetCreateOrUpdate("CRUD_Update.jsp");
      out.print(value);
  }
  %>

  <%
  if (request.getMethod().equals("POST")) {
      String stateName = request.getParameter("stateName");
      String capital = request.getParameter("capital");
      String stateBird = request.getParameter("stateBird");
      String stateFlower = request.getParameter("stateFlower");
      int id = Integer.parseInt(request.getParameter("id"));

      out.print(myDB.updateRecord(stateName, capital, id, stateBird, stateFlower));

      out.println("<br /><br />");
      out.print(myDB.read(id));
      out.println("<br /><br />");
      out.print(myDB.readAll());
  }
  %>

</body>
</html>
