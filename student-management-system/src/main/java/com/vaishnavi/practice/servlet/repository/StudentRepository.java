package com.vaishnavi.practice.servlet.repository;

import com.vaishnavi.practice.servlet.model.Student;
import com.vaishnavi.practice.servlet.service.ConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }

    public boolean insertStudent(Student student) throws SQLException {
        this.initConnection();

        String query = "INSERT INTO student VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, student.getId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.getGender());
            preparedStatement.setInt(5, student.getAge());

            System.out.println("inserting student object to student table: " + student);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Student> retrieveStudents() throws SQLException {
        this.initConnection();
        List<Student> students = new ArrayList<>();
        try {
            this.initConnection();
            // Your database operations here...
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

            // Iterate over the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                Student student = new Student(id, firstName, lastName, gender, age);
                students.add(student);
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            // Close the connection when done
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return students;
    }
}
