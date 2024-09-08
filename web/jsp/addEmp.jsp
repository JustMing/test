<%-- 
    Document   : addEmp
    Created on : Jul 2, 2024, 7:43:42 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
    <center>
        <div class="container">
            <div class="info">
                <h1>Thêm Nhân Viên</h1>
                <h3 style = "color: red">${requestScope.error}</h3>
                <form action="add" method="post">
                    <input type="text" name="username" placeholder="Tên Đăng Nhập" required/>
                    <br>
                    <input type="text" name="password" placeholder="Mật Khẩu" required/>
                    <br>
                    <input type="text" name="nickname" placeholder="Tên Nhân Viên" required/>
                    <br> 
                    <input type="text" name="sdt" placeholder="Liên Lạc" required/>                   
                    <br>
                    <input type="text" value="${user.username}" name="owner" hidden/>
                    <div class="smButton">
                        <input type="submit" value="Thêm"/>
                    </div>
                </form>
            </div>
            <div class="back">
                <a href="employee">Trở Về</a>
            </div>
        </div>
    </center>
</body>
</html>
