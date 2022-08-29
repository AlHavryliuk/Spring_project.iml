<%--
  Created by IntelliJ IDEA.
  User: gavrf
  Date: 01.08.2022
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
<head>
    <title>Add Teacher info:</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/myStyle.css"/>
</head>
<body>
<div class="custom_addTable">
    <h1 id="form_marg">Add Teacher info:</h1>
    <form:form action="/spring/teachers/saveTeacher" method="POST">
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
            <tr class="non">
                <td></td>
                <td><input class="custom_input" type="submit" value="Save teacher"/></td>
            </tr>
        </table>
    </form:form>
    <div class="custom_back"> </p> <a class="main_button" href="/spring/teachers/viewAllTeachers"> Back </a></div>
</div>
</body>
<footer style="background-color: lavender;">
    <p class="footer_text"> NetCracker Project </p>
    <p class="footer_text"> © 2022 Havryliuk Aleksandr </p>
</footer>
</html>
