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
import model.Account;
import model.Employee;
import model.Sell;

/**
 *
 * @author ASUS
 */
public class SellUpdateServlet extends HttpServlet {

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
            out.println("<title>Servlet SellUpdateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SellUpdateServlet at " + request.getContextPath() + "</h1>");
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
        String name = request.getParameter("name");
        SellDAO sdb = new SellDAO();
        HttpSession session = request.getSession();
        Employee e = (Employee) session.getAttribute("emp");
        if (e != null) {
            String empName = e.getUsername();
            String owner = (String) session.getAttribute("owner");
            Sell s = sdb.sellGood(owner, empName, name);
            request.setAttribute("sellUpdate", s);
            request.getRequestDispatcher("jsp/updateSell.jsp").forward(request, response);
        } else {
            Account a = (Account) session.getAttribute("user");
            String owner = a.getUsername();
            String empName = "";
            Sell s = sdb.sellGood(owner, empName, name);
            request.setAttribute("sellUpdate", s);
            request.getRequestDispatcher("jsp/updateSell.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String price_str = request.getParameter("price");
        String totalAmount_str = request.getParameter("totalAmount");
        String owner = request.getParameter("owner");
        String empName = request.getParameter("empName");
        try {
            double price = Double.parseDouble(price_str);
            int totalAmount = Integer.parseInt(totalAmount_str);
            SellDAO sdb = new SellDAO();
            Sell s = new Sell(owner, empName, name, totalAmount, price);
            sdb.update(s);
            response.sendRedirect("sell");
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Bạn Đã Nhập Sai");
            request.getRequestDispatcher("jsp/updateSell.jsp").forward(request, response);
        }
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
