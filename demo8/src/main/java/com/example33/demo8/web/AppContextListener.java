package com.example33.demo8.web;

import com.example33.demo8.dao.GroupDAO;
import com.example33.demo8.dao.StubGroupDao;
import com.example33.demo8.dao.StubUserDao;
import com.example33.demo8.dao.UserDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        GroupDAO groupDao = new StubGroupDao(); // Ініціалізація GroupDAO
        UserDAO userDao = new StubUserDao(groupDao); // Ініціалізація UserDAO з використанням GroupDAO, мені це потрбіно було для пошуку за назвою груп

        // Збереження об'єктів DAO у контексті сервлета
        context.setAttribute("userDao", userDao);
        context.setAttribute("groupDao", groupDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Очистити ресурси, якщо потрібно
    }
}
