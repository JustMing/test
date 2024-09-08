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
import model.Account;
import model.Catagories;
import model.Employee;
import model.Sell;

/**
 *
 * @author ASUS
 */
public class SellAddServlet extends HttpServlet {

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
            out.println("<title>Servlet SellAddServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SellAddServlet at " + request.getContextPath() + "</h1>");
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
        String name = request.getParameter("good");
        if(name == null){
            request.setAttribute("error", "Không Có Hàng");
            request.getRequestDispatcher("sell").forward(request, response);
        }
        HttpSession session = request.getSession();
        Employee e = (Employee) session.getAttribute("emp");
        Account a = (Account) session.getAttribute("user");
        String used = (String) session.getAttribute("used");
        if (used.equals(name)) {
            request.setAttribute("error", "'"+ name + "' Đã Được Thêm");
            request.getRequestDispatcher("sell").forward(request, response);
        } else {
            if (e == null && a == null) {
                PrintWriter out = response.getWriter();
                out.print("Access Denied");
            } else if (e != null) {
                String owner = (String) session.getAttribute("owner");
                CatagoriesDAO cdb = new CatagoriesDAO();
                Catagories c = cdb.getCata(name, owner);
                request.setAttribute("sellName", c.getName());
                request.setAttribute("sellPrice", c.getPrice());
                request.setAttribute("sellAmount", c.getTotalAmount());
                request.getRequestDispatcher("jsp/addGoods.jsp").forward(request, response);
            } else {
                String owner = a.getUsername();
                CatagoriesDAO cdb = new CatagoriesDAO();
                Catagories c = cdb.getCata(name, owner);
                request.setAttribute("sellName", c.getName());
                request.setAttribute("sellPrice", c.getPrice());
                request.setAttribute("sellAmount", c.getTotalAmount());
                request.getRequestDispatcher("jsp/addGoods.jsp").forward(request, response);
            }
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
        HttpSession session = request.getSession();
        String owner = request.getParameter("owner");
        String empName = request.getParameter("empName");
        String name = request.getParameter("name");
        String totalAmount_str = request.getParameter("totalAmount");
        String price_str = request.getParameter("price");
        try {
            int totalAmount = Integer.parseInt(totalAmount_str);
            double price = Double.parseDouble(price_str);
            CatagoriesDAO cdb = new CatagoriesDAO();
            Catagories c = cdb.getCata(name, owner);
            int cataAmount = c.getTotalAmount();
            if (totalAmount > cataAmount) {
                throw new NumberFormatException();
            } else {
                Sell s = new Sell(owner, empName, name, totalAmount, price);
                SellDAO sdb = new SellDAO();
                sdb.insertSell(s);
                session.setAttribute("used", name);
                response.sendRedirect("sell");
            }
        } catch (NumberFormatException e) {
            if (e != null) {
                CatagoriesDAO cdb = new CatagoriesDAO();
                Catagories c = cdb.getCata(name, owner);
                request.setAttribute("sellName", c.getName());
                request.setAttribute("sellPrice", c.getPrice());
                request.setAttribute("sellAmount", c.getTotalAmount());
                request.setAttribute("error", "Bạn Đã Nhập Sai");
                request.getRequestDispatcher("jsp/addGoods.jsp").forward(request, response);
            } else {
                CatagoriesDAO cdb = new CatagoriesDAO();
                Catagories c = cdb.getCata(name, owner);
                request.setAttribute("sellName", c.getName());
                request.setAttribute("sellPrice", c.getPrice());
                request.setAttribute("sellAmount", c.getTotalAmount());
                request.setAttribute("error", "Bạn Đã Nhập Sai");
                request.getRequestDispatcher("jsp/addGoods.jsp").forward(request, response);
            }
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
