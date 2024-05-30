package com.example33.demo8.controller;
import com.example33.demo8.model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebFilter("/*")  // Застосування фільтра до всіх запитів
public class AuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        String requestedPage = request.getRequestURI();
        User user = (session != null) ? (User) session.getAttribute("user") : null;

           // Перевірка, чи користувач аутентифікований та чи має відповідну роль для доступу до сторінок
        if ((requestedPage.endsWith("deanDashboard") && (user == null || !"dean".equals(user.getType()))) ||
                (requestedPage.endsWith("studentDashboard") && (user == null || !"student".equals(user.getType())))) {
            request.setAttribute("errorMessage", "Доступ заборонено: Ви не маєте права доступу до цієї сторінки.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        chain.doFilter(req, res); // Продовження обробки запиту, якщо все добре
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Ініціалізація фільтра, якщо потрібно
    }

    @Override
    public void destroy() {
        // Очищення ресурсів, якщо потрібно
    }
}
