package com.vaishnavi.practice.servlet.controller;

import com.vaishnavi.practice.servlet.model.Student;
import com.vaishnavi.practice.servlet.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServlet extends HttpServlet{
    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a list of students for demonstration purposes
        List<Student> students = new ArrayList<>();
        try {
            students = studentService.retrieveStudents();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Set the list of students as a request attribute
        request.setAttribute("studentList", students);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/DisplayStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a list of students for demonstration purposes
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John", "Doe", "Male", 20));
        students.add(new Student(2, "Jane", "Smith", "Female", 22));
        students.add(new Student(3, "Mike", "Johnson", "Male", 21));

        // Set the list of students as a request attribute
        request.setAttribute("studentList", students);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/DisplayStudent.jsp").forward(request, response);
    }
}
