<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.vaishnavi.practice.servlet.model.SportCar" %>
<html>
<head>
    <title>Sport Car List</title>
</head>
<body>
<h2>Sport Car List</h2>

<a href="carEdit.jsp">Add New Car</a><br><br>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Model</th>
        <th>Brand</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>

    <%
        List<SportCar> cars = (List<SportCar>) request.getAttribute("cars");
        if (cars != null) {
            for (SportCar car : cars) {
    %>
    <tr>
        <td><%= car.getId() %></td>
        <td><%= car.getModel() %></td>
        <td><%= car.getBrand() %></td>
        <td><%= car.getPrice() %></td>
        <td>
            <a href="carEdit.jsp?id=<%=car.getId()%>">Edit</a> |
            <a href="cars?action=delete&id=<%=car.getId()%>">Delete</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
