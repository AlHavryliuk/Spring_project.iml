<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gavrf
  Date: 01.08.2022
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Welcome page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/myStyle.css"/>
</head>
<body>
<div><h1 id="form_marg">Application menu:</h1>
    <ol>
        <p><a class="applicationMenu" href="/spring/students/viewAllStudents">Students info:</a></p>
        <p><a class="applicationMenu" href="/spring/teachers/viewAllTeachers">Teacher info:</a></p>
        <p><a class="applicationMenu" href="/spring/view2/football/footballTeam">Football team:</a></p>
        <p><a class="applicationMenu" href="/spring/students/searchPerson">Search student:</a></p>
    </ol>
</div>

</body>
<footer>
    <p class="footer_text"> NetCracker Project </p>
    <p class="footer_text"> © 2022 Havryliuk Aleksandr </p>

</footer>
</html>
