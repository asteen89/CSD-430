<!-- Alisa Steensen Module 3 -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Job Application Form</title>
    <link rel="stylesheet" type="text/css" href="module3.css">
</head>
<!--Body-->
<body>
    <h1>Job Application</h1>
    <p>Please fill out the information below to submit your application.</p>

    <!--Form for Job Application-->
    <form name="demoForm" action="results.jsp" method="post">
        <table>
            <tbody>
                <tr>
                    <td>Full Name:</td>
                    <td><input type="text" name="fullname" maxlength="20" required></td>
                </tr>
                <tr>
                    <td>Email Address:</td>
                    <td><input type="email" name="email" maxlength="40" required></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="address" maxlength="50" required></td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td><input type="text" name="city" maxlength="50" required></td>
                </tr>
                <tr>
                    <td>State:</td>
                    <td>
                        <select name="state" required>
                            <option value="Iowa">Iowa</option>
                            <option value="Nebraska">Nebraska</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Zipcode:</td>
                    <td><input type="text" name="zipcode" maxlength="5" required></td>
                </tr>
                <tr>
                    <td>Phone Number:</td>
                    <td><input type="text" name="phone" maxlength="12" required></td>
                </tr>
                <tr>
                    <td>Job Position:</td>
                    <td>
                        <input type="radio" name="position" value="Developer" required> Developer<br>
                        <input type="radio" name="position" value="QA"> QA<br>
                        <input type="radio" name="position" value="Receptionist"> Receptionist
                    </td>
                </tr>
                <tr>
                    <td>LinkedIn Profile:</td>
                    <td><input type="url" name="linkedin"></td>
                </tr>
                <tr>
                    <td>Resume Upload:</td>
                    <td><input name="resume" required></td>
                </tr>
                <tr>
                    <td>Reference:</td>
                    <td><input name="reference" required></td>
                </tr>
            </tbody>
        </table>
        <!--Buttons-->
        <input type="reset" value="Clear" id="clear">
        <input type="submit" value="Submit" id="submit">
    </form>
</body>
</html>




