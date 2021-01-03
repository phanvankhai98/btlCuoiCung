<%-- 
    Document   : trangchu
    Created on : Dec 26, 2020, 1:06:01 AM
    Author     : pvkha
--%>

<%@page import="dao.khachhang.KhachHangDAO"%>
<%@page import="model.Nguoi"%>
<%@page import="dao.thanhvien.ThanhVienDAO"%>
<%@page import="java.util.List"%>
<%@page import="dao.hopdong.HopDongDAO"%>
<%@page import="model.HopDong"%>
<%@page import="java.util.ArrayList"%>
<%@page import="constant.Constants"%>
<%@page import="model.ThanhVien"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>

    <body class="container">
        <jsp:include page="base/header.jsp"></jsp:include>
            <h2>Danh sách khách hàng</h2>
            <form action="ChonKhachHangController" method="post">
                <table >
                    <tr>
                        <td>
                            <input class="form-control" type="text" placeholder="Search" aria-label="Search" 
                                   value="" name="search">
                        </td>
                        <td>
                            <input  type="hidden" value="search" name="btn">
                            <input class="btn btn-primary " type="submit" value="Tìm" >
                        </td>
                    </tr>
                </table>
            </form>
            <form action="ChonKhachHangController" method="post">
                 <input  type="hidden" value="add" name="btn">
                <input class="btn-them-moi-kh btn btn-primary " type="submit" value="Thêm mới khách hàng" >
            </form>


            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Họ tên</th>
                        <th>Số điện thoại</th>
                        <th>Địa chỉ</th>
                        <th>Email</th>
                        <th>Ghi chú</th>
                        <th>Chọn</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    ServletContext sc = getServletContext();
                    KhachHangDAO tvDAO = new KhachHangDAO();
                    List<Nguoi> listTV;
                    listTV = (List) sc.getAttribute("listKhachHang");
                    if (listTV == null) {
                        listTV = tvDAO.getAllKhachHang();
                    }
                    for (Nguoi nguoi : listTV) {
                %>
                <tr>
                    <td><%=nguoi.getHoten().getHoVaTen()%></td>
                    <td><%=nguoi.getSdt()%></td>
                    <td><%=nguoi.getDiaChi().getDiaChi()%></td>
                    <td><%=nguoi.getEmail()%></td>
                    <td><%=nguoi.getGhiChu()%></td>
                    <td>
                        <form action="ChonKhachHangController" method="get">
                            <input type="hidden" value="<%=nguoi.getId()%>" name="btn">
                            <input class="btn-primary btn" type="submit" value="Chọn" >
                        </form>
                    </td>

                </tr>
                <% }%>
            </tbody>


        </table>
        <jsp:include page="base/footer.jsp"></jsp:include>
    </body>
</html>
