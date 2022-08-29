<%--
  Created by IntelliJ IDEA.
  User: gavrf
  Date: 16.08.2022
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Search info:</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/myStyle.css"/>
</head>
<body>
<div class="text_form_search">Search information about Student</div>
<hr>
<div class="form_search_main">
    <div class="form_search_one">
        <div class="form_two">
            <div class="form_search_left">
                <form:form action="/spring/students/searchPersonId" method="POST">
                    <b><i>ID</i></b> : <label>
                    <input type="text" value="" name="id" placeholder="Enter Search Id"/>
                </label>
                    <input type="submit" name="Enter" value="Search"/>
                </form:form>
            </div>
            <div class="form_search_left">
                <form:form action="/spring/students/searchPersonName" method="POST">
                    <b><i>Name</i></b> : <label>
                    <input type="text" value="" name="username" placeholder="Enter Search Name"/>
                </label>
                    <input type="submit" name="Enter" value="Search"/>
                </form:form>
            </div>
        </div>
        <div>
            <div class="form_search_right">
                <form:form action="/spring/students/searchPersonAge" method="POST">
                    <b><i>Age</i></b> : <label>
                    <input type="text" value="" name="age" placeholder="Enter Search Age"/>
                </label>
                    <input type="submit" name="Enter" value="Search"/>
                </form:form>
            </div>
            <div class="form_search_right">
                <form:form action="/spring/students/searchPersonGroup" method="POST">
                    <b><i>Group</i></b> : <label>
                    <input type="text" value="" name="group" placeholder="Enter Search Group"/>
                </label>
                    <input type="submit" name="Enter" value="Search"/>
                </form:form>
            </div>
        </div>
    </div>
</div>
<hr>
<div style="width: 100%">
    <table id="person_table" border="1" cellpadding="10" cellspacing="10">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>Group</th>
        </tr>
        <c:forEach var="student" items="${listOfStudents}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>${student.group}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div style="margin-top: 1%">
    <a class="main_button" href="/spring/"> Back </a>
</div>
</body>
<footer>
    <p class="footer_text"> NetCracker Project </p>
    <p class="footer_text"> © 2022 Havryliuk Aleksandr </p>
</footer>
</html>
