package com.vaishnavi.practice.servlet.controller;

import com.vaishnavi.practice.servlet.model.SportCar;
import com.vaishnavi.practice.servlet.service.SportCarService;
import com.vaishnavi.practice.servlet.service.impl.SportCarServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class SportCarController extends HTTPServlet{
    private SportCarService service = new SportCarService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            if ("list".equals(action)) {
                List<SportCar> cars = service.getAllCars();
                req.setAttribute("carList", cars);
                req.getRequestDispatcher("carList.jsp").forward(req, resp);
            } else if ("edit".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                SportCar car = service.getCarById(id);
                req.setAttribute("car", car);
                req.getRequestDispatcher("carEdit.jsp").forward(req, resp);
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                service.deleteCar(id);
                resp.sendRedirect("SportCarServlet?action=list");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = req.getParameter("carId") == null || req.getParameter("carId").isEmpty() ? 0 : Integer.parseInt(req.getParameter("carId"));
            String brand = req.getParameter("brand");
            String model = req.getParameter("model");
            int year = Integer.parseInt(req.getParameter("year"));
            double price = Double.parseDouble(req.getParameter("price"));

            SportCar car = new SportCar(id, brand, model, year, price);

            if (id == 0) {
                service.addCar(car);
            } else {
                service.updateCar(car);
            }
            resp.sendRedirect("SportCarServlet?action=list");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
