/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.hopdong.HopDongDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.HopDong;

/**
 *
 * @author pvkha
 */
@WebServlet(name = "HopDongController", urlPatterns = {"/HopDongController"})
public class HopDongController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        String url = "/hopdong.jsp";
        String btn = request.getParameter("btn");
        HttpSession session = request.getSession();

        if (btn != null) {
            if (btn.equals("savemoney")) {
                String tienCoc = request.getParameter("tiencoc");
                String loaiTien = request.getParameter("loaitien");
                session.setAttribute("tiencoc", tienCoc);
                session.setAttribute("loaitien", loaiTien);

            } else if (btn.equals("addTaiSan")) {
                String taiSan = request.getParameter("dropTaiSan");

                List<String> listTaiSan;
                listTaiSan = (List<String>) session.getAttribute("taisan");
                if (listTaiSan == null) {
                    listTaiSan = new ArrayList<>();
                }
                if (taiSan != null && !listTaiSan.contains(taiSan)) {
                    listTaiSan.add(taiSan);
                }
                session.setAttribute("taisan", listTaiSan);
            } else if (btn.equals("create")) {
                List<String> listTaiSan;
                List<String> listXe;
                listTaiSan = (List<String>) session.getAttribute("taisan");
                listXe = (List<String>) session.getAttribute("listIDXe");
                String tienCoc =(String) session.getAttribute("tiencoc");
                String loaiTien = (String)session.getAttribute("loaitien");
                String idKhachHang = (String) session.getAttribute("idKhachHang");
                String ngayThue = (String) session.getAttribute("ngayThue");
                String ngayTra = (String) session.getAttribute("ngayTra");
                HopDongDAO hdDAO = new HopDongDAO();
                HopDong hd = new HopDong(1, "Thue Xe", "Thue Xe", Double.parseDouble(tienCoc.replace(".0", "")), loaiTien,
                        ngayThue, ngayTra, Integer.parseInt(idKhachHang));
                boolean kq = hdDAO.addHopDong(hd, listXe, listTaiSan);
                if (kq) {
                    url = "/trangchu.jsp";
                }
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
