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
    <body class="container">
        <jsp:include page="base/header.jsp"></jsp:include>
            <h2>Danh sách khách hàng</h2>

            <button id="btn-them-kh" class="btn-primary btn">Chọn</button>
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
                    <tr id="body-khach-hang"></tr>
                </tbody>


        </table>
        <jsp:include page="base/footer.jsp"></jsp:include>
    </body>
</html>
<script>
    getListKhachHang();
    function getListKhachHang() {
        var t = $.ajax({
            url: "http://localhost:8080/BT/api/khach-hang",
            type: "GET",
            dataType: "json",
            contentType: "application/json; charset=utf-8"
        });
        var content = '';
        t.done(function(result){
            result.map(item => {
                content +=`<td>`+item.hoten.ho + item.hoten.dem + item.hoten.ten +`</td>`+
                `<td>`+ item.sdt +`</td>`+
                `<td>`+item.diaChi.soNha + item.diaChi.phoXom + `</td>`+
                `<td>` + item.email + `</td>`+
                `<td>`+item.ghiChu +`</td>`+
                `<td  ><a id="btn-select" data-id="`+ item.id+`" class="btn-primary btn">Chọn</a></td>`;
            })
            $('#body-khach-hang').append(content);
        });
    }
    // Tạo 1 sự kiện onclick
    // Gửi request POST qua type submit
    //Sevlet xử lý, tyrar lại dữ liệu GSO
    //
    $(document).ready(function() {
        $('#btn-select').on('click', function() {
            var idSelect = $(this).data('id');
//            localStorage.setItem("khachHangSelected", idSelect);
            var url = "chonxe.jsp?id="+idSelect;
            window.location.href= url;
        });
        $('#btn-them-kh').on('click',function (){
            console.log('oke');
            var url = "themkhachhang.jsp";
            window.location.href= url;
        });
    });
</script>
