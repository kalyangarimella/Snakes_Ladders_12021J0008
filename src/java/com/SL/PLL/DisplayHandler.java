/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SL.PLL;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kalyan Kasyap
 */
public class DisplayHandler extends HttpServlet {

    PrintWriter out = null;
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
        out = response.getWriter();
        try {
        } finally {            
            out.close();
        }
    }
    
    public void displayHomePage(HttpServletRequest request, HttpServletResponse response,String contextPath) throws Exception {
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/index.jsp"));
    }
    
    public void displayLoginPage(HttpServletRequest request, HttpServletResponse response,String contextPath) throws Exception {
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/login.jsp"));
    }
    
    public void displayLoginErrorPage(HttpServletRequest request, HttpServletResponse response,String contextPath) throws Exception {
         response.sendRedirect(response.encodeRedirectURL(contextPath + "/login.jsp?err=1"));
    }
    
    public void displayRegistrationErrorPage(HttpServletRequest request, HttpServletResponse response,String contextPath) throws Exception {        
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/registration.jsp?err=1"));
    }
    
    public void displayUserExistPage(HttpServletRequest request, HttpServletResponse response,String contextPath) throws Exception {
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/registration.jsp?exist=true"));
    }    
    
    public void displayCreateGamePage(HttpServletRequest request, HttpServletResponse response,String contextPath) throws Exception {
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/newGame.jsp"));
    }
    
    public void displayCreateGameErrorPage(HttpServletRequest request, HttpServletResponse response,String contextPath) throws Exception {
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/newGame.jsp?err=1"));
    }
    
    public void displayGameExistPage(HttpServletRequest request, HttpServletResponse response,String contextPath) throws Exception {
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/newGame.jsp?exist=true"));
    }
    
    public void displayCheckBoardPage(HttpServletRequest request, HttpServletResponse response,String contextPath,String boardname) throws Exception {
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/checkBoard.jsp?boardName=" + boardname));
    }
    
    public void displayJoinGameErrorPage(HttpServletRequest request, HttpServletResponse response,String contextPath) throws Exception {
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/join.jsp?err=1"));
    }
    
    public void displayGameBoardPage(HttpServletRequest request, HttpServletResponse response,String contextPath, String boardname) throws Exception {
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/displayBoard.jsp?boardName=" + boardname));
    }
    
    public void displayGameDataPage(HttpServletRequest request, HttpServletResponse response,String contextPath, String boardname,int playerCount,int dieValue) throws Exception {
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/displayBoard.jsp?boardName=" + boardname + "&dieValue=" + playerCount + "&dieVal=" + dieValue));
    }
    
    public void displayGameWinnerPage(HttpServletRequest request, HttpServletResponse response,String contextPath, String username) throws Exception {
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/celebrations.jsp?uname="+username));
    }
    
    public void displayPasswordPage(HttpServletRequest request, HttpServletResponse response,String contextPath, String password) throws Exception {
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/forgotPassword.jsp?password=" + password));
    }
}
