/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SL.BLL;

import com.SL.DAO.DatabaseHandler;
import com.SL.ENTITY.Ladder;
import com.SL.ENTITY.Snake;
import com.SL.PLL.DisplayHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kalyan Kasyap
 */
public class GameController extends HttpServlet {

    DisplayHandler dh = null;
    DatabaseHandler dbh = null;
    static int dieValue;
    String contextPath = null;
    Snake snake = null;
    Ladder ladder = null;
    HttpSession session = null;
    String playerName = "";
    int playerCount = 0;

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
        contextPath = request.getContextPath();
        session = request.getSession(true);
        playerName = session.getAttribute("USERNAME").toString();
        try {
            try {
                dbh = new DatabaseHandler();
                dh = new DisplayHandler();
            } catch (SQLException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
            snake = new Snake();
            ladder = new Ladder();
            String boardName = request.getParameter("boardName");
            dieValue = rollDie();
            playerCount = dbh.readPlayerCount(playerName);

            if ((playerCount + dieValue) == 100) {
                playerCount = playerCount + dieValue;
                dbh.updatePlayerCount(playerCount, playerName);
                try {
                    dh.displayGameDataPage(request, response, contextPath, boardName, playerCount, dieValue);
                } catch (Exception ex) {
                    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ((playerCount + dieValue) > 100) {
                try {
                    updatePlayerStatus();
                    try {
                        dh.displayGameDataPage(request, response, contextPath, boardName, playerCount, dieValue);
                    } catch (Exception ex) {
                        Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ((dieValue == 6 || dieValue == 4)) {
                playerCount = playerCount + dieValue;
                playerCount = snake.checkSnakeHead(playerCount);
                playerCount = ladder.checkLadderFoot(playerCount);
                dbh.updatePlayerCount(playerCount, playerName);
                try {
                    dh.displayGameDataPage(request, response, contextPath, boardName, playerCount, dieValue);
                } catch (Exception ex) {
                    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    updatePlayerStatus();
                    playerCount = playerCount + dieValue;
                    playerCount = snake.checkSnakeHead(playerCount);
                    playerCount = ladder.checkLadderFoot(playerCount);
                    dbh.updatePlayerCount(playerCount, playerName);
                    try {
                        dh.displayGameDataPage(request, response, contextPath, boardName, playerCount, dieValue);
                    } catch (Exception ex) {
                        Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } finally {
            out.close();
        }
    }

    public int rollDie() {
        Random rand = new Random();
        int randNumber = rand.nextInt(6) + 1;
        return (randNumber);
    }

    public void updatePlayerStatus() throws SQLException, ClassNotFoundException {
        dbh.updatePlayerStatus();
    }
}
