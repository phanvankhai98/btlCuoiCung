/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.khachhang.KhachHangDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DiaChi;
import model.HoTen;
import model.Nguoi;

/**
 *
 * @author pvkha
 */
@WebServlet(name = "ThemKhachHangController", urlPatterns = {"/ThemKhachHangController"})
public class ThemKhachHangController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    KhachHangDAO khDAO;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
   
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String url = "/themmoikhachhang.jsp";
        khDAO = new KhachHangDAO();
        String pass = request.getParameter("id");
        if (pass != null && pass.equals("themkhachhang")) {
            String hoVaTen = request.getParameter("hoten").trim();
            String[] ten = hoVaTen.split(" ");
            HoTen hoTen = new HoTen(ten[0], ten[ten.length - 1], ten[1]);
            DiaChi diaChi = new DiaChi(request.getParameter("sonha").trim(), request.getParameter("xompho").trim(),
                    request.getParameter("xahuyen").trim(), request.getParameter("tinhtp").trim());
            String email = request.getParameter("email").trim();
            String sdt = request.getParameter("sdt").trim();
            String ngaySinh = request.getParameter("ngaysinh").trim();
            String ghiChu = request.getParameter("ghichu").trim();

            Nguoi ng = new Nguoi(hoTen, diaChi, sdt,
                    email, ngaySinh, ghiChu);
            boolean kq = khDAO.themKhachHang(ng);
            if (kq) {
                url = "/chonkhachhang.jsp";
                pass = null;
            }
        }

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
