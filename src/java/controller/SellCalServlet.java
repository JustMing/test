/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CatagoriesDAO;
import dal.SellDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.History;
import model.Sell;
import model.Catagories;

/**
 *
 * @author ASUS
 */
public class SellCalServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SellCalServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SellCalServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        double total = 0;
        HttpSession session = request.getSession();
        List<Sell> sl = (List<Sell>)session.getAttribute("sellData");
        CatagoriesDAO cdb = new CatagoriesDAO();
        SellDAO sdb = new SellDAO();
        for(Sell s : sl){
            double totalPrice = s.getPrice() * s.getTotalAmount();
            total += totalPrice;
            Catagories old_cata = cdb.getCata(s.getName(), s.getOwner());
            History h = new History(
                    s.getOwner(),
                    s.getEmpName(),
                    s.getName(),
                    s.getTotalAmount(),
                    s.getPrice(),
                    totalPrice
            );
            Catagories c = new Catagories(
                    s.getOwner(),
                    s.getName(),
                    s.getPrice(),
                    old_cata.getTotalAmount()- s.getTotalAmount()
            );
            sdb.insertHis(h);
            cdb.updateAmount(c);
        }
        request.setAttribute("pay", total);
        request.getRequestDispatcher("jsp/sell.jsp").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
