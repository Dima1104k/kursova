<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ласкаво просимо</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <header>
        <h1 class="text-title">Ласкаво просимо до системи управління</h1>
    </header>
    <div class="content">
       <p><b>Виберіть свою роль:</b></p>
        <a href="login?type=dean" class="button">Увійдіть як працівник деканату</a><br>
        <a href="login?type=student" class="button">Увійдіть як студент</a>
    </div>
    <c:if test="${not empty errorMessage}">
        <div class="error-message">
            <strong>Помилка: ${errorMessage}</strong>
        </div>
    </c:if>
</div>
</body>
</html>
