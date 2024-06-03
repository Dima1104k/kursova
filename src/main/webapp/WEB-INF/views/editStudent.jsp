<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Редагування студентів</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <header>
        <h1 class="text-title">Редагування студентів</h1>
    </header>
    <form action="editStudent" method="POST">
  
        <input type="hidden" name="id" value="${student.id}"/>
            <label for="firstName">Ім'я:</label>
            <input type="text" id="firstName" name="firstName" value="${student.firstName}" required/>

            <label for="lastName">Прізвище:</label>
            <input type="text" id="lastName" name="lastName" value="${student.lastName}" required/>

            <label for="group">Група:</label>
            <select id="group" name="group" required>
                <option value="">Вибрати групу</option>
           
                <c:forEach items="${groups}" var="group">
                    <option value="${group.groupCode}" >${group.groupCode}</option>
                </c:forEach>
            </select>
            <label for="birthDate">Дата народження:</label>
            <input type="date" id="birthDate" name="birthDate" value="${student.birthDate}" required/>

            <label for="faculty">Факультет:</label>
            <input type="text" id="faculty" name="faculty" value="${student.faculty}" required/>

            <label for="educationForm">Форма навчання:</label>
            <input type="text" id="educationForm" name="educationForm" value="${student.educationForm}" required/>

            <label for="course">Курс навчання:</label>
            <input type="number" id="course" name="course" value="${student.course}" required/>

            <label for="speciality">Спеціальність:</label>
            <input type="text" id="speciality" name="speciality" value="${student.speciality}" required/>

        <button type="submit">Оновити дані</button>
    </form>
</div>
</body>
</html>
