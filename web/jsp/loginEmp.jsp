<%-- 
    Document   : login
    Created on : Jun 8, 2024, 8:57:40 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body>
    <center>

        <div class="container">
            <div class="info">
                <h1>Đăng Nhập</h1>
                <div class="who">
                    <a href="login">Chủ</a>
                    <a href="emp_login" class="emp_log">NViên</a>
                </div>
                <%
                    if(request.getAttribute("err") != null) {
                        String err = (String)request.getAttribute("err");
                %>
                <h3 style="color: red"><%= err %></h3>
                <%
                    }
                %>
                <form action="emp_login" method="post">
                    <input type="text" name="username" placeholder="Tên Đăng Nhập" required/><br />
                    <input type="text" name="owner" placeholder="Tên Đăng Nhập Của Chủ" required/><br />
                    <input type="password" name="password" placeholder="Mật Khẩu" required><br />
                    <div class="smButton">
                        <input type="submit" value="Đăng Nhập"/>
                    </div>
                </form>
            </div>
            <div class="regis">
                Bạn chưa có tài khoản? <a href="register">Đăng Ký</a>
            </div>
        </div>
    </center>
</body>

</html>
