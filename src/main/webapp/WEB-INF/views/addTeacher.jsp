<%--
  Created by IntelliJ IDEA.
  User: gavrf
  Date: 01.08.2022
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix ="form" %>

<html>
<head>
    <title>Add Teacher info:</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/myStyle.css"/>
</head>
<body>
    <h1 id="form_marg">Add Teacher info:</h1>
    <form:form action="/spring/teachers/saveTeacher" method="POST">
        <div>
        <table id="table_add">
            <tr>
                <td>Enter name</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Enter subject</td>
                <td><form:input path="subject"/></td>
            </tr>
            <tr>
                <td>Enter grade</td>
                <td><form:input path="grade"/></td>
            </tr>
            <tr>

                <td><input id="input1" type="submit" value="Save teacher" /></td>
                <td></td>
            </tr>
        </table></div>
        <div> </p> <a href="/spring/teachers/viewAllTeachers"> Back </a> </div>
    </form:form>
    <footer>
        <p></p><p> Netcracker Project </p> <p> © 2022 Havryliuk Aleksandr </p>
    </footer>
</body>
</html>
