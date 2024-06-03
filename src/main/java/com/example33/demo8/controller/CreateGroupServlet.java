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

@WebServlet("/createGroup")
public class CreateGroupServlet extends HttpServlet {
    private GroupDAO groupDao; 

    @Override
    public void init() throws ServletException {
        super.init();
        this.groupDao = (GroupDAO) getServletContext().getAttribute("groupDao");

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Group> groups = groupDao.getAllGroups();
            request.setAttribute("groups", groups);
            request.getRequestDispatcher("/WEB-INF/views/createGroup.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "An internal server error occurred.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String groupName = request.getParameter("groupName").trim();
        String schedule = request.getParameter("schedule").trim(); 


        try {
            if (groupDao.groupExists(groupName)) { // Перевірте, чи існує група з цією назвою
                request.setAttribute("errorMessage", "Група з такою назвою вже існує.");
                request.getRequestDispatcher("/WEB-INF/views/createGroup.jsp").forward(request, response);
            } else {
                Group newGroup = new Group(groupName, schedule);
                groupDao.addGroup(newGroup);
                response.sendRedirect("deanDashboard");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "Unable to add group due to an internal error.");
        }
    }
}
