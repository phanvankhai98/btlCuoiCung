<%-- 
    Document   : header
    Created on : Dec 26, 2020, 12:57:51 AM
    Author     : pvkha
--%>
<%@page import="constant.Constants"%>
<%@page import="model.ThanhVien"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Web thuê xe</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
    <link rel="stylesheet" type="text/css" href="css/css.css"/>
</head>
<nav class="navbar navbar-inverse">
    <%
        ThanhVien tv = (ThanhVien) session.getAttribute("user");
    %>
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">THUÊ XE</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Page 1-1</a></li>
                    <li><a href="#">Page 1-2</a></li>
                    <li><a href="#">Page 1-3</a></li>
                </ul>
            </li>
            <li><a href="#">Page 2</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <% String username = "";
                Cookie c[] = request.getCookies();
                if (c.length != 0) {
                    username += c[0].getValue();
                } else {
                }
            %>
            <li><a href="#"><span class="glyphicon glyphicon-user">Xin chào <%= username%></span></a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in" id="logout"></span> Logout</a></li>
        </ul>
    </div>
</nav>