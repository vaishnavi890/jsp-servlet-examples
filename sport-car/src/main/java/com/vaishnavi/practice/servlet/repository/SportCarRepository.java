package com.vaishnavi.practice.servlet.repository;

import com.vaishnavi.practice.servlet.model.SportCar;
import com.vaishnavi.practice.servlet.connection.DBConnection;

import java.sql.*;
import java.util.*;

public class SportCarRepository {
    public void addCar(SportCar car) throws SQLException {
        String sql = "INSERT INTO sport_cars (brand, model, year, price) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, car.getBrand());
            stmt.setString(2, car.getModel());
            stmt.setInt(3, car.getYear());
            stmt.setDouble(4, car.getPrice());
            stmt.executeUpdate();
        }
    }

    public List<SportCar> getAllCars() throws SQLException {
        List<SportCar> cars = new ArrayList<>();
        String sql = "SELECT * FROM sport_cars";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                SportCar car = new SportCar(
                        rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getDouble("price")
                );
                cars.add(car);
            }
        }
        return cars;
    }

    public SportCar getCarById(int id) throws SQLException {
        String sql = "SELECT * FROM sport_cars WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new SportCar(
                        rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getDouble("price")
                );
            }
        }
        return null;
    }

    public void updateCar(SportCar car) throws SQLException {
        String sql = "UPDATE sport_cars SET brand=?, model=?, year=?, price=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, car.getBrand());
            stmt.setString(2, car.getModel());
            stmt.setInt(3, car.getYear());
            stmt.setDouble(4, car.getPrice());
            stmt.setInt(5, car.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteCar(int id) throws SQLException {
        String sql = "DELETE FROM sport_cars WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
