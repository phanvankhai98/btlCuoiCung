<%-- 
    Document   : hopdong
    Created on : Jan 4, 2021, 11:27:32 PM
    Author     : pvkha
--%>

<%@page import="constant.Constants"%>
<%@page import="dao.taisan.TaiSanDAO"%>
<%@page import="model.TaiSan"%>
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
            List<TaiSan> listTaiSan = null;
            List<String> listTaiSanDaChon = (List<String>) session.getAttribute("taisan");
            String idKhachHang = (String) session.getAttribute("idKhachHang");
            String ngayThue = (String) session.getAttribute("ngayThue");
            String ngayTra = (String) session.getAttribute("ngayTra");
            String tienCoc = (String) session.getAttribute("tiencoc");
            String loaiTien = (String) session.getAttribute("loaitien");
            if (tienCoc == null) {
                tienCoc = "";
            }
            if (loaiTien == null) {
                loaiTien = "vnd";
            }
            KhachHangDAO khDAO = new KhachHangDAO();
            Nguoi kh = khDAO.getKhachHangByID(idKhachHang);
            XeDAO xeDAO = new XeDAO();
            TaiSanDAO tsDAO = new TaiSanDAO();
            listTaiSan = tsDAO.getAllTaiSan();

            for (String i : listIDXe) {
                if (listXe == null) {
                    listXe = xeDAO.getXeBuyID(i);
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
                        <td><%=Constants.convertTime(kh.getNgaySinh() + "0000")%></td>
                    </tr>

                    <tr>
                    <tr>
                        <td>Địa chỉ:</td>
                        <td><%=kh.getDiaChi().getDiaChi()%></td>
                    </tr>
                    <tr>
                        <td>Xe thuê: </td>
                        <td>
                            <%for (Xe xe : listXe) {%> 
                            <%=xe.getTenXe() + "," + xe.getDongXe() + "," + xe.getHangXe()%><br><br>
                            <%}%> 
                        </td>
                    </tr>
                    <tr>
                        <td>Ngày thuê - Ngày trả: </td>
                        <td><%="[" + Constants.convertTime(ngayThue) + "] đến [" + Constants.convertTime(ngayTra) + "]"%></td>
                    </tr>
                <td>Tiền cọc:</td>
                <form action="HopDongController" method="post">
                    <td>Nhập số tiền: <input type="input" name="tiencoc" value=<%=tienCoc%>><br>
                        <br>Loại tiền: <input type="input" name="loaitien" value=<%=loaiTien%>><br>
                        <br> <input type="submit" value="Lưu tiền cọc">
                        <input type="hidden" value="savemoney" name="btn">
                    </td>
                </form>
                </tr>
                </tr>
                <td>Tài sản đảm bảo:</td>
                <td>
                    <% if (listTaiSanDaChon != null) {
                            for (String ts : listTaiSanDaChon) {
                                String tenTs = tsDAO.getTaiSanByID(ts).getTenTaiSan();%>
                    <%=tenTs%><br><br>

                    <%
                            }
                        }%>


                    <form action="HopDongController" method="post">
                        <select name="dropTaiSan"  class="input-xlarge">
                            <% if (!listTaiSan.isEmpty())
                                    for (TaiSan ts : listTaiSan) {%>
                            <option value=<%=ts.getId()%>> <%=ts.getTenTaiSan()%> </option>
                            <%}%>
                        </select><input type="submit" value="Thêm" />   
                        <input type="hidden" value="addTaiSan" name="btn" />  
                    </form>

                </td>
                </tr>
                </tbody>
            </table>
            <form action="HopDongController" method="post" >
                <input type="hidden" value="create" name="btn" />
                <input type="submit" value="Tạo hợp đồng" />
            </form>

        </div>
        <jsp:include page="base/footer.jsp"></jsp:include>
    </body>
</html>
