package com.example33.demo8.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Отримати сесію, якщо існує, інакше не створювати нову
        if (session != null) {
            session.invalidate(); // Знищити сесію
        }
        response.sendRedirect("index.jsp"); // Перенаправити на сторінку входу
    }
}
