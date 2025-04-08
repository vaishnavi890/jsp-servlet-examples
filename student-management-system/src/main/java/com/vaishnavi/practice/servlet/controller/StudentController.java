package com.vaishnavi.practice.servlet.controller;

import jakarta.servlet.http.HttpServlet;
import com.vaishnavi.practice.servlet.model.Student;
import com.vaishnavi.practice.servlet.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentController extends HttpServlet {
    private String message;

    private StudentService studentService = new StudentService();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("--------------- inside the doGet() method ---------------");
        List<Student> studentList = new ArrayList<>();
        try {
            studentList = studentService.retrieveStudents();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Student Details</h1>");
        out.println("<table border=1>");
        out.println("<tr>");
        out.println("<th>id</th>");
        out.println("<th>first name</th>");
        out.println("<th>last name</th>");
        out.println("<th>age</th>");
        out.println("<th>gender</th>");
        out.println("</tr>");
        studentList.parallelStream().forEach(student -> {
            out.println("<tr>");
            out.println("<td>" + student.getId() +"</td>");
            out.println("<td>" + student.getFirstName() +"</td>");
            out.println("<td>" + student.getLastName() +"</td>");
            out.println("<td>" + student.getAge() +"</td>");
            out.println("<td>" + student.getGender() +"</td>");
            out.println("</tr>");
        });
        out.println("</table>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("--------------- inside the doGet() method ---------------");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String male = request.getParameter("male");
        String age = request.getParameter("age");
        String id = request.getParameter("id");

        Student student = new Student();
        student.setId(Integer.parseInt(id));
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setGender((null == male) ? "Female" : "Male");
        student.setAge(Integer.parseInt(age));

        try {
            boolean isInserted = studentService.insertStudent(student);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (isInserted) {
                out.println("<h1> student object inserted to db</h1>");
            } else {
                out.println("<h1> student object in NOT inserted to db</h1>");
            }
            out.println("</body></html>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("--------------- inside the service() method ---------------");
        if (request.getMethod().equals("POST")) {
            this.doPost(request, response);
        } else {
            this.doGet(request, response);
        }
    }

    public void destroy() {
        System.out.println("--------------- inside the destroy() method ---------------");
    }
}
