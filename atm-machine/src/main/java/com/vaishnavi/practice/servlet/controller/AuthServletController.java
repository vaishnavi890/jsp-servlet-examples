package com.vaishnavi.practice.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.vaishnavi.practice.servlet.model.User;
import com.vaishnavi.practice.servlet.service.UserService;
import java.io.IOException;

@WebServlet("/AuthServlet")
   public class AuthServletController extends HttpServlet{
    private final UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.authenticateUser(email, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("dashboard.html");
        } else {
            response.sendRedirect("login.html?error=Invalid credentials");
        }
    }
}
