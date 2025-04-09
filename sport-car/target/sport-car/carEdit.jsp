<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.vaishnavi.practice.servlet.model.SportCar" %>
<%
    SportCar car = (SportCar) request.getAttribute("car");
    boolean isEdit = car != null;
%>
<html>
<head>
    <title><%= isEdit ? "Edit Car" : "Add New Car" %></title>
</head>
<body>

<h2><%= isEdit ? "Edit Sport Car" : "Add New Sport Car" %></h2>

<form action="cars" method="post">
    <% if (isEdit) { %>
        <input type="hidden" name="id" value="<%=car.getId()%>"/>
        <input type="hidden" name="action" value="update"/>
    <% } %>

    Model: <input type="text" name="model" value="<%= isEdit ? car.getModel() : "" %>" required/><br><br>
    Brand: <input type="text" name="brand" value="<%= isEdit ? car.getBrand() : "" %>" required/><br><br>
    Price: <input type="number" name="price" value="<%= isEdit ? car.getPrice() : "" %>" required step="0.01"/><br><br>

    <input type="submit" value="<%= isEdit ? "Update" : "Add" %> Car"/>
</form>

<br>
<a href="cars">Back to Car List</a>

</body>
</html>
