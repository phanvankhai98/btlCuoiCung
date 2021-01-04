/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.xe.XeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Xe;

/**
 *
 * @author pvkha
 */
@WebServlet(name = "ChonXeController", urlPatterns = {"/ChonXeController"})
public class ChonXeController extends HttpServlet {

    XeDAO xeDAO;

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
        xeDAO = new XeDAO();
        String url = "/chonxe.jsp";

        String pass = request.getParameter("btn");
        String idXe = request.getParameter("btnxe");
        if (pass != null && pass.equals("search")) {
            try {
                String ngayThue = request.getParameter("begin");
                String ngayTra = request.getParameter("end");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                if (!ngayThue.isEmpty() || !ngayTra.isEmpty()) {
                    Date dateThue = format.parse(ngayThue);
                    Date dateTra = format.parse(ngayTra);
                    int a = (int) (dateThue.getTime() / 10000);
                    int b = (int) (dateTra.getTime() / 10000);

                    List<Xe> list = xeDAO.timXeTheoNgay(a, b);
                    ServletContext sc = getServletContext();
                    sc.setAttribute("listXe", list);
                }
            } catch (ParseException ex) {
                Logger.getLogger(ChonXeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (idXe != null) {
            HttpSession session = request.getSession();
            List<String> listXe = (List<String>) session.getAttribute("listIDXe");
            if (listXe == null) {
                listXe = new ArrayList<String>();
                listXe.add(idXe);
            } else {
                if (listXe.contains(idXe)){
                    listXe.remove(idXe);
                }else{
                    listXe.add(idXe);
                }
            }
            session.setAttribute("listIDXe", listXe);
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
