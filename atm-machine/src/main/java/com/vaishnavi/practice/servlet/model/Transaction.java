package com.vaishnavi.practice.servlet.model;

public class Transaction {
    private int transactionId;
    private int userId;
    private double amount;
    private String transactionType;
    private String status;

    public Transaction() {}

    public Transaction(int transactionId, int userId, double amount, String transactionType, String status) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.status = status;
    }

    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}



