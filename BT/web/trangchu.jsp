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
    <jsp:include page="base/header.jsp"></jsp:include>
    <body class="container">
            <h2>Danh sách hơp đồng thuê xe</h2>
            <button id="btn-add-contract">Thêm</button>
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
    </body>
    <jsp:include page="base/footer.jsp"></jsp:include>
</html>
<script>
    $('#btn-add-contract').on('click', function () {
       window.location.href="themhopdong.jsp"
    })
</script>