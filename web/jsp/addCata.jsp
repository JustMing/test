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
                <h1>Thêm Hàng</h1>
                <h3 style = "color: red">${requestScope.error}</h3>
                <form action="addCata" method="post">
                    <input type="text" name="name" placeholder="Tên Hàng" required/>
                    <br>
                    <input type="text" name="price" placeholder="Giá Tiền" required/>
                    <br>
                    <input type="number" name="totalAmount" placeholder="Số Lượng" required/>
                    <br> 

                    <%
                    if(session.getAttribute("emp") != null) {
                    %>
                    <input type="text" value="${owner}" name="owner" hidden/>
                    <%
                        } else {
                    %>
                    <input type="text" value="${user.username}" name="owner" hidden/>
                    <%
                        }
                    %>
                    <div class="smButton">
                        <input type="submit" value="Thêm Hàng"/>
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
