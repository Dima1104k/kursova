<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Список студентів</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
    <header>
        <h1 class="text-title">Список студентів</h1>
    </header>

    <div class="table-container">
        <table>
            <thead>
            <tr>
                <th>Ім'я</th>
                <th>Прізвище</th>
                <th>Група</th>
                <th>Дата народження</th>
                <th>Факультет</th>
                <th>Форма навчання</th>
                <th>Курс</th>
                <th>Спеціальність</th>
                <th>Дії</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.group.groupCode}</td>
                    <td>${student.birthDate}</td>
                    <td>${student.faculty}</td>
                    <td>${student.educationForm}</td>
                    <td>${student.course}</td>
                    <td>${student.speciality}</td>
                    <td>
                        <a href="editStudent?id=${student.id}">
                            <button type="submit" class="button edit-button">Редагувати</button>
                        </a>

                        <form action="deleteStudent" method="post" onsubmit="return confirm('Ви впевнені, що хочете видалити цю групу?');">
                            <input type="hidden" name="id" value="${student.id}" />
                            <button type="submit" class="button delete-button">Видалити</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <footer>
        <a href="deanDashboard">Назад до інформаційної панелі</a>
    </footer>
</div>
</body>
</html>
