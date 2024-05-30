package com.example33.demo8.controller;

import com.example33.demo8.dao.GroupDAO;
import com.example33.demo8.model.Group;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/editGroup")
public class EditGroupServlet extends HttpServlet {

    private GroupDAO groupDao;  // Використання GroupDAO для управління даними груп

    @Override
    public void init() throws ServletException {
        super.init();
        this.groupDao = (GroupDAO) getServletContext().getAttribute("groupDao");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Group> groups = groupDao.getAllGroups();
            request.setAttribute("groups", groups);
            String groupCode = request.getParameter("groupCode");
            if (groupCode != null && !groupCode.isEmpty()) {
                Group group = groupDao.getGroupByCode(groupCode);
                if (group != null) {
                    request.setAttribute("group", group);
                    request.setAttribute("schedule", group.getSchedule()); // Додавання розкладу до атрибутів
                } else {
                    request.setAttribute("errorMessage", "Група не знайдена.");
                }
            }
            request.getRequestDispatcher("/WEB-INF/views/editGroup.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "An internal server error occurred.");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String groupCode = request.getParameter("groupCode").trim();
        String newGroupCode = request.getParameter("newGroupCode").trim();
        String newSchedule = request.getParameter("newSchedule").trim();

        try {

             if ( groupDao.groupExists(newGroupCode) && !groupCode.equalsIgnoreCase(newGroupCode)) {
                 request.setAttribute("errorMessage", "Група з такою назвою вже існує.");
                doGet(request, response); // Виклик doGet для відновлення форми з повідомленням про помилку
                return;
            }

            groupDao.updateGroup(groupCode, newGroupCode, newSchedule);
            response.sendRedirect("showGroups"); // Перенаправлення на список груп після успішного оновлення
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "An internal server error occurred.");
        }
    }
}