package com.vaishnavi.practice.servlet.impl;

import com.vaishnavi.practice.servlet.service.SportCarService;
import com.vaishnavi.practice.servlet.model.SportCar;
import com.vaishnavi.practice.servlet.repository.SportCarRepository;
import java.util.List;


public class SportCarServiceImpl extends SportCarService {
    private SportCarRepository repo = new SportCarRepository();

    public void addCar(SportCar car) throws Exception {
        if (car.getPrice() > 0) {
            repo.addCar(car);
        } else {
            throw new IllegalArgumentException("Price must be positive.");
        }
    }

    public List<SportCar> getAllCars() throws Exception {
        return repo.getAllCars();
    }

    public SportCar getCarById(int id) throws Exception {
        return repo.getCarById(id);
    }

    public void updateCar(SportCar car) throws Exception {
        repo.updateCar(car);
    }

    public void deleteCar(int id) throws Exception {
        repo.deleteCar(id);
    }
}
