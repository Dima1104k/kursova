package com.example33.demo8.controller;
import com.example33.demo8.dao.GroupDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteGroup")
public class DeleteGroupServlet extends HttpServlet {
    private GroupDAO groupDao;

    @Override
    public void init() throws ServletException {
        super.init();
        this.groupDao = (GroupDAO) getServletContext().getAttribute("groupDao");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String groupCode = request.getParameter("groupName");

        try {
            groupDao.removeGroup(groupCode);

            response.sendRedirect("deanDashboard");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "Unable to delete the group due to an internal server error..");
        }
    }
}