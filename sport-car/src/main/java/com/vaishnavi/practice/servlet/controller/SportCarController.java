package com.vaishnavi.practice.servlet.controller;

import com.vaishnavi.practice.servlet.model.SportCar;
import com.vaishnavi.practice.servlet.service.SportCarService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class SportCarController extends HttpServlet{
    private SportCarService service;

    @Override
    public void init() throws ServletException {
        service = new SportCarService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<SportCar> cars = service.getAllCars();
            request.setAttribute("cars", cars);
            request.getRequestDispatcher("carList.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        double price = Double.parseDouble(request.getParameter("price"));

        SportCar car = new SportCar();
        car.setModel(model);
        car.setBrand(brand);
        car.setPrice(price);

        try {
            service.addSportCar(car);
            response.sendRedirect("cars");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
