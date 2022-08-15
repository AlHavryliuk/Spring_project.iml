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
    <title>Students info</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/myStyle.css"/>

</head>
<body>
    <h2 id="form_marg">Students info</h2>

    <table  border="1" cellpadding="10" cellspacing="10" >
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>Group</th>
            <th>Edit</th>
            <th>Remove</th>
        </tr>

        <c:forEach var="student" items="${listOfStudents}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.group}</td>
            <td><a href="/spring/students/editStudent/${student.id}">Edit></a></td>
            <td><a href="/spring/students/removeStudent/${student.id}">Remove></a></td>
        </tr>
        </c:forEach>
    </table>
    <p></p><a href="/spring/students/addStudent"> Add Student </a>
    <p></p><a href="/spring/"> Back </a>


    <footer>
        <p></p><p> Netcracker Project </p> <p> © 2022 Havryliuk Aleksandr </p>
    </footer>
</body>
</html>
