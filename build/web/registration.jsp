<%-- 
    Document   : registration
    Created on : Mar 6, 2013, 12:54:26 PM
    Author     : Kalyan Kasyap
--%>
<%@page contentType="text/html" import="com.SL.BLL.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration Page</title>        
        <link rel="stylesheet" type="text/css" href="css/style.css">  
        <script type="text/javascript" src="script/registration.js"></script>	        
        <script type="text/javascript" src="script/jquery.js"></script>
        <script type='text/javascript' src="script/jquery.autocomplete.js"></script>
        <link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css"/>
        <script type="text/javascript">
            $().ready(function() {
                $("#userName").autocomplete("usernames.jsp", {
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

                <form action="DataController" name="regForm" id="regForm" class="regForm" method="get" onSubmit="return checkRegistration();">
                    <fieldset class="regFieldset">
                        <legend class="legendFont">Registration Form</legend>
                        <table>
                            <tr><td class="formtr">First Name<font color="red">*</font></td><td class="formtr"><input type="text" size="30" name="firstName" id="firstName" placeholder="Enter Your First Name"></td></tr>
                            <tr><td class="formtr">Choose your username<font color="red">*</font></td><td class="formtr"><input type="text" size="30" name="userName" id="userName" placeholder="Enter User Name">
                                    <%
                                        String req = request.getParameter("exist");

                                        if (req == null || req.equals("")) {
                                            out.println("");
                                        } else {
                                            out.println("<font color=red>Username Exists</font>");
                                        }
                                    %>
                                </td></tr>
                            <tr><td class="formtr">Birthday</td><td class="formtr"><input type="date" name="dob" id="dob"></td></tr>
                            <tr><td class="formtr">Gender</td><td class="formtr"><input type="radio" name="radioBtn" id="radioBtn1" value="male"> Male <input type="radio" name="radioBtn" id="radioBtn2" value="female"> Female</td></tr>
                            <tr><td class="formtr">Your current email address<font color="red">*</font></td><td class="formtr"><input type="email" size="30" name="email" id="email" placeholder="Enter Your Email"></td></tr>
                            <tr><td class="formtr">Create a password<font color="red">*</font></td><td class="formtr"><input type="password" size="30" name="password" id="password" placeholder="Enter Your Password"></td></tr>
                            <tr><td class="formtr">Confirm your password</td><td class="formtr"><input type="password" size="30" name="confirmPwd" id="confirmPwd" placeholder="Confirm Password"></td></tr>
                            <tr><td class="formtr">Address</td><td class="formtr"><textarea rows="2" cols="24" name="address" id="address" placeholder="Enter Your Address"></textarea></td></tr>
                            <tr><td class="formtr">Security Question<font color="red">*</font></td>
                                <td class="formtr">
                                    <select name="security" id="security">
                                        <option value="select">Select</option>	
                                        <option name="phone" value="phone">What's Your Phone Number</option>
                                        <option name="color" value="color">What's Your Favorite Color</option>                                                    
                                        <option name="hobby" value="hobby">What's Your Favorite Hobby</option>
                                        <option name="destination" value="destination">What's Your Favorite Destination</option>
                                    </select>        
                                <td>
                            </tr>
                            <tr><td class="formtr">Answer to Security Question<font color="red">*</font>:</td><td class="formtr"><input type="text" size="30" name="answer" id="answer" placeholder="Answer Security Question"></td></tr>
                            <tr><td class="formtr">Alternative Email:</td><td class="formtr"><input type="email" size="30" name="alternative" id="alternative" placeholder="Enter Alternative Email"></td></tr>
                            <tr><td></td><td></td></tr>
                            <tr><td>
                                    <input type="text" name="ansca" id="ansca" size="7"/>
                                </td><td><input type="checkbox" name="chck" id="chck">I agree to Submit Above Details</td></tr>
                            <tr><td></td><td></td></tr>
                            <tr><td><input type="submit" size="30" name="registerBtn" value="Submit" id="subBtn" class="button"></td><td><input type="reset" size="30" name="resetBtn" value="Reset" id="resetBtn" class="button"></td></tr>                                
                        </table>
                    </fieldset>
                </form>                    
            </div>
        </div>
    </body>
</html>