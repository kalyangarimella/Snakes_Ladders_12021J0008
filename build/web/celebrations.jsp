<%-- 
    Document   : celebrations
    Created on : Mar 13, 2013, 12:27:53 PM
    Author     : Kalyan Kasyap
--%>

<%@page import="com.SL.DAO.DatabaseHandler"%>
<%@page import="com.SL.BLL.DataController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">              
    </head>
    <%!
        DataController dc = new DataController();
        
    %>
    <body bgcolor="ghostWhite">

        <div class="root">

            <div class="siteName">
                <p class="websiteName">Snakes and Ladders Game</p>
                <p class="tagLine">A classic online board game and it's fun!</p>
            </div>
            <div class="menu">
                <a href="index.jsp" id="home" class="home">Home</a>
                <a href="instructions.jsp" id="instructions" class="instructions">Instructions</a>
                <a href="registration.jsp" id="registration" class="registration">Create an Account</a>
                <a href="newGame.jsp" id="createGame" class="createGame">Create Game</a>			
                <a href="join.jsp" id="join" class="join">Join Game</a>
                <a href="contact.jsp" id="contact" class="contact">Contact Us</a>
                <a href="login.jsp" id="login" class="login">Sign in</a>
            </div>
            <div id="content" class="content">
                
                <br><br><br>
                <center>
                    <h1>    
                        <img src="images/winner.gif" width="200" height="200">
                        <br>
                        
                        <img src="images/congos.gif">
                        <h1>
                            <font color="red">                        
                        <%                        
                            out.println(request.getParameter("uname"));
                            Thread.sleep(10000);                                
                            session.invalidate();
                            DatabaseHandler db = new DatabaseHandler();
                            db.deleteGameData();
                        %>
                        
                        </font><br>  
                    </h1>
                </center>
            </div>

        </div>

    </body>
</html>