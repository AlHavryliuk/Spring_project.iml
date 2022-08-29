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
    <div class="error_main">
        <div class="errorHead">400 Bad Request...</div>
        <div class="error_body">
            <div class="erBody_text">
                <a class="Oops">Oops!!!</a>
                <a class="ErrorMainText">Something went wrong. <br> Please, enter the correct details</a>
                <div class="errorButton">
                    <input class="errorInput" type="button" value="Try again" onclick="Previous()">
                    <a class="errorInput1" href="/spring/">Go to Application menu </a>
                </div>
            </div>
            <div class="erBody_img"><img src="${pageContext.request.contextPath}/img/oops.png"></div>
        </div>
    </div>
</div>
<footer style="background-color: #c51212;">
    <p class="footer_text"> NetCracker Project </p>
    <p class="footer_text"> © 2022 Havryliuk Aleksandr </p>
</footer>
</body>
</html>
