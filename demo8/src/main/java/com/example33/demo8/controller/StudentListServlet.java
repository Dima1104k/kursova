package com.example33.demo8.controller;
import java.io.IOException;
import java.util.List;

import com.example33.demo8.dao.UserDAO;
import com.example33.demo8.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/studentList")
public class StudentListServlet extends HttpServlet {
    private UserDAO userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userDao = (UserDAO) getServletContext().getAttribute("userDao");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            List<User> students = userDao.getUsersByType("student");
            request.setAttribute("students", students);

            request.getRequestDispatcher("/WEB-INF/views/studentList.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "An error occurred while retrieving the student list. Please try again later.");
        }
    }
}