<%-- 
    Document   : hopdong
    Created on : Jan 4, 2021, 11:27:32 PM
    Author     : pvkha
--%>

<%@page import="dao.xe.XeDAO"%>
<%@page import="model.Xe"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Nguoi"%>
<%@page import="dao.khachhang.KhachHangDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="container">
        <jsp:include page="base/header.jsp"></jsp:include>
            <h2>Hợp đồng thuê xe</h2>
        <%
            List<String> listIDXe = (List<String>) session.getAttribute("listIDXe");
            List<Xe> listXe = null;
            String idKhachHang = (String) session.getAttribute("idKhachHang");
            String ngayThue = (String) session.getAttribute("ngayThue");
            String ngayTra = (String) session.getAttribute("ngayTra");
            KhachHangDAO khDAO = new KhachHangDAO();
            Nguoi kh = khDAO.getKhachHangByID(idKhachHang);
            XeDAO xeDAO = new XeDAO();

            for (String i : listIDXe) {
                if (listXe == null) {
                    listXe=xeDAO.getXeBuyID(i);
                } else {
                    listXe.addAll(xeDAO.getXeBuyID(i));
                }

            }
        %>
        <div class=" col-md-9 col-lg-9 "> 
            <table class="table table-user-information">
                <tbody>
                    <tr>
                        <td>Tên khách hàng:</td>
                        <td><%=kh.getHoten().getHoVaTen()%></td>
                    </tr>
                    <tr>
                        <td>Số điện thoại:</td>
                        <td><%=kh.getSdt()%></td>
                    </tr>
                    <tr>
                        <td>Ngày sinh:</td>
                        <td><%=kh.getNgaySinh()%></td>
                    </tr>

                    <tr>
                    <tr>
                        <td>Địa chỉ:</td>
                        <td><%=kh.getDiaChi().getDiaChi()%></td>
                    </tr>
                    <tr>
                        <td>Xe thuê: </td>
                        <td>
                            <%for(Xe xe: listXe){%> 
                            <%=xe.getTenXe()+","+xe.getDongXe()+","+xe.getHangXe()%><br><br>
                            <%}%> 
                        </td>
                    </tr>
                    <tr>
                        <td>Ngày thuê - Ngày trả: </td>
                        <td><%=ngayThue+"-"+ngayTra %></td>
                    </tr>
                <td>Tiền cọc:</td>
                <td><input type="input" name="tiencoc" value=""><br><br><input type="input" name="loaitien" value=""></td>
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
