/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import com.google.gson.Gson;
import dao.thanhvien.ThanhVienDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import static java.util.Collections.list;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DiaChi;
import model.HoTen;
import model.ThanhVien;

/**
 *
 * @author pvkha
 */
@WebServlet("/api/them-khach-hang")
public class ThemKhachHangController extends HttpServlet {

    ThanhVienDAO tvDAO;
    private Gson gson;
    boolean kq;

    public ThemKhachHangController() {
        tvDAO = new ThanhVienDAO();
        gson = new Gson();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ThanhVien tv = new ThanhVien("", "",new HoTen("Khai", "Phan", "Phan"), 0, new DiaChi(), "01222151544",
        "pvkhaicd1998@gmail.com", "1998-02-25", "kkkk");
        kq =  tvDAO.themKhachHang(tv);
        String json = gson.toJson(kq);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }

}
