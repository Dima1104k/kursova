
package com.example33.demo8.controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example33.demo8.dao.GroupDAO;
import com.example33.demo8.dao.UserDAO;
import com.example33.demo8.model.Group;
import com.example33.demo8.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/createStudent")
public class CreateStudentServlet extends HttpServlet {
    private UserDAO userDao;
    private GroupDAO groupDao;  // Припускаємо, що ви використовуєте GroupDAO для роботи з групами

    @Override
    public void init() throws ServletException {
        super.init();
        this.userDao = (UserDAO) getServletContext().getAttribute("userDao");
        this.groupDao = (GroupDAO) getServletContext().getAttribute("groupDao");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("groups", groupDao.getAllGroups());
        //Перенаправлення на jsp сторінку з формою для створення студента
        request.getRequestDispatcher("/WEB-INF/views/createStudent.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String groupCode = request.getParameter("groupCode");
        String faculty = request.getParameter("faculty");
        String educationForm = request.getParameter("educationForm");
        int course = Integer.parseInt(request.getParameter("course"));
        String speciality = request.getParameter("speciality");


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate").trim(), formatter);


        try {
            Group group = groupDao.getGroupByCode(groupCode);
            int id = userDao.getNextId(); // Отримання унікального ID для нового студента
            User newUser = new User(id, firstName, lastName, group, null, null, "student", birthDate, faculty, educationForm, course, speciality);
            userDao.addUser(newUser);

            response.sendRedirect("deanDashboard");  // Перенаправлення назад на дашборд деканату
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "Internal Server Error: " + e.getMessage());
        }
    }
}