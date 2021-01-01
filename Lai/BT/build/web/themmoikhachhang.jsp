<%-- 
    Document   : themmoikhachhang
    Created on : Jan 2, 2021, 12:50:59 AM
    Author     : pvkha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <body>
        <jsp:include page="base/header.jsp"></jsp:include>
            <h1>Thêm khách hàng</h1>
            <h3>Vui lòng điền thông tin khách hàng</h3>
            <form action="AddProduct" method="post">
                <table class="table table-striped" >
                    <tr class="item_form">
                        <td align="right">Họ tên:</td>
                        <td><input type="text" name="code" value=" "> </td>
                    </tr>
                    <tr class="item_form">
                        <td align="right">Ngày sinh:</td>
                        <td><input type="text" name="name" value=" "> </td>
                    </tr>
                    <tr class="item_form">
                        <td align="right">Email:</td>
                        <td><input type="text" name="description" value=" "> </td>
                    </tr>
                    <tr class="item_form">
                        <td align="right">Số điện thoại:</td>
                        <td><input type="text" name="price" value=" "> </td>
                    </tr>
                    <tr class="item_form">
                        <td align="right">Ghi chú</td>
                        <td><input type="text" name="image" value=" "> </td>
                    </tr>
                    <tr >
                        <td align="right">Số nhà:</td>
                        <td><input type="text" name="image" value=" "> </td>
                    </tr>
                    <tr >
                        <td align="right">Xóm phố:</td>
                        <td><input type="text" name="image" value=" "> </td>
                    </tr>
                    <tr >
                        <td align="right">Xã Huyện:</td>
                        <td><input type="text" name="image" value=" "> </td>
                    </tr >
                    <tr >
                        <td align="right">Tỉnh thành phố:</td>
                        <td><input type="text" name="image" value=" "> </td>
                    </tr>
                    <tr >
                        <td align="right"><input type="hidden" name="id" value=""></td>
                         <td ><input class="btn " type="submit" name ="button" value="Thêm khách hàng" ></td>
                    </tr>
                </table>



            </form>
        <jsp:include page="base/footer.jsp"></jsp:include>
    </body>
</html>

