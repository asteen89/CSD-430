<!--Alisa Steensen Module 4-->

<%@ page import="model.ApplicationBean" %>
<jsp:useBean id="applicant" class="model.ApplicationBean" scope="request" />
<jsp:setProperty name="applicant" property="*" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Job Application</title>
    <link rel="stylesheet" type="text/css" href="module4.css">
</head>
<body>
    <h1>Job Application Information</h1>

    <!--Table Information-->
    <table border="1">
        <tr><td><strong>Full Name:</strong></td><td><jsp:getProperty name="applicant" property="fullname" /></td></tr>
        <tr><td><strong>Email:</strong></td><td><jsp:getProperty name="applicant" property="email" /></td></tr>
        <tr><td><strong>Address:</strong></td><td><jsp:getProperty name="applicant" property="address" /></td></tr>
        <tr><td><strong>City:</strong></td><td><jsp:getProperty name="applicant" property="city" /></td></tr>
        <tr><td><strong>State:</strong></td><td><jsp:getProperty name="applicant" property="state" /></td></tr>
        <tr><td><strong>Zipcode:</strong></td><td><jsp:getProperty name="applicant" property="zipcode" /></td></tr>
        <tr><td><strong>Phone Number:</strong></td><td><jsp:getProperty name="applicant" property="phone" /></td></tr>
        <tr><td><strong>Job Position:</strong></td><td><jsp:getProperty name="applicant" property="position" /></td></tr>
        <tr><td><strong>LinkedIn Profile:</strong></td><td><jsp:getProperty name="applicant" property="linkedin" /></td></tr>
        <tr><td><strong>Resume:</strong></td><td><pre><jsp:getProperty name="applicant" property="resume" /></pre></td></tr>
        <tr><td><strong>Reference:</strong></td><td><jsp:getProperty name="applicant" property="reference" /></td></tr>
    </table>
</body>
</html>