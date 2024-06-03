<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Редагування групи</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<h1 class="text-title">Редагування групи</h1>


<c:if test="${not empty group}">
    <form action="editGroup" method="post">
        <input type="hidden" name="groupCode" value="${group.groupCode}"/>
            <label for="newGroupCode">Нова назва групи:</label>
            <input type="text" id="newGroupCode" name="newGroupCode" value="${group.groupCode}" required/>
            <label for="newSchedule">Розклад:</label>
            <textarea id="newSchedule" name="newSchedule" required>${group.schedule}</textarea>
        <button type="submit">Оновити</button>
    </form>
</c:if>

<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>
</body>
<footer>
    <a href="deanDashboard">Назад до інформаційної панелі</a>
</footer>
</html>
