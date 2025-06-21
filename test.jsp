<%@ page import="configbean.ConfigBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test ConfigBean</title>
</head>
<body>
    <h2>Testing ConfigBean: Create, Populate, Read Table</h2>
    <%
        ConfigBean bean = new ConfigBean();
        
        out.println("<h3>Create Table:</h3>");
        out.println(bean.createTable());

        out.println("<h3>Populate Table:</h3>");
        out.println(bean.populateTable());

        out.println("<h3>Read Table:</h3>");
        out.println(bean.readTable());

        bean.closeConnection();
    %>
</body>
</html>
