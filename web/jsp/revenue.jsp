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
                    <div class="search">
                        <form action="searchHis" method="get">
                            <input type="submit" value="Tìm" class="smButton" />
                            <input style="padding:9px 10px;" class="searchName" placeholder="Tìm Kiếm" type="text" name="name"/>
                            <select class="selectCSS" name="searching">
                                <option class="optionCSS" value="employee">Nhân Viên</option>
                                <option class="optionCSS" value="catagories">Hàng</option>
                            </select>
                        </form>
                    </div>
                    <div>
                        <form  method="get" action="deleteAll">
                            <input class="smButton" type="submit" value="Xóa Hết"/>
                        </form>
                    </div>
                </div>

                <center>
                    <div>
                        <table width="100%">
                            <tr style="background-color: #a41f13; color: whitesmoke;">
                                <th>Chủ</th>
                                <th>Nhân Viên</th>
                                <th>Tên Hàng</th>
                                <th>Giá Tiền</th>
                                <th>Tổng Số Lượng</th>
                                <th>Tổng Giá Tiền</th>
                            </tr>
                            <c:forEach items="${sessionScope.hisData}" var = "h">
                                <tr style="background-color: #bd5e56; color: whitesmoke; text-align: center;">
                                    <td class="tdPadding">${h.getOwner()}</td>
                                    <td>${h.getEmpName()}</td>
                                    <td>${h.getName()}</td>
                                    <td>${h.getPrice()}</td>
                                    <td>${h.getTotalAmount()}</td>
                                    <td>${h.getTotalPrice()}</td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td class="tdPadding" style="background-color: #a41f13; color: whitesmoke;" colspan="5">Tiền Chi Tiêu</td>
                                <td style="background-color: #bd5e56; color: whitesmoke; text-align: center;" colspan="1">${requestScope.lostMoney}</td>
                            </tr>
                            <tr>
                                <td class="tdPadding" style="background-color: #a41f13; color: whitesmoke;" colspan="5">Thu Nhập</td>
                                <td style="background-color: #bd5e56; color: whitesmoke; text-align: center;" colspan="1">${requestScope.getMoney}</td>
                            </tr>
                            <tr>
                                <td class="tdPadding" style="background-color: #a41f13; color: whitesmoke;" colspan="5">Tiền Lãi</td>
                                <td style="background-color: #bd5e56; color: whitesmoke; text-align: center;" colspan="1">${requestScope.stonkMoney}</td>
                            </tr>
                        </table>
                    </div>
                </center>
            </div>
        </div>
    </body>
</html>
