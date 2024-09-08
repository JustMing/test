<%-- 
    Document   : setting
    Created on : Jul 5, 2024, 4:15:02 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <h1>Sửa Thông Tin</h1>
                <c:set var="a" value="${requestScope.account}"/>
                <h3 style = "color: red">${requestScope.error}</h3>
                <form action="setting" method="post">
                    <div style="float: left; margin-left: 10px;">Tên Đăng Nhập:</div><br>
                    <input type="text" name="username" value="${a.username}" readonly/>
                    <br>
                    <div style="float: left; margin-left: 10px;">Mật Khẩu:</div><br>
                    <input type="text" name="password" value="${a.password}" required/>
                    <br>
                    <div style="float: left; margin-left: 10px;">Tên:</div><br>
                    <input type="text" name="nickname" value="${a.nickname}" required/>
                    <br> 
                    <div class="smButton">
                        <input type="submit" value="Cập Nhật"/>
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
