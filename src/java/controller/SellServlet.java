/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

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
import model.Employee;
import model.Sell;

/**
 *
 * @author ASUS
 */
public class SellServlet extends HttpServlet {

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
            out.println("<title>Servlet SellServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SellServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        Employee e = (Employee) session.getAttribute("emp");
        SellDAO sdb = new SellDAO();
        String used = (String) session.getAttribute("used");
        if (a != null) {
            String owner = a.getUsername();
            String empName = "";
            List<Sell> sl = sdb.sellList(owner, empName);
            session.setAttribute("sellData", sl);
            if (used.equals("notUsed")) {
                sdb.refresh(owner, empName);
            }
            request.getRequestDispatcher("jsp/sell.jsp").forward(request, response);
        }
        if (e != null) {
            String empName = e.getUsername();
            String owner = (String) session.getAttribute("owner");
            List<Sell> sl = sdb.sellList(owner, empName);
            session.setAttribute("sellData", sl);
            if (used.equals("notUsed")) {
                sdb.refresh(owner, empName);
            }
            request.getRequestDispatcher("jsp/sell.jsp").forward(request, response);
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
