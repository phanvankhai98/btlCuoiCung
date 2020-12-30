<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>
    <jsp:include page="base/header.jsp"></jsp:include>

    <body class="container">
        <h1>Thêm hợp đồng</h1>
        <form action="addContract" method="post">
            <table style="with: 50%">
                <tr>
                    <td>Tên hợp đồng</td>
                    <td><input id="contract-name" type="text" name="contract-name" /></td>
                </tr>
                <tr>
                    <td>Xe thuê</td>
                <select>
                    <option></option>
                </select>
                </tr>
                <tr>
                    <td>Ngày thuê</td>
                    <td><input id="fullName" type="text" name="fullName" /></td>
                </tr>
                <tr>
                    <td>Ngày trả</td>
                    <td><input id="age" type="text" name="age" /></td>
                </tr>
            </table>
            <input type="submit" value="submit" name="Thêm hợp đồng" />
            <input type="button" id="btn-back" name="Quay lại" />
        </form>
    </body>
    <jsp:include page="base/footer.jsp"></jsp:include>

    </html>