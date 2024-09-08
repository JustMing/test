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
import model.Account;
import model.Catagories;
import model.Employee;
import model.History;

/**
 *
 * @author ASUS
 */
public class RevenueServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RevenueServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RevenueServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        double lost = 0;
        double total = 0;
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        Employee e = (Employee) session.getAttribute("emp");
        session.setAttribute("used", "notUsed");
        SellDAO sdb = new SellDAO();
        CatagoriesDAO cdb = new CatagoriesDAO();
        String used = (String) session.getAttribute("used");
        if (a != null) {
            String owner = a.getUsername();
            String empName = "";
            List<History> hl = sdb.sellHistory(owner);
            for (History h : hl) {
                total += h.getTotalPrice();
            }
            List<Catagories> cl = cdb.getAllCata(owner);
            for (Catagories c : cl) {
                lost += c.getPrice() * c.getTotalAmount();
            }
            String lost2 = String.format("%.2f", lost);
            String total2 = String.format("%.2f", total);
            String stonk = String.format("%.2f", total - lost);
            request.setAttribute("getMoney", total2);
            request.setAttribute("stonkMoney", stonk);
            request.setAttribute("lostMoney", lost2);
            session.setAttribute("hisData", hl);
            if (used.equals("notUsed")) {
                sdb.refresh(owner, empName);
            }
            request.getRequestDispatcher("jsp/revenue.jsp").forward(request, response);
        }
        if (e != null) {
            String empName = e.getUsername();
            String owner = (String) session.getAttribute("owner");
            List<History> hl = sdb.sellHistory(owner);
            for (History h : hl) {
                total += h.getTotalPrice();
            }
            List<Catagories> cl = cdb.getAllCata(owner);
            for (Catagories c : cl) {
                lost += (c.getPrice() * c.getTotalAmount());
            }
            String lost2 = String.format("%.2f", lost);
            String total2 = String.format("%.2f", total);
            String stonk = String.format("%.2f", total - lost);
            request.setAttribute("getMoney", total2);
            request.setAttribute("stonkMoney", stonk);
            request.setAttribute("lostMoney", lost2);
            request.setAttribute("hisData", hl);
            if (used.equals("notUsed")) {
                sdb.refresh(owner, empName);
            }
            request.getRequestDispatcher("jsp/revenue.jsp").forward(request, response);
        }
        if (e == null || a == null) {
            PrintWriter out = response.getWriter();
            out.print("Access Denied");
        }
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
