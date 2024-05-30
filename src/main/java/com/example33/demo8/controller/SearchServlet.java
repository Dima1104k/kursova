package com.example33.demo8.controller;
import com.example33.demo8.dao.UserDAO;
import com.example33.demo8.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private UserDAO userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userDao = (UserDAO) getServletContext().getAttribute("userDao");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/searchStudent.jsp").forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            String firstName = request.getParameter("firstName").trim();  //Використання trim() для видалення пробілів
            String lastName = request.getParameter("lastName").trim();    //Використання trim() для видалення пробілів

            if (firstName.isEmpty() && lastName.isEmpty()) {

                request.setAttribute("message", "Будь ласка, введіть ім'я або прізвище.");

            } else {
                User user = userDao.findUserByName(firstName, lastName);
                if (user == null) {
                    request.setAttribute("message", "Студент не знайдений.");

                } else {
                    request.setAttribute("user", user);
                    request.setAttribute("searchCompleted", true); //атрибут searchCompleted допомагає розрізняти випадки,коли форма просто завантажена випадком і коли форма була надіслана з даними

                }

            }

            request.getRequestDispatcher("/WEB-INF/views/searchStudent.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "Internal Server Error");
        }
    }
}
