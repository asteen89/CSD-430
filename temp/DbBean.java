// Alisa Steensen Module 6 6/14/25

package database;

import java.sql.*;

public class DbBean implements java.io.Serializable {

    Connection connection;
    Statement statement;

    private static final long serialVersionUID = 111222333444L;
    
    // ---------------------------------------------------------------
    // ---------------------------------------------------------------
    // ------------------------ Constructor --------------------------
    // ---------------------------------------------------------------
    // ---------------------------------------------------------------

    public DbBean() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/CSD430?";
            connection = DriverManager.getConnection(url + "user=student1&password=pass");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Connection Error: " + e);
        }
    }


    // ***************************************************************
    // ***************************************************************
    // ------------------------ Read ---------------------------------
    // ***************************************************************
    // ***************************************************************
    public String read(int id) {
        StringBuilder sb = new StringBuilder();
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM alisa_states_data WHERE id = " + id);
            sb.append("<table border='1' style='background-color: pink;'>");
            sb.append("<thead><tr>");
            sb.append("<th>Key</th><th>State</th><th>Capital</th><th>Population (millions)</th><th>State Bird</th><th>State Flower</th>");
            sb.append("</tr></thead><tbody>");

            while (rs.next()) {
                sb.append("<tr>");
                sb.append("<td>").append(rs.getInt("id")).append("</td>");
                sb.append("<td>").append(rs.getString("state_name")).append("</td>");
                sb.append("<td>").append(rs.getString("capital")).append("</td>");
                sb.append("<td>").append(rs.getDouble("population_millions")).append("</td>");
                sb.append("<td>").append(rs.getString("state_bird")).append("</td>");
                sb.append("<td>").append(rs.getString("state_flower")).append("</td>");
                sb.append("</tr>");
            }

            sb.append("</tbody></table>");
        } catch (Exception e) {
            sb.append("Read error: ").append(e.getMessage());
        }
        return sb.toString();
    }

    // ***************************************************************
    // ***************************************************************
    // ------------------------ Read All -----------------------------
    // ***************************************************************
    // ***************************************************************
    public String readAll() {
        StringBuilder sb = new StringBuilder();
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM alisa_states_data");

            sb.append("<table border='1' style='background-color: purple; color: white;'>");

        // Table header
            sb.append("<thead>");
            sb.append("<tr>");
            sb.append("<th>Key</th>");
            sb.append("<th>State</th>");
            sb.append("<th>Capital</th>");
            sb.append("<th>Population (millions)</th>");
            sb.append("<th>State Bird</th>");
            sb.append("<th>State Flower</th>");
            sb.append("</tr>");
            sb.append("</thead>");

            sb.append("<tbody>");
            while (rs.next()) {
                sb.append("<tr>");
                sb.append("<td>").append(rs.getInt("id")).append("</td>");
                sb.append("<td>").append(rs.getString("state_name")).append("</td>");
                sb.append("<td>").append(rs.getString("capital")).append("</td>");
                sb.append("<td>").append(rs.getDouble("population_millions")).append("</td>");
                sb.append("<td>").append(rs.getString("state_bird")).append("</td>");
                sb.append("<td>").append(rs.getString("state_flower")).append("</td>");
                sb.append("</tr>");
            }
            sb.append("</tbody></table>");
        } catch (SQLException e) {
            sb.append("ReadAll Error: ").append(e.getMessage());
        }
        return sb.toString();
    }


    // ***************************************************************
    // ***************************************************************
    // ------------------------ FormGetPK ----------------------------
    // ***************************************************************
    // ***************************************************************
    public String formGetPK(String requestURL) {
        StringBuilder sb = new StringBuilder();
        try {
            ResultSet rs = statement.executeQuery("SELECT id FROM alisa_states_data ORDER BY id ASC");

            sb.append("<form method='post' action='" + requestURL + "'>\n");
            sb.append("<label for='state_id'>Select State ID:</label><br>\n");
            sb.append("<select name='state_id' id='state_id'>\n");

            while (rs.next()) {
                int id = rs.getInt("id");
                sb.append("<option value='").append(id).append("'>").append(id).append("</option>\n");
            }

            sb.append("</select><br><br>\n");
            sb.append("<input type='submit' value='Submit'>\n");
            sb.append("</form>\n");

        } catch (Exception e) {
            sb.append("formGetPK Error: ").append(e.getMessage());
        }
        return sb.toString();
    }

    // ***************************************************************
    // ***************************************************************
    // ------------------------ Close Connection ---------------------
    // ***************************************************************
    // ***************************************************************
    public void closeConnection() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Close Error: " + e);
        }
    }
}

