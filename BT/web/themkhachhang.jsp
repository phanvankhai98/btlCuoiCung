<%-- 
    Document   : themkhachhang
    Created on : Jan 1, 2021, 10:50:07 PM
    Author     : pvkha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="base/header.jsp"></jsp:include>
        <a class="btn-primary btn">Chọn</a>
        <jsp:include page="base/footer.jsp"></jsp:include>
    </body>
</html>
<script>
    function themKhachHang() {
        var t = $.ajax({
            url: "http://localhost:8080/BT/api/them-khach-hang",
            type: "POST",
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
                `<td id="btn-select" data-id="`+ item.id+`"><a class="btn-primary btn">Chọn</a></td>`;
            })
            $('#body-khach-hang').append(content);
        });
    }
    $(document).ready(function() {
        $('#btn-select').on('click', function() {
            var idSelect = $(this).data('id');
            localStorage.setItem("khachHangSelected", idSelect);
            var url = "chonXe.jsp?id="+idSelect;
            console.log('url: ', url);
            window.location.href= url;
        });
    });

</script>
