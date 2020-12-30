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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ThanhVien;

@WebServlet("/api/khach-hang")
public class KhachHangController extends HttpServlet {

    private Gson gson;
    private ThanhVienDAO thanhVienDAO;
    private List<ThanhVien> list;

    public KhachHangController() {
        gson = new Gson();
        thanhVienDAO = new ThanhVienDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        list = new ArrayList<>();
        list.addAll(thanhVienDAO.getAllKhachHang());
        String json = gson.toJson(list);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

}
