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
        <th>Дії</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.groupCode}</td>
            <td>${group.schedule}</td>
            <td>
                <a href="editGroup?groupCode=${group.groupCode}">
                    <button type="submit"  class="button edit-button">Редагувати</button>
                </a>
                <form action="deleteGroup" method="post" onsubmit="return confirm('Ви впевнені, що хочете видалити цю групу?');">
                    <input type="hidden" name="groupName" value="${group.groupCode}" />
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
</body>
</html>
