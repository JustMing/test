<%-- 
    Document   : employee
    Created on : Jul 1, 2024, 4:51:30 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/homeCSS.css">
    </head>
    <body>
        <!-- phần bên trái -->
        <div class="container">
            <div class="left_path">
                <div class="left_container">
                    <div class="attribute">
                        <label for="sell"><img src="image/banhang-30.png" alt="ảnh"></label>
                        <div class="attribute2">
                            <a id="sell" href="sell">Bán Hàng</a>
                        </div>
                    </div>
                    <div class="attribute">
                        <label for="employee"><img src="image/khachhang2-35.png" alt="ảnh"></label>
                        <div class="attribute2">
                            <a id="employee" href="employee">Nhân Viên</a>
                        </div>
                    </div>
                    <div class="attribute">
                        <label for="catagories"><img src="image/donhang2.png" alt="ảnh"></label>
                        <div class="attribute2">
                            <a id="catagories" href="catagories">Kho Hàng</a>
                        </div>
                    </div>
                    <div class="attribute">
                        <label for="revenue"><img src="image/baocao2.png" alt="ảnh"></label>
                        <div class="attribute2">
                            <a id="revenue" href="revenue">Doanh Thu</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- phần bên phải -->
            <div class="right_path">
                <div>
                    <form class="logout" action="logout" method="get">
                        <input type="submit" value="Đăng Xuất">
                    </form>
                </div>
                <div class="function">
                    <div class="add">
                        <form method="get" action="addGoods" style="margin: 0 0 20px 0;">
                            <input class="smButton" type="submit" value="Thêm Hàng"/>
                            <select class="selectCSS" name="good">
                                <c:forEach items="${sessionScope.cataData}" var = "c">
                                    <option class="optionCSS" value="${c.name}">${c.name}</option>
                                </c:forEach>
                            </select>
                        </form>
                    </div>
                    <h3 style = "color: red">${requestScope.error}</h3>
                    <div>
                        <form  method="get" action="refresh">
                            <input class="smButton" type="submit" value="Đơn Mới"/>
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
                        </form>
                    </div>
                </div>

                <center>
                    <div>
                        <table width="100%">
                            <tr style="background-color: #a41f13; color: whitesmoke;">
                                <th>Tên Hàng</th>
                                <th>Giá Tiền</th>
                                <th>Tổng Số Lượng</th>
                                <th>Tổng Giá Tiền</th>
                                <th colspan="2"></th>
                            </tr>
                            <c:forEach items="${sessionScope.sellData}" var = "s">
                                <tr style="background-color: #bd5e56; color: whitesmoke; text-align: center;">
                                    <td class="tdPadding">${s.getName()}</td>
                                    <td>${s.getPrice()}</td>
                                    <td>${s.getTotalAmount()}</td>
                                    <td>${s.getPrice()*s.getTotalAmount()}</td>
                                    <td>
                                        <a href="updateSell?name=${s.name}">Sửa</a>
                                    </td>
                                    <td>
                                        <a href="deleteSell?name=${s.name}">Xóa</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td class="tdPadding" style="background-color: #a41f13; color: whitesmoke;" colspan="3">Giá Tiền</td>
                                <td style="background-color: #bd5e56; color: whitesmoke; text-align: center" >${pay}</td>
                                <td style="background-color: #a41f13; color: whitesmoke;" colspan="2"></td>
                            </tr>
                        </table>
                        <form action="cal" method="POST">
                            <input class="smButton" type="submit" value="Thanh Toán"/>
                        </form>
                    </div>
                </center>
            </div>
        </div>
    </body>
</html>
