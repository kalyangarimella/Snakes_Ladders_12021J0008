<%-- 
    Document   : newGame
    Created on : Mar 6, 2013, 12:55:41 PM
    Author     : Kalyan Kasyap
--%>

<%@page contentType="text/html" import="com.SL.BLL.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create New Game Page</title>        
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="script/validate.js"></script>
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
            <%
                if (session.getAttribute("USERNAME") != null) {
            %>
            <div id="content" class="content">

                <form action="DataController" id="regForm" class="regForm" method="get" onSubmit="return validate();">
                    <fieldset class="newFieldset">
                        <legend class="legendFont">New Game Details</legend>
                        <table>
                            <tr><td class="formtr">User Name<font color="red">*</font></td><td class="formtr"><input type="text" size="30" name="username" id="username" value="<%=session.getAttribute("USERNAME")!=null?session.getAttribute("USERNAME").toString():""%>" readonly></td></tr>
                            <tr><td class="formtr">Board Name<font color="red">*</font></td><td class="formtr"><input type="text" size="30" name="boardname" id="boardname" placeholder="Enter Board Name"></td></tr>
                            <tr><td class="formtr">Password</td><td class="formtr"><input type="password" size="30" name="password" id="password" placeholder="Enter Password"></td></tr>
                            <tr><td class="formtr">No of Players</td>
                                <td class="formtr">
                                    <select name="players" id="players">
                                        <option value="select">Select</option>	
                                        <option value="1">1</option>
                                        <option value="2">2</option>                                                    
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                    </select>        
                                <td>
                            </tr>

                            <tr><td>Select Pawn Color</td>
                                <td>
                                 <input type="radio" name="dieColor" id="radioBtn1" value="red"> Red <input type="radio" name="dieColor" id="radioBtn2" value="blue"> Blue <input type="radio" name="dieColor" id="radioBtn3" value="green"> Green <input type="radio" name="dieColor" id="radioBtn4" value="black"> Black     
                                <td>
                            </tr>
                            <tr><td></td><td></td></tr><tr><td></td><td></td></tr>
                            <tr><td><input type="submit" size="30" name="newGameBtn" value="Submit" id="subBtn" class="button"></td><td></td></tr>
                        </table>
                    </fieldset>
                </form>                    
            </div>
            <%                } else {
            %>
            <div id="content" class="content">                
                <center><img src="images/grant.jpg" alt="Login" height="250" width="400"></img></center>
            </div>
            <%                }
            %>
        </div>
    </body>
</html>