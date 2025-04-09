package com.vaishnavi.practice.servlet.service;

import com.vaishnavi.practice.servlet.model.SportCar;
import com.vaishnavi.practice.servlet.repository.SportCarRepository;

import java.sql.SQLException;
import java.util.List;


public class SportCarService {
    private SportCarRepository repo = new SportCarRepository();

    public void addSportCar(SportCar car) throws SQLException {
        // Business rules can be added here (e.g., check duplicate model/year)
        repo.addCar(car);
    }

    public List<SportCar> getAllCars() throws SQLException {
        return repo.getAllCars();
    }

    public SportCar getCarById(int id) throws SQLException {
        return repo.getCarById(id);
    }

    public void updateSportCar(SportCar car) throws SQLException {
        repo.updateCar(car);
    }

    public void deleteCar(int id) throws SQLException {
        repo.deleteCar(id);
    }
}
