<%-- 
    Document   : updateEmp
    Created on : Jul 4, 2024, 10:57:34 PM
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
                <c:set var="e" value="${requestScope.employees}"/>
                <form action="update" method="post">
                    <div style="float: left; margin-left: 10px;">Tên Đăng Nhập:</div><br>
                    <input type="text" name="username" value="${e.username}" readonly/>
                    <br>
                    <div style="float: left; margin-left: 10px;">Mật Khẩu:</div><br>
                    <input type="text" name="password" value="${e.password}" required/>
                    <br>
                    <div style="float: left; margin-left: 10px;">Tên:</div><br>
                    <input type="text" name="nickname" value="${e.nickname}" required/>
                    <br> 
                    <div style="float: left; margin-left: 10px;">Liên Lạc:</div><br>
                    <input type="text" name="sdt" value="${e.sdt}" required/>                   
                    <br>
                    <input type="text" value="${e.owner}" name="owner" hidden/>
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
