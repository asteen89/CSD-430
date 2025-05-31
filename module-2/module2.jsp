<!--Alisa Steensen
Module 2 Assignment
5/30/25

Create a dynamic web page using JSP and HTML with CSS styling for favorite states visited.-->


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <!-- Head -->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Module 2 Assignment</title>
        <link rel="stylesheet" type="text/css" href="module2.css">
    </head>
    <!-- Main Content -->
    <body>
        <h1>A list of states I have enjoyed visiting.</h1>
        <p>This table shows five states I’ve visited along with their official flowers and birds.</p>
        <ul>
            <li><strong>State Name</strong>: The name of the U.S. state</li>
            <li><strong>State Flower</strong>: The official flower of the state</li>
            <li><strong>State Bird</strong>: The official bird of the state</li>
        </ul>
        <%
            // Class to hold state information
            class State {
                String stateName;
                String stateFlower;
                String stateBird;

                // Constructor to initialize state info
                State(String stateName, String stateFlower, String stateBird) {
                    this.stateName = stateName;
                    this.stateFlower = stateFlower;
                    this.stateBird = stateBird;
                }
            }

            // List of states with 3 different categories using ArrayList
            List<State> states = new ArrayList<State>();
            states.add(new State("Colorado", "Blue Columbine", "Lark Bunting"));
            states.add(new State("South Dakota", "Pasque Flower", "Ring-necked Pheasant"));
            states.add(new State("Texas", "Bluebonnet", "Northern Mockingbird"));
            states.add(new State("Missouri", "Hawthorn", "Eastern Bluebird"));
            states.add(new State("Arkansas", "Apple Blossom", "Northern Mockingbird"));
        %>

        <table border="1">
            <tr>
                <th>State Name</th>
                <th>State Flower</th>
                <th>State Bird</th>
            </tr>
            <% // Loop through the list of states and display each state's information in a table row
                for (int i = 0; i < states.size(); ++i) {
                    State state = states.get(i);
            %>
                <tr>
                    <td><%= state.stateName %></td>
                    <td><%= state.stateFlower %></td>
                    <td><%= state.stateBird %></td>
                </tr>
            <% } %>
        </table>
    </body>
</html>

