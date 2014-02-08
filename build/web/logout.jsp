<%-- 
    Document   : logout
    Created on : Mar 7, 2013, 1:12:06 PM
    Author     : Kalyan Kasyap
--%>

<%@page import="com.SL.DAO.DatabaseHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">             
    </head>

    <body bgcolor="ghostWhite">
        <%
            session.invalidate();
            DatabaseHandler db = new DatabaseHandler();
            db.deleteGameData();
        %>
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
                <img src="images/SnakesLadders.png" alt="Snakes and Ladders" class="imgDisp">
            </div>

        </div>

    </body>
</html>