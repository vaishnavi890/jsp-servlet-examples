package com.vaishnavi.practice.servlet.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet {
    private String message;

    public void init() {
        System.out.println("--------------- inside the init() method ---------------");
        message = "Hello team!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("--------------- inside the doGet() method ---------------");
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("--------------- inside the service() method ---------------");
        this.doGet(request, response);
    }

    public void destroy() {
        System.out.println("--------------- inside the destroy() method ---------------");
    }
}
