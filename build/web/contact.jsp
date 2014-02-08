<%-- 
    Document   : contact
    Created on : Mar 6, 2013, 1:19:55 PM
    Author     : Kalyan Kasyap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Contact us</title>
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
                <div id="contactContent" class="contactContent">

                    <img src="images/MSIT.gif" alt="MSIT Logo"><br>
                    <img src="images/LIST.gif" alt="List of Centers"><br><br>
                    <p class="instContent">
                        <font color="red">For Details Contact:</font><br>
                        <font color="red">Mailing Address</font><br>                                        
                        Dean, Consortium of Institutions of Higher Learning<br>
                        IIIT Campus, Gachibowli, Hyderabad - 500032<br>
                        Phones: 040-23001970, 040-65881971<br>
                        Mobile: +91-7799834583, +91-7799834585<br>
                        Email: enquiries2013@msitprogram.net<br>
                        http://www.msitprogram.net
                    </p>
                </div>
            </div>

        </div>

    </body>
</html>