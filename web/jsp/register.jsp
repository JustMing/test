<%-- 
    Document   : register
    Created on : Jun 8, 2024, 9:10:39 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
    <center>
        <div class="container">
            <div class="info">
                <h1>Đăng Ký</h1>
                <%
                    if(request.getAttribute("ms") != null) {
                        String ms = (String)request.getAttribute("ms");
                %>
                    <h3 style="color: red"><%= ms %></h3>
                <%
                    }
                %>
                <form action="register" method="post">
                    <input type="text" name="nickname" placeholder="Enter NickName" required><br />
                    <input type="text" name="username" placeholder="Enter Username" required/><br />
                    <input type="password" name="password" placeholder="Enter Password" required><br />
                    <div class="smButton">
                        <input type="submit" value="Đăng Ký" />
                    </div>
                </form>
            </div>
            <div class="regis">
                Bạn đã có tài khoản? <a href="http://localhost:8080/ASM/login">Đăng Nhập</a>
            </div>
        </div>
    </center>
</body>
</html>
