<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="uk">
<head>
    <title>Вхід в систему</title>

    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="login-container">
        <h1 class="text-title">Вхід в систему</h1>
        <%
            String userType = request.getParameter("type");
            if (request.getAttribute("errorMessage") != null) {
        %>
        <p class="error-message"><%= request.getAttribute("errorMessage") %></p>
        <%  }
        %>
             <form action="<%="authenticate?type=" + userType %>" method="post">
             <label for="username">Логін:</label>
             <input type="text" id="username" name="username" required><br/>
             <label for="password">Пароль:</label>
             <input type="password" id="password" name="password" required><br/>
             <button type="submit">Увійти</button>
          </form>
    </div>
</body>
</html>
