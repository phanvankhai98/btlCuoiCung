<%-- 
    Document   : trangchu
    Created on : Dec 26, 2020, 1:06:01 AM
    Author     : pvkha
--%>

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
            <form action="TrangChuController" method="post">
                <input class="btn btn-primary" type="submit" value="Thêm mới" name="btn">
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
                    ThanhVienDAO tvDAO = new ThanhVienDAO();
                    List<ThanhVien> lisTV = new ArrayList<ThanhVien>();
                    lisTV = (ArrayList) sc.getAttribute("listHopDong");
                    if (lisTV == null) {
                        lisTV = tvDAO.getAllKhachHang();
                    }
                    for (ThanhVien tv : lisTV) {
                %>
                <tr>
                    <td><%=tv.getHoten().getHoVaTen()%></td>
                    <td><%=tv.getSdt()%></td>
                    <td><%=tv.getDiaChi().getDiaChi()%></td>
                    <td><%=tv.getEmail()%></td>
                    <td><%=tv.getGhiChu()%></td>
                    <td>
                        <form action="EditProductServlet" method="post">
                            <input type="hidden" value="<%=tv.getId()%>" name="id">
                            <input class="btn-primary btn" type="submit" name ="button" value="Chọn" >
                        </form>
                    </td>

                </tr>
                <% }%>
            </tbody>


        </table>
        <jsp:include page="base/footer.jsp"></jsp:include>
    </body>
</html>
