<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Студентська панель</title>

    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<h1 class="text-title">Студентська панель</h1>

<h1 class="text-title">Ласкаво просимо, ${sessionScope.user.lastName} ${sessionScope.user.firstName} </h1>
<div class="container">
    <nav>
        <ul>
            <li><a href="showGroupsForStudents">Список груп</a>    </li>

            <li><a href="search">Пошук за прізвищем та ім'ям студента</a>    </li>


            <li><a href="searchByGroupName">Пошук за назвою групи</a>    </li>
        </ul>
    </nav>
</div>
</body>
<footer>
    <a class="logout" href="logout" onclick="return confirm('Ви впевнені, що хочете вийти?');">Вийти</a>

</footer>

</html>
