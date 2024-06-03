<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Результати пошуку студентів у групі</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
    <header>
        <h1 class="text-title">Результати пошуку</h1>
    </header>
    <c:if test="${message != null}">
        <p class="message">${message}</p>
    </c:if>
    <c:if test="${not empty users}">
        <div class="table-container">
            <table>
                <thead>
                <tr>
                    <th>Група</th>
                    <th>Ім'я</th>
                    <th>Прізвище</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.group.groupCode}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
    <footer>
        <a href="studentDashboard">Назад до інформаційної панелі</a>
    </footer>
</div>
</body>
</html>
