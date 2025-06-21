package database;

import java.sql.*;

public class DatabaseBean implements java.io.Serializable {

    Connection connection;
    Statement statement;

    private static final long serialVersionUID = 111222333444L;

    // ---------------------------------------------------------------
    // ---------------------------------------------------------------
    // ------------------------ Constructor --------------------------
    // ---------------------------------------------------------------
    // ---------------------------------------------------------------
    public DatabaseBean() {
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
    // ------------------------ Create Table -------------------------
    // ***************************************************************
    // ***************************************************************
    public String createTable() {
        StringBuilder sb = new StringBuilder();
        try {
            statement.executeUpdate("DROP TABLE alisa_states_data");
            sb.append("<b>Table alisa_states_data dropped.</b><br />");
        } catch (SQLException e) {
            sb.append("<b>Table did not exist or could not be dropped.</b><br />");
        }

        try {
            statement.executeUpdate(
                "CREATE TABLE alisa_states_data (" +
                "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "state_name VARCHAR(50), " +
                "capital VARCHAR(50), " +
                "population_millions DOUBLE, " +
                "state_bird VARCHAR(50), " +
                "state_flower VARCHAR(50))"
            );
            sb.append("<b>Table alisa_states_data created successfully.</b><br />");
        } catch (SQLException e) {
            sb.append("<b>Table creation failed.</b><br />").append(e.getMessage());
        }

        return sb.toString();
    }

    // ***************************************************************
    // ***************************************************************
    // ------------------------ Populate Table -----------------------
    // ***************************************************************
    // ***************************************************************
    public String populateTable() {
        StringBuilder sb = new StringBuilder();
        try {
            statement.executeUpdate("INSERT INTO alisa_states_data(state_name, capital, population_millions, state_bird, state_flower) VALUES " +
                "('Iowa', 'Des Moines', 3.2, 'Eastern Goldfinch', 'Wild Rose')," +
                "('California', 'Sacramento', 39.2, 'California Quail', 'California Poppy')," +
                "('Texas', 'Austin', 29.5, 'Northern Mockingbird', 'Bluebonnet')," +
                "('Florida', 'Tallahassee', 21.8, 'Mockingbird', 'Orange Blossom')," +
                "('New York', 'Albany', 19.8, 'Eastern Bluebird', 'Rose')," +
                "('Nebraska', 'Lincoln', 1.9, 'Western Meadowlark', 'Goldenrod')," +
                "('Colorado', 'Denver', 5.8, 'Lark Bunting', 'Rocky Mountain Columbine')," +
                "('Hawaii', 'Honolulu', 1.4, 'Nene', 'Hibiscus')," +
                "('Alaska', 'Juneau', 0.7, 'Willow Ptarmigan', 'Forget-Me-Not')," +
                "('Georgia', 'Atlanta', 10.8, 'Brown Thrasher', 'Cherokee Rose')");
            sb.append("<b>Table populated with 10 sample states.</b><br />");
        } catch (SQLException e) {
            sb.append("<b>Error populating table.</b><br />").append(e.getMessage());
        }
        return sb.toString();
    }

    // ***************************************************************
    // ***************************************************************
    // ------------------------ Read All -----------------------------
    // ***************************************************************
    // ***************************************************************
    public String readAll() {
        return readTable();
    }

    public String readTable() {
        StringBuilder sb = new StringBuilder();
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM alisa_states_data");

            sb.append("<table border='1'");
            sb.append("<thead><tr><th>ID</th><th>State</th><th>Capital</th><th>Population</th><th>Bird</th><th>Flower</th></tr></thead><tbody>");

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
            sb.append("<b>Error reading table.</b><br />").append(e.getMessage());
        }
        return sb.toString();
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

            sb.append("<table border='1'");
            sb.append("<thead><tr><th>ID</th><th>State</th><th>Capital</th><th>Population</th><th>Bird</th><th>Flower</th></tr></thead><tbody>");

            if (rs.next()) {
                sb.append("<tr>");
                sb.append("<td>").append(rs.getInt("id")).append("</td>");
                sb.append("<td>").append(rs.getString("state_name")).append("</td>");
                sb.append("<td>").append(rs.getString("capital")).append("</td>");
                sb.append("<td>").append(rs.getDouble("population_millions")).append("</td>");
                sb.append("<td>").append(rs.getString("state_bird")).append("</td>");
                sb.append("<td>").append(rs.getString("state_flower")).append("</td>");
                sb.append("</tr>");
            } else {
                sb.append("<tr><td colspan='6'>No record found.</td></tr>");
            }

            sb.append("</tbody></table>");
        } catch (SQLException e) {
            sb.append("<p>Error retrieving record: ").append(e.getMessage()).append("</p>");
        }
        return sb.toString();
    }

    // ***************************************************************
    // ***************************************************************
    // ------------------------ FormGetPK ----------------------------
    // ***************************************************************
    // ***************************************************************
    public String formGetPK(String jspName) {
        StringBuilder sb = new StringBuilder();
        try {
            ResultSet rs = statement.executeQuery("SELECT id FROM alisa_states_data");

            sb.append("<form action='").append(jspName).append("' method='post'>");
            sb.append("<label for='state_id'>Select State ID:</label>");
            sb.append("<select name='state_id'>");

            while (rs.next()) {
                int id = rs.getInt("id");
                sb.append("<option value='").append(id).append("'>").append(id).append("</option>");
            }

            sb.append("</select>");
            sb.append("<input type='submit' value='Submit' />");
            sb.append("</form>");
        } catch (SQLException e) {
            sb.append("<p>Error loading state IDs: ").append(e.getMessage()).append("</p>");
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
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            System.out.println("Close Error: " + e);
        }
    }
}
