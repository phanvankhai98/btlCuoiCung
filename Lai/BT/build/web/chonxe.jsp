<%-- 
    Document   : chonxe
    Created on : Jan 3, 2021, 12:03:07 AM
    Author     : pvkha
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="dao.xe.XeDAO"%>
<%@page import="dao.xe.XeDAO"%>
<%@page import="model.Xe"%>
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
        <%
            Date cur = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String strDate = dateFormat.format(cur);
            session = request.getSession();
            List<String> listIDXe = (List<String>) session.getAttribute("listIDXe");
        %>
        <jsp:include page="base/header.jsp"></jsp:include>
            <form action="ChonXeController" method="post">
                <table class="search-xe" >
                    <tr>
                        <td >
                            <h4>Ngày thuê:</h4>
                            <input type="date" name="begin" 
                                   placeholder="dd-mm-yyyy" value=""
                                   min="1997-01-01" max="2030-12-31"> 
                        </td>
                        <td>
                            <h4>Ngày trả:</h4>
                            <input type="date" name="end" 
                                   placeholder="dd-mm-yyyy" value=""
                                   min="1997-01-01" max="2030-12-31"> 
                        </td>
                    </tr>
                    <tr>
                        <td >
                            <input  type="hidden" value="search" name="btn">
                            <input class="btn btn-primary " type="submit" value="Tìm xe" >
                        </td>
                    </tr>
                    <tr>
                        <td >
                            <input  type="hidden" value="continue" name="btn">
                            <input class="btn btn-success " type="submit" value="Tiếp tục" >
                        </td>
                    </tr>
                </table>
            </form>
        <%
            ServletContext sc = getServletContext();
            XeDAO xeDAO = new XeDAO();
            List<Xe> listXe;
            listXe = (List) sc.getAttribute("listXe");
            if (listXe == null) {
                listXe = xeDAO.getAll();
            }
            if (!listXe.isEmpty()) {
        %>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Tên xe</th>
                    <th>Dòng xe</th>
                    <th>Hãng xe</th>
                    <th>Mô tả</th>
                    <th>Chọn</th>
                </tr>
            </thead>
            <%
                for (Xe xe : listXe) {
            %>
            <td><%=xe.getTenXe()%></td>
            <td><%=xe.getDongXe()%></td>
            <td><%=xe.getHangXe()%></td>
            <td><%=xe.getMoTa()%></td>
            <% if (listIDXe!=null && listIDXe.contains(xe.getId() + "")) {%>
            <td>
                <form action="ChonXeController" method="post">
                    <input type="hidden" value="<%=xe.getId()%>" name="btnxe">
                    <input class="btn-danger btn" type="submit" value="Xoá " >
                </form>
            </td>
            <%} else {%>
            <td>
                <form action="ChonXeController" method="post">
                    <input type="hidden" value="<%=xe.getId()%>" name="btnxe">
                    <input class="btn-primary btn " type="submit" value="Chọn" >
                </form>
            </td>
            <%}%>
            <%}%>
        </table>
        <%}%>
        <jsp:include page="base/footer.jsp"></jsp:include>
    </body>
</html>
