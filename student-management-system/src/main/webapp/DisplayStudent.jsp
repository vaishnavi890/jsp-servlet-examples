<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h2>List of Students</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>Age</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${studentList}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.gender}</td>
                    <td>${student.age}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="http://localhost:8080/studentManagementSystem">Go to Home</a>
</body>
</html>