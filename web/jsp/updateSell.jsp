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
                <h3 style = "color: red">${requestScope.error}</h3>
                <c:set var="e" value="${requestScope.sellUpdate}"/>
                <form action="sellUpdate" method="post">
                    <div style="float: left; margin-left: 10px;">Tên Hàng:</div><br>
                    <input type="text" name="name" value="${e.name}" readonly/>
                    <br>
                    <div style="float: left; margin-left: 10px;">Giá Tiền:</div><br>
                    <input type="text" name="price" value="${e.price}" required/>
                    <br>
                    <div style="float: left; margin-left: 10px;">Số Lượng</div><br>
                    <input type="number" name="totalAmount" value="${e.totalAmount}" required/>
                    <br> 
                    <%
                        if(session.getAttribute("emp") != null) {
                    %>
                    <input type="text" value="${owner}" name="owner" hidden/>
                    <input type="text" value="${emp.username}" name="empName" hidden/>
                    <%
                        } else {
                    %>
                    <input type="text" value="${user.username}" name="owner" hidden/>
                    <input type="text" value="" name="empName" hidden/>
                    <%
                        }
                    %>
                    <div class="smButton">
                        <input type="submit" value="Cập Nhật"/>
                    </div>
                </form>
            </div>
            <div class="back">
                <a href="sell">Trở Về</a>
            </div>
        </div>
    </center>
</body>
</html>
