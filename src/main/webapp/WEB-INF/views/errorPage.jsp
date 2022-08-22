<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gavrf
  Date: 20.08.2022
  Time: 2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/myStyle.css"/>
    <script>
        function Previous() {
            window.history.back()
        }
    </script>

</head>
<body>
<div>
    <div class="errorHead" style="font-size: 64px;">400 Bad Request...</div>
    <div class="errorBodyInfo">
        <div class="errorBodyMain">
            <div class="errorBodyMain1">Oops...</div>
            <div class="errorBodyMain2"> Something went wrong. Please, enter the correct details </div>
            <div class="errorBodyMain3">
                <div class="errorBodyMain4">
                    <input class="errorInput" type="button" value="Try again" onclick="Previous()"></div>
                <div class="errorBodyMain4">
                    <a class="errorInput" href="/spring/">Go to Application menu </a></div>
                </div>
        </div>
    </div>
</div>
<footer style="background-color: #c51212;">
    <p class="footer_text"> NetCracker Project </p>
    <p class="footer_text"> © 2022 Havryliuk Aleksandr </p>
</footer>
</body>
</html>
