<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Пошук студента</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<div class="container">
    <header>
        <h1 class="text-title">Пошук студента</h1>
    </header>

    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>

    <form action="search" method="post">
        <input type="text" name="firstName" placeholder="Ім'я студента" required>
        <input type="text" name="lastName" placeholder="Прізвище студента" required>

        <button type="submit" > Шукати студента</button>
    </form>

    <c:if test="${searchCompleted}">
        <c:if test="${not empty user}">
            <h2 class="text-title">Результати пошуку:</h2>
            <p>Ім'я: ${user.firstName}</p>
            <p>Прізвище: ${user.lastName}</p>
            <p>Група: ${user.group.groupCode}</p>
            <p>Дата народження: ${user.birthDate}</p>
            <p>Факультет: ${user.faculty}</p>
            <p>Форма навчання: ${user.educationForm}</p>
            <p>Курс навчання: ${user.course}</p>
            <p>Спеціальність: ${user.speciality}</p>
        </c:if>
    </c:if>
    <footer>
        <a href="studentDashboard">Назад до інформаційної панелі</a>
    </footer>
</div>
</body>
</html>
