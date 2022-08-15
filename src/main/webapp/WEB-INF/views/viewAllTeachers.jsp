<%--
  Created by IntelliJ IDEA.
  User: gavrf
  Date: 01.08.2022
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Teacher info</title>
    <link rel="stylesheet" href="<c:url value="/styles/myStyle.css" />" >
</head>
<body>
    <h2 id="form_marg">Teachers info</h2>
    <table  border="1" cellpadding="10" cellspacing="10" >
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Subject</th>
            <th>Grade</th>
            <th>Edit</th>
            <th>Remove</th>
            <c:forEach var="teacher" items="${listOfTeachers}">
        <tr>
            <td>${teacher.id}</td>
            <td>${teacher.name}</td>
            <td>${teacher.subject}</td>
            <td>${teacher.grade}</td>
            <td><a href="/spring/teachers/editTeacher/${teacher.id}">Edit></a></td>
            <td><a href="/spring/teachers/removeTeacher/${teacher.id}">Remove></a></td>
        </tr>
        </c:forEach>
    </table>
<p><a href="/spring/teachers/addTeacher"> Add Teacher </a> </p> <a href="/spring/"> Back </a>
    <footer>
        <p></p><p> Netcracker Project </p> <p> © 2022 Havryliuk Aleksandr </p>
    </footer>
</body>
</html>
