/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs345.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "AdvancedSearchServlet", urlPatterns = {"/AdvancedSearchServlet"})
public class AdvancedSearchServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdvancedSearchServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdvancedSearchServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */


            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdvancedSearchServlet</title>");
            out.println("<link rel='stylesheet' href='style.css' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>"
                    + "<div id='header'><div id='logo'><img src='img/logo.png' /></div>"
                    + "<div id='user'>"
                    + "<table id='loginfields'>"
                    + "<tr><td>Username</td><td>Password</td></tr>"
                    + "<tr><td><input type='text' /></td><td><input type='password' /></td></tr>"
                    + "<tr><td></td><td><a id='forgotpw' href='#'>Forgot password?</a></td></tr>"
                    + "</table>"
                    + "<table id='loginbuttons'>"
                    + "<tr><td><a href='#'>Register</a></td><td><a href='#'>Sign-In</a></td></tr>"
                    + "</table>"
                    + "</div></div>"
                    + "<div id='nav'>"
                    + "<ul class='leftcolumn'>"
                    + "<li><a href='#'>Home</a></li>"
                    + "<li><a href='#'>About</a></li>"
                    + "<li><a href='#'>Browse</a></li>"
                    + "<li><a href='#'>Popular</a></li>"
                    + "<li><a href='#'>New</a></li>"
                    + "<li><a href=" + request.getContextPath()
                    + "/search.jsp>Search</a></li>"
                    + "</ul>"
                    + "<ul class='rightcolumn'>"
                    + "<li><a href='#' id='cartlink'>My Cart (0)</a></li>"
                    + "<li><a href='#'>Checkout</a></li>"
                    + "</ul>"
                    + "</div>"
                    + "</div>");
            out.println("<h2 style='padding-left:35%'> Advanced Searching product....</h2><br><br>");

            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                /* Database Connection Code Start*/
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://130.255.190.8:3306/hcpltech_fruit", "hcpltech_fruit", "hcpltech_fruit");
                /* Database Connection Code End*/

                /* Fetch Product details from database table according to parameter*/
                stmt = con.createStatement();
                String st1 = request.getParameter("Product_Name");
                String st2 = request.getParameter("Product_Price_Range").toString();
                String st3 = request.getParameter("Product_qty").toString();

                String search_st = "%" + st1 + "%";
                if (st3.equals("")) {
                    st3 = "0";
                }
                if (st2.equals("Select Range")) {
                    rs = stmt.executeQuery("SELECT * FROM product where item_name like '" + search_st + "' and qty >= '" + st3 + "'");
                } else if (st2.equals("< $10")) {
                    rs = stmt.executeQuery("SELECT * FROM product where item_name like '" + search_st + "' and price <= 10 and qty >= '" + st3 + "'");
                } else if (st2.equals("$10 - $25")) {
                    rs = stmt.executeQuery("SELECT * FROM product where item_name like '" + search_st + "' and price > 10 and price <= 25 and qty >= '" + st3 + "'");
                } else if (st2.equals("$25 - $50")) {
                    rs = stmt.executeQuery("SELECT * FROM product where item_name like '" + search_st + "' and price > 25 and price <= 50 and qty >= '" + st3 + "'");
                } else if (st2.equals("$50 - $100")) {
                    rs = stmt.executeQuery("SELECT * FROM product where item_name like '" + search_st + "' and price > 50 and price <= 100 and qty >= '" + st3 + "'");
                } else if (st2.equals("> $100")) {
                    rs = stmt.executeQuery("SELECT * FROM product where item_name like '" + search_st + "' and price > 100 and qty >= '" + st3 + "'");
                }

                // System.out.println("Keyword-->" + search_st);
                // rs = stmt.executeQuery("SELECT slno,iten_name,item_id,price,qty FROM product where item_name like '" + search_st + "'");
                // rs = stmt.executeQuery("SELECT * FROM product where item_name like '" + search_st + "' and price");

                out.print("<div style='text-align:center; padding-left:35%'>");
                out.print("<table style='width:400px;' align = 'center'>");
                out.print("<tr>");
                out.print("<td style='width:80px;'>");
                out.print("SL NO");
                out.print("</td>");
                out.print("<td style='width:160px;' >");
                out.print("Product Name");
                out.print("</td>");
                out.print("<td style='width:80px;'>");
                out.print("Quantity");
                out.print("</td>");
                out.print("<td style='width:80px;'>");
                out.print("Price");
                out.print("</td>");
                out.print("</tr>");
                // displaying records
                while (rs.next()) {

                    out.print("<tr>");
                    out.print("<td style='width:80px;'>");
                    out.print(rs.getObject(1).toString());
                    out.print("</td>");
                    out.print("<td style='width:160px;' >");
                    out.print(rs.getObject(2).toString());
                    out.print("</td>");
                    out.print("<td style='width:80px;'>");
                    out.print(rs.getObject(3).toString());
                    out.print("</td>");
                    out.print("<td style='width:80px;'>");
                    out.print(rs.getObject(4).toString());
                    out.print("</td>");
                    out.print("</tr>");



                }
                out.print("</table>");

                out.println("<a href=" + request.getContextPath()
                        + "/search.jsp>Back to Search</a>");
                out.print("</div>");
            } catch (SQLException e) {
                throw new ServletException("Servlet Could not display records.", e);
            } catch (ClassNotFoundException e) {
                throw new ServletException("JDBC Driver not found.", e);
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                        rs = null;
                    }
                    if (stmt != null) {
                        stmt.close();
                        stmt = null;
                    }
                    if (con != null) {
                        con.close();
                        con = null;
                    }
                } catch (SQLException e) {
                }
            }



            out.println("<br><br><br><br><br><br><br><br><div id='footer'>&copy; Copyright 2012 SUNY Binghamton Food Co-Op. All Rights Reserved.</div>");
            out.println("</body>");
            out.println("</html>");



        } finally {
            out.close();
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
        processRequest(request, response);
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
