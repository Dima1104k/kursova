package com.example33.demo8.controller;

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

    private UserDAO userDao;
    private GroupDAO groupDao; // Додаємо GroupDAO

    @Override
    public void init() throws ServletException {
        super.init();
        this.userDao = (UserDAO) getServletContext().getAttribute("userDao");
        this.groupDao = (GroupDAO) getServletContext().getAttribute("groupDao"); // Ініціалізація GroupDAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            User student = userDao.getUserById(id);
            if (student == null) {
                response.sendError(404, "Student not found.");
                return;
            }

            List<Group> groups = groupDao.getAllGroups();
            request.setAttribute("groups", groups); // Передаємо список груп у запит для доступу в JSP
            request.setAttribute("student", student);  // Передаємо студента в запит для доступу в JSP
            request.getRequestDispatcher("/WEB-INF/views/editStudent.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(400, "Invalid student ID.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id").trim()); // Додавання trim() для id
            String firstName = request.getParameter("firstName").trim(); // Використання trim() для firstName
            String lastName = request.getParameter("lastName").trim(); // Використання trim() для lastName
            String groupCode = request.getParameter("group").trim(); // Використання trim() для groupCode
            String faculty = request.getParameter("faculty");
            String educationForm = request.getParameter("educationForm");
            int course = Integer.parseInt(request.getParameter("course"));
            String speciality = request.getParameter("speciality");

            // Використання LocalDate для дати народження
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"), formatter);

            Group group = groupDao.getGroupByCode(groupCode);
            User updatedUser = new User(id, firstName, lastName, group, null, null, "student", birthDate,faculty, educationForm, course, speciality);
            userDao.updateUser(updatedUser);
            response.sendRedirect("deanDashboard");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "An internal server error occurred while updating the user.");
        }
    }
}
