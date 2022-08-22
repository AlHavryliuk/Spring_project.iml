<%--
  Created by IntelliJ IDEA.
  User: gavrf
  Date: 01.08.2022
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Teacher info</title>
    <link rel="stylesheet" href="<c:url value="/styles/myStyle.css" />">
    <script>
        function searchSubject () {

            // Declare variables
            var input, filter, table, tr, td, i, txtValue;
            input = document.getElementById("myInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("person_table");
            tr = table.getElementsByTagName("tr");

            // Loop through all table rows, and hide those who don't match the search query
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[2];
                if (td) {
                    txtValue = td.textContent || td.innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    </script>
</head>
<body>
<h2 id="form_marg">Teachers info</h2>
<label for="myInput"></label><input type="text" id="myInput" onkeyup="searchSubject()" placeholder="Search for subject..">
<table id="person_table" border="1" cellpadding="10" cellspacing="10">
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
<p><a class="main_button" href="/spring/teachers/addTeacher"> Add Teacher </a></p>
<a class="main_button" href="/spring/"> Back </a>
</body>
<footer>
    <p class="footer_text"> NetCracker Project </p>
    <p class="footer_text"> © 2022 Havryliuk Aleksandr </p>
</footer>
</html>
