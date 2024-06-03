package com.example33.demo8.controller;

import com.example33.demo8.dao.UserDAO;
import com.example33.demo8.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/authenticate")
public class AuthenticateServlet extends HttpServlet {
    private UserDAO userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userDao = (UserDAO) getServletContext().getAttribute("userDao");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String userType = request.getParameter("type");

            List<User> users = userDao.getAllUsers();
            Optional<User> user = users.stream()
                    .filter(u -> username.equals(u.getUsername()) && password.equals(u.getPassword()) && userType.equals(u.getType()))
                    .findFirst();

            if (user.isPresent()) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user.get());

                if ("dean".equals(user.get().getType())) {
                    response.sendRedirect(request.getContextPath() + "/deanDashboard"); 
                } else if ("student".equals(user.get().getType())) {
                    response.sendRedirect(request.getContextPath() + "/studentDashboard"); 
                } else {
                    response.sendRedirect(request.getContextPath() + "/login.jsp");
                }
            } else {
                request.setAttribute("errorMessage", "Неправильне ім'я користувача або пароль.");
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response); 
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "Internal Server Error: " + e.getMessage());
        }
    }
}
