<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Створити нову групу</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
    <header>
        <h1 class="text-title">Створити нову групу</h1>
    </header>
    <form action="createGroup" method="post">
        <label for="groupName">Назва групи:</label>
        <input type="text" id="groupName" name="groupName" required><br>

        <label for="schedule">Розклад:</label>
        <textarea id="schedule" name="schedule" required></textarea><br>
        <button type="submit">Створити групу</button>
        <c:if test="${not empty errorMessage}">
            <div class="error-message">${errorMessage}</div>
        </c:if>
    </form>
    <footer>
        <a href="deanDashboard">Назад до інформаційної панелі</a>
    </footer>
</div>
</body>
</html>
