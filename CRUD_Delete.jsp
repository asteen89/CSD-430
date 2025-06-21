<!-- Alisa Steensen Module 6-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD Delete</title>
</head>
<body>

  <h1>CRUD Delete</h1>

  <jsp:useBean id="myDB" class="database.DbBean" />

  <br /> <a href="index.html">Back to Index</a> <br /><br />

  <%
  if (request.getMethod().equals("GET")) {
      String form = myDB.formGetPK("CRUD_Delete.jsp");
      out.print(form);
  }
  %>

  <%
  if (request.getMethod().equals("POST")) {
      int id = Integer.parseInt(request.getParameter("state_id"));
      out.print(myDB.delete(id));
      out.println("<br /><br />");
      out.print(myDB.readAll());
  }
  %>

</body>
</html>
