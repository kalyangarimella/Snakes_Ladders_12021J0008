<%-- 
    Document   : instructions
    Created on : Mar 6, 2013, 12:51:44 PM
    Author     : Kalyan Kasyap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Game Instructions</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">

    </head>   
    <body bgcolor="ghostWhite">
        <div class="root">
            <div class="siteName">
                <p class="websiteName">Snakes and Ladders Game</p>
                <p class="tagLine">A classic online board game and it's fun!</p>
            </div>
            <%
                if (session.getAttribute("USERNAME") != null) {
            %>
            <div class="menu">
                <a href="index.jsp" id="home" class="home">Home</a>
                <a href="instructions.jsp" id="instructions" class="instructions">Instructions</a>
                <a href="registration.jsp" id="registration" class="registration">Create an Account</a>
                <a href="newGame.jsp" id="createGame" class="createGame">Create Game</a>			
                <a href="join.jsp" id="join" class="join">Join Game</a>
                <a href="contact.jsp" id="contact" class="contact">Contact Us</a>
                <a href="logout.jsp" id="logout" class="login">Logout</a>
            </div>
            <%            } else {
            %>    
            <div class="menu">
                <a href="index.jsp" id="home" class="home">Home</a>
                <a href="instructions.jsp" id="instructions" class="instructions">Instructions</a>
                <a href="registration.jsp" id="registration" class="registration">Create an Account</a>
                <a href="newGame.jsp" id="createGame" class="createGame">Create Game</a>			
                <a href="join.jsp" id="join" class="join">Join Game</a>
                <a href="contact.jsp" id="contact" class="contact">Contact Us</a>
                <a href="login.jsp" id="login" class="login">Sign in</a>
            </div>
            <%                }
            %>
            <div id="content" class="content">
                <fieldset class="insFieldset">
                    <legend class="legendFont">Instructions for the game</legend>

                    <p class="instContent">
                        1. The aim of the game is to be the first player to reach the end by moving across the board from square 1 to square 100. 
                        <br>2. You will travel the board from base to top, right, then left and so on.<br>
                        3. The first player to roll 1 can enter the board (sometimes it is 6). 
                        <br>4. Each subsequent player must also throw a 1 (or 6) to enter the board. 
                        <br>5. The dice must be rolled again to show the number of squares that the player entering the board may move initially. 
                        <br>6. Place the marker on the appropriate square.
                        <br>7. Each player may only roll once.
                        <br>8. You each take a go. 
                        <br>9. The person with the highest amount starts first. 
                        <br>10. The person with the second highest goes 2nd and so on. 
                        <br>11. Do Not Move the Counter.
                        <br>
                        12. The first player to square 100 is the winner but you must have the correct number on the dice to land on the 100 mark.
                    </p>   
                </fieldset> 
            </div>
        </div>    
    </body>        
</html>
