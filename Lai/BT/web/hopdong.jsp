<%-- 
    Document   : hopdong
    Created on : Jan 4, 2021, 11:27:32 PM
    Author     : pvkha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="container">
        <jsp:include page="base/header.jsp"></jsp:include>
            <div class=" col-md-9 col-lg-9 "> 
                <table class="table table-user-information">
                    <tbody>
                        <tr>
                            <td>Tên khách hàng:</td>
                            <td>Programming</td>
                        </tr>
                        <tr>
                            <td>Số điện thoại:</td>
                            <td>06/23/2013</td>
                        </tr>
                        <tr>
                            <td>Ngày sinh:</td>
                            <td>01/24/1988</td>
                        </tr>

                        <tr>
                        <tr>
                            <td>Địa chỉ:</td>
                            <td>Female</td>
                        </tr>
                        <tr>
                            <td>Xe thuê: </td>
                            <td>123-4567-890(Landline)<br><br>555-4567-890(Mobile)</td>
                        </tr>
                        <tr>
                            <td>Ngày thuê - Ngày trả: </td>
                            <td><a href="mailto:info@support.com">info@support.com</a></td>
                        </tr>
                    <td>Tiền cọc:</td>
                    <td>123-4567-890(Landline)<br><br>555-4567-890(Mobile)</td>
                    </tr>
                    </tr>
                    <td>Tài sản đảm bảo:</td>
                    <td>123-4567-890(Landline)<br><br>
                        <select name="DropDownTimezone" id="DropDownTimezone" class="input-xlarge">
                            <option value="-12.0">(GMT -12:00) Eniwetok, Kwajalein</option>
                            <option value="-11.0">(GMT -11:00) Midway Island, Samoa</option>
                            <option value="-10.0">(GMT -10:00) Hawaii</option>
                            <option value="-9.0">(GMT -9:00) Alaska</option>
                        </select><input type="submit" value="Thêm" /><br><br>
                        <input type="submit" value="Thêm tài sản đảm bảo">
                    </td>
                    </tr>
                    </tbody>
                </table>
                <input type="submit" value="Tạo hợp đồng" />

            </div>
        <jsp:include page="base/footer.jsp"></jsp:include>
    </body>
</html>
