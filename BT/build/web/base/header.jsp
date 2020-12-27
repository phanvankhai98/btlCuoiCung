<%-- 
    Document   : header
    Created on : Dec 26, 2020, 12:57:51 AM
    Author     : pvkha
--%>
<%@page import="constant.Constants"%>
<%@page import="model.ThanhVien"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>