<%-- 
    Document   : login
    Created on : Mar 6, 2013, 1:21:45 PM
    Author     : Kalyan Kasyap
--%>

<%@page contentType="text/html" import="com.SL.BLL.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>        
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="script/login.js"></script>	
        <script type="text/javascript" src="script/jquery.js"></script>
        <script type='text/javascript' src="script/jquery.autocomplete.js"></script>
        <link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css"/>
        <script type="text/javascript">
            $().ready(function() {
                $("#username").autocomplete("usernames.jsp", {
                    width: 211,
                    matchContains: true,
                    selectFirst: false
                });
            });
        </script>
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

                <form action="DataController" id="regForm" class="regForm" method="get" onSubmit="return checkLogin();">
                    <fieldset class="loginFieldset">
                        <legend class="legendFont">Sign In</legend>
                        <table>
                            <tr><td class="formtr">User Name<font color="red">*</font></td><td class="formtr"><input type="text" size="30" name="username" id="username" placeholder="Enter User Name"></td></tr>
                            <tr><td class="formtr">Password<font color="red">*</font></td><td class="formtr"><input type="password" size="30" name="password" id="password" placeholder="Enter Password"></td></tr>
                            <tr><td></td><td></td></tr><tr><td></td><td></td></tr>
                            <tr><td><input type="submit" size="30" name="loginBtn" value="Submit" id="subBtn" class="button"></td>
                                <td><a href="forgotPassword.jsp" id="login" class="forgotPwd">Forgot your password?</a>
                                </td>
                            </tr>
                        </table>
                        <%
                            if (request.getParameter("err") != null) {
                        %>
                        <center><font color="red"><h2>Invalid Login Credentials</h2></font></center>
                            <%                        }
                            %>   
                    </fieldset>
                </form>                    
            </div>
        </div>
    </body>
</html>