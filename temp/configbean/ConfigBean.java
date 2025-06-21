// Alisa Steensen Module 6 6/27/25

// This code interacts with the MySQL database to manage a table of US states data. It will create, populate and read the table named `alisa_states_data`.

package configbean;

import java.sql.*;

public class ConfigBean implements java.io.Serializable {

    Connection connection;
    Statement statement;

    private static final long serialVersionUID = 111222333444L;

    // ------------------------ Constructor --------------------------

    public ConfigBean() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/CSD430?";
            connection = DriverManager.getConnection(url + "user=student1&password=pass");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Connection Error: " + e);
        }
    }

    // ------------------------ Create Table -------------------------
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

    // ------------------------ Populate Table -----------------------
    public String populateTable() {
    StringBuilder sb = new StringBuilder();

    try {
        statement.executeUpdate("INSERT INTO alisa_states_data(state_name, capital, population_millions, state_bird, state_flower) VALUES ('Iowa', 'Des Moines', 3.2, 'Eastern Goldfinch', 'Wild Rose')");
        statement.executeUpdate("INSERT INTO alisa_states_data(state_name, capital, population_millions, state_bird, state_flower) VALUES ('California', 'Sacramento', 39.2, 'California Quail', 'California Poppy')");
        statement.executeUpdate("INSERT INTO alisa_states_data(state_name, capital, population_millions, state_bird, state_flower) VALUES ('Texas', 'Austin', 29.5, 'Northern Mockingbird', 'Bluebonnet')");
        statement.executeUpdate("INSERT INTO alisa_states_data(state_name, capital, population_millions, state_bird, state_flower) VALUES ('Florida', 'Tallahassee', 21.8, 'Mockingbird', 'Orange Blossom')");
        statement.executeUpdate("INSERT INTO alisa_states_data(state_name, capital, population_millions, state_bird, state_flower) VALUES ('New York', 'Albany', 19.8, 'Eastern Bluebird', 'Rose')");
        statement.executeUpdate("INSERT INTO alisa_states_data(state_name, capital, population_millions, state_bird, state_flower) VALUES ('Nebraska', 'Lincoln', 1.9, 'Western Meadowlark', 'Goldenrod')");
        statement.executeUpdate("INSERT INTO alisa_states_data(state_name, capital, population_millions, state_bird, state_flower) VALUES ('Colorado', 'Denver', 5.8, 'Lark Bunting', 'Rocky Mountain Columbine')");
        statement.executeUpdate("INSERT INTO alisa_states_data(state_name, capital, population_millions, state_bird, state_flower) VALUES ('Hawaii', 'Honolulu', 1.4, 'Nene', 'Hibiscus')");
        statement.executeUpdate("INSERT INTO alisa_states_data(state_name, capital, population_millions, state_bird, state_flower) VALUES ('Alaska', 'Juneau', 0.7, 'Willow Ptarmigan', 'Forget-Me-Not')");
        statement.executeUpdate("INSERT INTO alisa_states_data(state_name, capital, population_millions, state_bird, state_flower) VALUES ('Georgia', 'Atlanta', 10.8, 'Brown Thrasher', 'Cherokee Rose')");

        sb.append("<b>Table populated with 10 sample states.</b><br />");
    } catch (SQLException e) {
        sb.append("<b>Error populating table.</b><br />").append(e.getMessage());
    }

    return sb.toString();
}

    // ------------------------ Read Table ---------------------------
    public String readTable() {
        StringBuilder sb = new StringBuilder();

        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM alisa_states_data");

            sb.append("<table border='1' bgcolor='#87CEFA'>");
            sb.append("<thead><tr>");
            sb.append("<th>ID</th><th>State</th><th>Capital</th><th>Population</th><th>Bird</th><th>Flower</th>");
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
        } catch (SQLException e) {
            sb.append("<b>Error reading table.</b><br />").append(e.getMessage());
        }

        return sb.toString();
    }

    // ------------------------ Close Connection ---------------------
    public void closeConnection() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Close Error: " + e);
        }
    }
}
