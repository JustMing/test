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
                <c:set var="c" value="${requestScope.cata}"/>
                <h3 style = "color: red">${requestScope.error}</h3>
                <form action="updateCata" method="post">
                    <div style="float: left; margin-left: 10px;">Tên Hàng:</div><br>
                    <input type="text" name="name" value="${c.name}" readonly/>
                    <br>
                    <div style="float: left; margin-left: 10px;">Giá Tiền:</div><br>
                    <input type="text" name="price" value="${c.price}" required/>
                    <br>
                    <div style="float: left; margin-left: 10px;">Số Lượng:</div><br>
                    <input type="number" name="totalAmount" value="${c.totalAmount}" required/>
                    <br> 
                    <input type="text" value="${c.owner}" name="owner" hidden/>
                    <div class="smButton">
                        <input type="submit" value="Cập Nhật"/>
                    </div>
                </form>
            </div>
            <div class="back">
                <a href="catagories">Trở Về</a>
            </div>
        </div>
    </center>
</body>
</html>
