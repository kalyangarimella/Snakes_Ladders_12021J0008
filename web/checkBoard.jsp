<%-- 
    Document   : checkBoard
    Created on : Mar 11, 2013, 6:02:06 PM
    Author     : Kalyan Kasyap
--%>

<%@page import="com.SL.PLL.DisplayHandler"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.SL.DAO.DatabaseHandler"%>
<%@page contentType="text/html" import="com.SL.BLL.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Snakes and Ladders Board</title>        
        <meta http-equiv="refresh" content="5">          
        <link rel="stylesheet" type="text/css" href="css/style.css">     
        <script>
            function start(){
                document.location.href="/Snakes_Ladders_12021J0008/GameController";
            }
        </script>
    </head>
    <body bgcolor="ghostWhite">            
        <%
            DatabaseHandler dbh = new DatabaseHandler();
            DisplayHandler dh = new DisplayHandler();
            String boardName = request.getParameter("boardName");
            int maxNoPlayers = dbh.readMaxNoPlayers(boardName);
            int joinNoPlayers = dbh.readJoinNoPlayers(boardName);
            String joinedFirst = dbh.readJoinedFirst(boardName);
            session.setAttribute("joinedFirst", joinedFirst);
            session.setAttribute("maxNoPlayers", maxNoPlayers);
        %>

        <div class="root">
            <div class="siteName">
                <p class="websiteName">Snakes and Ladders Game</p>
                <p class="tagLine">A classic online board game and it's fun!</p>
            </div>
            <div id="content" class="content">

                <%
                    if (maxNoPlayers == joinNoPlayers) {
                        String contextPath = request.getContextPath();
                        dh.displayGameBoardPage(request, response, contextPath, boardName);
                    } else {
                %>
                <br><br><br>
                <center>
                    <h1>    
                        <font color="red">Waiting for Players to Join</font><br>  
                        <font color="red">Players Joined: <%=joinNoPlayers%></font><br>
                        <font color="red">Max No of Players: <%=maxNoPlayers%> </font>
                    </h1>
                    <br>
                    <img src="images/loading.gif" alt="Loding" height=200 class="loading">
                </center>
                <%                    }
                %>
            </div>
        </div>
    </body>
</html>