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
        <a style="font-size: 20px" href = "/spring/students/viewAllStudents">Students info:</a> </p>
        <a style="font-size: 20px" href = "/spring/teachers/viewAllTeachers">Teacher info:</a>  </p>
        <a style="font-size: 20px" href = "/spring/search/searchPerson">Search student:</a>
    </ol>
    </div>

</body>
<footer>
    <p></p><p> NetCracker Project </p> <p> © 2022 Havryliuk Aleksandr </p>

</footer>
</html>
