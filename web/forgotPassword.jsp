<%-- 
    Document   : forgotPassword
    Created on : Mar 6, 2013, 1:22:47 PM
    Author     : Kalyan Kasyap
--%>

<%@page contentType="text/html" import="com.SL.BLL.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Forgot Password</title>        
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

                <form action="DataController" id="regForm" class="regForm" method="post">
                    <fieldset class="regFieldset">
                        <legend class="legendFont">Forgot Password</legend>
                        <table>
                            <tr><td class="formtr">Username<font color="red">*</font></td><td class="formtr"><input type="text" size="30" name="userName" id="userName" placeholder="Enter User Name" required="required"></td></tr>
                            <tr><td class="formtr">Security Question</td>
                                <td class="formtr">
                                    <select name="security" id="security">
                                        <option name="phone" value="phone">What's Your Phone Number</option>
                                        <option name="color" value="color">What's Your Favorite Color</option>                                                    
                                        <option name="hobby" value="hobby">What's Your Favorite Hobby</option>
                                        <option name="destination" value="destination">What's Your Favorite Destination</option>
                                    </select>        
                                <td>
                            </tr>
                            <tr><td>Answer to Security Question<font color="red">*</font>:</td><td><input type="text" size="30" name="ans" id="ans" placeholder="Answer Security Question" required="required"></td></tr>
                            <tr><td></td><td></td></tr>
                            <tr><td><input type="submit" size="30" name="forgotBtn" value="Submit" id="subBtn" class="button"></td><td></td></tr>                                
                        </table>
                        <%
                                        if (request.getParameter("password") != null) {
                                    %>
                            <center><font color="red"><h2>Password: <%=request.getParameter("password")%></h2></font></center>
                                <%                        }
                                %> 
                    </fieldset>
                </form>                    
            </div>
        </div>
    </body>
</html>