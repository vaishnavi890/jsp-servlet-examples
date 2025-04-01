package com.vaishnavi.practice.servlet.controller;

import com.vaishnavi.practice.servlet.model.Transaction;
import com.vaishnavi.practice.servlet.service.TransactionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/transaction")
public class TransactionController extends HttpServlet {
    private final TransactionService service = new TransactionService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        String transactionType = request.getParameter("transaction_type");

        Transaction transaction = new Transaction(0, userId, amount, transactionType, "PENDING");
        service.processTransaction(transaction);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Transaction Processed Successfully!</h3>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int transactionId = Integer.parseInt(request.getParameter("transaction_id"));
        Transaction transaction = service.getTransaction(transactionId);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (transaction != null) {
            out.println("<h3>Transaction Details</h3>");
            out.println("<p>ID: " + transaction.getTransactionId() + "</p>");
            out.println("<p>User ID: " + transaction.getUserId() + "</p>");
            out.println("<p>Amount: $" + transaction.getAmount() + "</p>");
            out.println("<p>Type: " + transaction.getTransactionType() + "</p>");
            out.println("<p>Status: " + transaction.getStatus() + "</p>");
        } else {
            out.println("<h3>Transaction Not Found!</h3>");
        }
    }
}


