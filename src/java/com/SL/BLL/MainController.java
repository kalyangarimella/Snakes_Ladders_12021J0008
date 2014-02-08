/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SL.BLL;

import com.SL.PLL.DisplayHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kalyan Kasyap
 */
public class MainController extends HttpServlet {
    
    String contextPath = null;
    DisplayHandler dh = null;
    
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            dh = new DisplayHandler();
            try {
                contextPath = request.getContextPath();
                dh.displayHomePage(request, response, contextPath);
            } catch (Exception ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        finally {            
            out.close();
        }
    }

    
}
