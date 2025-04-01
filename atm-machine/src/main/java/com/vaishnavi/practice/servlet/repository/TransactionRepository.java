package com.vaishnavi.practice.servlet.repository;

import com.vaishnavi.practice.servlet.model.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    public void saveTransaction(Transaction transaction) {
        String query = "INSERT INTO transactions (user_id, amount, transaction_type, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, transaction.getUserId());
            ps.setDouble(2, transaction.getAmount());
            ps.setString(3, transaction.getTransactionType());
            ps.setString(4, transaction.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Transaction getTransactionById(int transactionId) {
        String query = "SELECT * FROM transactions WHERE transaction_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, transactionId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Transaction(
                        rs.getInt("transaction_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getString("transaction_type"),
                        rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM transactions";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                transactions.add(new Transaction(
                        rs.getInt("transaction_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getString("transaction_type"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}


