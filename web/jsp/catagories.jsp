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
                        <a href="addCata">Thêm Hàng</a>
                    </div>

                    <div class="search">
                        <form action="searchCata" method="get">
                            <input class="searchName" placeholder="Tên Hàng" type="text" name="name"/>
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
                            <input type="submit" value="Tìm" class="smButton" />
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
                                <th>Tổng Tiền</th>
                                <th colspan="2"></th>
                            </tr>
                            <c:forEach items="${sessionScope.cataData}" var = "c">
                                <tr style="background-color: #bd5e56; color: whitesmoke; text-align: center;">
                                    <td class="tdPadding">${c.getName()}</td>
                                    <td>${c.getPrice()}</td>
                                    <td>${c.getTotalAmount()}</td>
                                    <td>${c.getPrice()*c.getTotalAmount()}</td>
                                    <td>
                                        <a href="updateCata?name=${c.name}">Sửa</a>
                                    </td>
                                    <td>
                                        <a href="deleteCata?name=${c.name}">Xóa</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </center>
            </div>
        </div>
    </body>
</html>
