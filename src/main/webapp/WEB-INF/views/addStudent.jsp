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
    <title>Add Student info:</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/myStyle.css"/>
    <script>

    </script>
</head>
<body>
<div class="custom_addTable">
    <h1 id="form_marg">Add student info:</h1>
    <form:form name="userform" action="/spring/students/saveStudent"  method="POST">

        <table id="table_add">
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
                <td><input class="custom_input" type="submit" value="Save student"/></td>
            </tr>
        </table>
    </form:form>
    <div class="custom_back"><a class="main_button" href="/spring/students/viewAllStudents"> Back </a></div>
</div>
</body>
<footer style="background-color: lavender;">
    <p class="footer_text"> NetCracker Project </p>
    <p class="footer_text"> © 2022 Havryliuk Aleksandr </p>
</footer>
</html>
