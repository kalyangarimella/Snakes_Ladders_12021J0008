/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SL.BLL;

import com.SL.DAO.DatabaseHandler;
import com.SL.ENTITY.Game;
import com.SL.ENTITY.User;
import com.SL.MAIL.SendMail;
import com.SL.PLL.DisplayHandler;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kalyan Kasyap
 */

public class DataController extends HttpServlet {

    DisplayHandler dh = null;
    DatabaseHandler dbh = null;
    String contextPath = null;
    User user = null;
    Game game = null;
    static HttpSession session = null;

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

            // logic to handle registration data

            if (request.getParameter("registerBtn") != null) {
                
                contextPath = request.getContextPath();
                
                /*Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
                request.setCharacterEncoding("UTF-8");
                String ansca = request.getParameter("ansca");
	        
                if (!captcha.isCorrect(ansca)) {
                     dh.displayRegistrationErrorPage(request, response, contextPath);
                }*/
                
                dh = new DisplayHandler();
                
                String firstName = request.getParameter("firstName");
                String userName = request.getParameter("userName");
                String dob = request.getParameter("dob");
                String gender = request.getParameter("radioBtn");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String confirmPwd = request.getParameter("confirmPwd");
                String address = request.getParameter("address");
                String security = request.getParameter("security");
                String answer = request.getParameter("answer");
                String alternative = request.getParameter("alternative");
                String chck = request.getParameter("chck");

                if (firstName == null || firstName.equals("") || userName == null || userName.equals("") || dob == null || dob.equals("") || gender == null || gender.equals("") || email == null || email.equals("") || password == null || password.equals("") || confirmPwd == null || confirmPwd.equals("") || address == null || address.equals("") || security == null || security.equals("") || answer == null || answer.equals("") || alternative == null || alternative.equals("") || chck == null || chck.equals("")) {

                    dh.displayRegistrationErrorPage(request, response, contextPath);

                } else {

                    dbh = new DatabaseHandler();

                    if (dbh.readUserName(userName)) {

                        dh.displayUserExistPage(request, response, contextPath);

                    } else {

                        user = new User();

                        user.setFirstname(firstName);
                        user.setUsername(userName);
                        user.setBirthday(dob);
                        user.setGender(gender);
                        user.setEmail(email);
                        user.setPassword(password);
                        user.setAddress(address);
                        user.setQuestion(security);
                        user.setAnswer(answer);
                        user.setAltemail(alternative);
                        
                        String sub  = "Username = " + userName + " Password = " +password;
                        String from = "kasyapkasyapcse@gmail.com";
                        String pwd  = "ibm08733Gibm";

                        SendMail sendMail = new SendMail(from,pwd,email);
                        sendMail.send("Thanx for registering, ",sub);
        
                        dbh.insertUserDetails(user);

                        dh.displayLoginPage(request, response, contextPath);
                    }
                }
            }

            // logic to handle login data 

            if (request.getParameter("loginBtn") != null) {

                dh = new DisplayHandler();

                contextPath = request.getContextPath();

                String userName = request.getParameter("username");
                String password = request.getParameter("password");

                if (userName == null || userName.equals("") || password == null || password.equals("")) {

                    dh.displayLoginErrorPage(request, response, contextPath);

                } else {

                    dbh = new DatabaseHandler();

                    if (dbh.readLoginDetails(userName, password)) {

                        session = request.getSession();
                        session.setAttribute("USERNAME", userName);
                        dh.displayCreateGamePage(request, response, contextPath);

                    } else {
                        dh.displayLoginErrorPage(request, response, contextPath);
                    }
                }

            }

            // logic to handle new game data

            if (request.getParameter("newGameBtn") != null) {

                dh = new DisplayHandler();

                contextPath = request.getContextPath();

                String userName = request.getParameter("username");
                String boardname = request.getParameter("boardname");
                String password = request.getParameter("password");
                String players = request.getParameter("players");
                String dieColor = request.getParameter("dieColor");

                if (userName == null || userName.equals("") || boardname == null || boardname.equals("") || password == null || password.equals("") || players == null || players.equals("") || dieColor == null || dieColor.equals("")) {
                    dh.displayCreateGameErrorPage(request, response, contextPath);
                } else {
                    dbh = new DatabaseHandler();

                    if (dbh.readBoardName(boardname)) {
                        dh.displayGameExistPage(request, response, contextPath);
                    } else {
                        game = new Game();

                        game.setUserName(userName);
                        game.setBoardName(boardname);
                        game.setBoardPassword(password);
                        game.setNoPlayers(Integer.parseInt(players));
                        game.setPawnColor(dieColor);

                        dbh.insertGameDetails(game);
                        dbh.insertJoinGameDetails(userName, boardname, dieColor);
                        dbh.insertPlayerStatusData(userName, "1", dieColor, boardname, 0);
                        dh.displayCheckBoardPage(request, response, contextPath, boardname);
                    }
                }
            }

            // logic to handle join game data

            if (request.getParameter("joinBtn") != null) {

                dh = new DisplayHandler();

                contextPath = request.getContextPath();

                String userName = request.getParameter("username");
                String boardname = request.getParameter("board");
                String password = request.getParameter("password");
                String dieColor = request.getParameter("dieColor");

                String data[] = boardname.split(";");

                if (userName == null || userName.equals("") || boardname == null || boardname.equals("") || password == null || password.equals("") || dieColor == null || dieColor.equals("")) {
                    dh.displayJoinGameErrorPage(request, response, contextPath);
                } else {
                    dbh = new DatabaseHandler();                  
                    
                    int maxNoPlayers = dbh.readMaxNoPlayers(data[0]);
                    int joinNoPlayers = dbh.readJoinNoPlayers(data[0]);  
                    
                    if(maxNoPlayers==joinNoPlayers){
                        dh.displayJoinGameErrorPage(request, response, contextPath);
                    }
                    else{                        
                        dbh.insertJoinGameDetails(userName, data[0], dieColor);
                        dbh.insertPlayerStatusData(userName, "0", dieColor, data[0], 0);
                        dh.displayCheckBoardPage(request, response, contextPath, data[0]);
                    }
                }
            }
            
            // logic to forgot password
            

            if (request.getParameter("forgotBtn") != null) {

                dh = new DisplayHandler();

                contextPath = request.getContextPath();

                String userName = request.getParameter("userName");
                String security = request.getParameter("security");
                String answer = request.getParameter("ans");

                if (userName == null || userName.equals("") ||  security == null || security.equals("") || answer == null || answer.equals("")) {
                    dh.displayLoginErrorPage(request, response, contextPath);
                } else {
                    dbh = new DatabaseHandler(); 
                    String password = dbh.readUserPassword(userName, security, answer);
                    dh.displayPasswordPage(request, response, contextPath, password);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            out.close();
        }
    }    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

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
