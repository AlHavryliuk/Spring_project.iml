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
<body class="er_Body">
<div class="main_error_page">
    <div class="header_error">
        <div class="header_error_text">400 Bad Request...</div>
    </div>
    <div class="body_error">
        <div class="error_text">
            <div class="error_text_container">
                <div class="oops_text_error">Oops</div>
                <div class="body_text_error">Something went wrong <br> Please, enter the correct derails.</div>
                <div class="button_error">
                    <input class="er_button_1" type="button" value="Try again" onclick="Previous()">
                    <div class="er_button_2">
                        <a href="/spring/">Go to Application menu </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="img_error">
            <img src="${pageContext.request.contextPath}/img/oops.png">
        </div>
    </div>
</div>
<footer style="background-color: #c51212;">
    <p class="footer_text"> NetCracker Project </p>
    <p class="footer_text"> © 2022 Havryliuk Aleksandr </p>
</footer>
</body>
</html>
