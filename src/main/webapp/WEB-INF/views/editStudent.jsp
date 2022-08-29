<%--
  Created by IntelliJ IDEA.
  User: gavrf
  Date: 02.08.2022
  Time: 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Edit Student info:</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/myStyle.css"/>
</head>
<body>
<div class="custom_editTable">
    <h1 id="form_marg">Edit student info:</h1>
    <form:form action="/spring/students/saveEditStudent" method="POST">
        <table id="table_add">
            <tr>
                <td>Enter id</td>
                <td><form:input readonly="true" path="id"/></td>
            </tr>
            <tr>
                <td>Enter name</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Enter age</td>
                <td><form:input path="age" maxlength="2"/></td>
            </tr>
            <tr>
                <td>Enter group</td>
                <td><form:input path="group"/></td>
            </tr>
            <tr class="non">
                <td></td>
                <td><input class="custom_input" type="submit" value="Edit student"/></td>
            </tr>
        </table>
    </form:form>
    <div class="custom_back"><a class="main_button" href="/spring/students/viewAllStudents"> Back </a></div>
</div>
</body>
<footer style="background-color: #faa2a2;">
    <p class="footer_text"> NetCracker Project </p>
    <p class="footer_text"> © 2022 Havryliuk Aleksandr </p>
</footer>
</html>
