<%-- 
    Document   : trangchu
    Created on : Dec 26, 2020, 1:06:01 AM
    Author     : pvkha
--%>

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
            <h2>Danh sách hơp đồng thuê xe</h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Khách hàng</th>
                        <th>Xe thuê</th>
                        <th>Ngày thuê</th>
                        <th>Ngày trả</th>
                        <th>Lựa chọn</th>
                    </tr>
                </thead>

                <tbody>
                <%
                    ServletContext sc = getServletContext();
                    HopDongDAO sp = new HopDongDAO();
                    List<HopDong> listHopDong = new ArrayList<HopDong>();
                    listHopDong = (ArrayList) sc.getAttribute("listHopDong");
                    if (listHopDong == null) {
                        listHopDong = sp.getAll();
                    }
                    sc.removeAttribute("listProduct");
                    for (HopDong hd : listHopDong) {
                %>
                <tr>
                    <td><%=hd.getTen()%></td>
                    <td><%=hd.getTen()%></td>
                    <td><%=hd.getNgayThue()%></td>
                    <td><%=hd.getNgayTra()%></td>
                    <td><%=hd.getTen()%></td>
                </tr>

                <% }%>
            </tbody>


        </table>
        <jsp:include page="base/footer.jsp"></jsp:include>
    </body>
</html>
