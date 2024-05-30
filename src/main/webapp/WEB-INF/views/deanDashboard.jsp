<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Деканська панель</title>


    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1 class="text-title">Деканська панель</h1>
<h1 class="text-title">Ласкаво просимо, ${sessionScope.user.firstName} ${sessionScope.user.lastName}</h1>

<c:if test="${not empty error}">
    <div class="error">${error}</div>
</c:if>
<div class="container">
    <nav>
        <ul>
            <li><a href="studentList">Список студентів</a>

            </li>

            <li><a href="createStudent">Створення студента</a>

            </li>
            <li><a href="createGroup">Створити групу</a>

            </li>
            <li><a href="showGroups">Список груп</a>
            </li>
        </ul>
    </nav>
</div>
</body>
<footer>
    <a class="logout" href="logout" onclick="return confirm('Ви впевнені, що хочете вийти?');">Вийти</a>
</footer>
</html>
