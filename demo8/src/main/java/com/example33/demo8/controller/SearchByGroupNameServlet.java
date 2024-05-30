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
import java.util.List;
@WebServlet("/searchByGroupName")
public class SearchByGroupNameServlet extends HttpServlet {
    private UserDAO userDao;
    private GroupDAO groupDao;
    @Override
    public void init() throws ServletException {
        super.init();
        this.userDao = (UserDAO) getServletContext().getAttribute("userDao");
        this.groupDao = (GroupDAO) getServletContext().getAttribute("groupDao");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Перенаправляємо на форму пошуку
        List<Group> groups = groupDao.getAllGroups();
        request.setAttribute("groups", groups);
        request.getRequestDispatcher("/WEB-INF/views/searchByGroupName.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String groupName = request.getParameter("group");
        try {
            List<User> users = userDao.findUsersByGroup(groupName );
            if (users.isEmpty()) {
                request.setAttribute("message", "У цій групі студентів не знайдено.");
            } else {
                request.setAttribute("users", users);
            }
            request.getRequestDispatcher("/WEB-INF/views/groupResults.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "Internal Server Error");   }
    }
}