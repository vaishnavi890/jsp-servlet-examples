package com.vaishnavi.practice.servlet.repository;

import com.vaishnavi.practice.servlet.model.User;
import com.vaishnavi.practice.servlet.connection.DBConnection;
import java.sql.*;

public class UserRepository {

    public User getUserByEmail(String email) {
        User user = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email = ?")) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setBalance(rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateBalance(User user) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE users SET balance = ? WHERE user_id = ?")) {
            ps.setDouble(1, user.getBalance());
            ps.setInt(2, user.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



