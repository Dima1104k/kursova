<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Створення студента</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">


</head>
<body>
<div class="container">
    <header>
        <h1 class="text-title">Створення студента</h1>
    </header>

<form action="createStudent" method="post">
    <label for="firstName">Ім'я:</label> <input type="text" id="firstName" name="firstName" required>
    <label for="lastName">Прізвище:</label> <input type="text" id="lastName" name="lastName" required>
    <label for="group">Група:</label>
    <select id="group" name="groupCode" required>
        <option value="">Виберіть групу</option>
        <c:forEach items="${groups}" var="group">
            <option value="${group.groupCode}">${group.groupCode}</option>
        </c:forEach>
    </select>
    <label for="birthDate">Дата народження:</label> <input type="date" id="birthDate" name="birthDate" required>
    <label for="faculty">Факультет:</label> <input type="text" id="faculty" name="faculty" required/>
    <label for="educationForm">Форма навчання:</label> <input type="text" id="educationForm" name="educationForm" required/>
    <label for="course">Курс навчання:</label> <input type="number" id="course" name="course" required/>
    <label for="speciality">Спеціальність:</label> <input type="text" id="speciality" name="speciality" required/>
    <button type="submit">Створити студента</button>
</form>
    <footer>
        <a href="deanDashboard">Назад до інформаційної панелі</a>
    </footer>
</div>
</body>
</html>
