<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Пошук за назвою групи</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<div class="container">
    <header>
        <h1 class="text-title">Пошук за назвою групи</h1>
    </header>
<form action="searchByGroupName" method="post">

    <label for="group">Група:</label>
    <select id="group" name="group" required>
        <option value="">Вибрати групу</option>
        <c:forEach items="${groups}" var="group">
            <option value="${group.groupCode}">${group.groupCode}</option>
        </c:forEach>
    </select>
    <button type="submit">Пошук</button>
</form>
    <footer>
        <a href="studentDashboard">Назад до інформаційної панелі</a>
    </footer>
</div>
</body>
</html>
