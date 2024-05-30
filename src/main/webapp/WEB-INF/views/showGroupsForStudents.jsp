<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Групи</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<div class="container">
    <header>
        <h1 class="text-title">Список груп</h1>
    </header>
<c:if test="${not empty errorMessage}">
    <p class="error">${errorMessage}</p>
</c:if>
    <div class="table-container">
        <table>
    <thead>
    <tr>
        <th>Назва групи</th>
        <th>Розклад</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.groupCode}</td>
            <td>${group.schedule}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<footer>
    <a href="studentDashboard">Назад до інформаційної панелі</a>
</footer>
</div>
</body>
</html>
