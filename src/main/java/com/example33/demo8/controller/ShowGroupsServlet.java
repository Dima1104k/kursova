package com.example33.demo8.controller;
import com.example33.demo8.dao.GroupDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showGroups")
public class ShowGroupsServlet extends HttpServlet {
    private GroupDAO groupDao;
    @Override
    public void init() throws ServletException {
        super.init();
        this.groupDao = (GroupDAO) getServletContext().getAttribute("groupDao");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Отримання списку груп з DAO
        try {
            request.setAttribute("groups", groupDao.getAllGroups());
            request.getRequestDispatcher("/WEB-INF/views/showGroups.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "An error occurred while retrieving the group list. Please try again later.");

        }
    }
}
