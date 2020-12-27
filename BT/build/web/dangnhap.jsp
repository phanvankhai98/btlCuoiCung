<%-- 
    Document   : dangnhapjsp
    Created on : Dec 12, 2020, 4:53:12 PM
    Author     : pvkha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/login.css"/>

    </head>
    <body>
        <div class="view">
            <div class="login">
                <h2>Nhân viên đăng nhập</h2>
                <form action="LoginControl" method="post">
                    <input type ="text" name="username" placeholder="username" />
                    <input type ="password" name="password" placeholder="password"/>
                    <input type="submit" value="login"/>
                </form>
            </div>
        </div>
    </body>
</html>
