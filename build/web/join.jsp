<%-- 
    Document   : join
    Created on : Mar 6, 2013, 12:57:05 PM
    Author     : Kalyan Kasyap
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.SL.DAO.DatabaseHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Join Game Page</title>        
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="script/check.js"></script>	


        <script>
        
            function disablePawnColor()
            {
                var boardName = document.getElementById("board").value; 
                var password = document.getElementById("password").value; 
                
                var arr = boardName.split(";");
                
                // comparing passwords
                
                if(arr[1] == password){
                    
                    document.getElementById("radioBtn1").style.visibility="visible";
                    document.getElementById("radioBtn2").style.visibility="visible";
                    document.getElementById("radioBtn3").style.visibility="visible";
                    document.getElementById("radioBtn4").style.visibility="visible";
                    
                    if(document.getElementById("radioBtn1").value==arr[2]){
                        document.getElementById("radioBtn1").style.visibility="hidden";
                    }
                    else if(document.getElementById("radioBtn2").value==arr[2]){
                        document.getElementById("radioBtn2").style.visibility="hidden";
                    }
                    else if(document.getElementById("radioBtn3").value==arr[2]){
                        document.getElementById("radioBtn3").style.visibility="hidden";
                    }
                    else {
                        document.getElementById("radioBtn4").style.visibility="hidden";
                    }
                }
            }
            
            function disableRadios(){
                
                document.getElementById("radioBtn1").style.visibility="hidden";
                document.getElementById("radioBtn2").style.visibility="hidden";
                document.getElementById("radioBtn3").style.visibility="hidden";
                document.getElementById("radioBtn4").style.visibility="hidden";
                
            }
            
        </script>

    </head>

    <body bgcolor="ghostWhite" onload="disableRadios()">
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

                <form action="DataController" id="regForm" class="regForm" name="regForm" method="post" onSubmit="return check();">
                    <fieldset class="newFieldset">
                        <legend class="legendFont">Join Game</legend>
                        <table>
                            <tr><td class="formtr">User Name<font color="red">*</font></td><td class="formtr"><input type="text" size="30" name="username" id="username" value="<%=session.getAttribute("USERNAME") != null ? session.getAttribute("USERNAME").toString() : ""%>" readonly></td></tr>
                                    <%
                                        DatabaseHandler dbh = new DatabaseHandler();
                                        ArrayList<String> boardNames = dbh.readBoardNames();
                                    %>
                            <tr><td class="formtr">Select Board</td>
                                <td class="formtr">
                                    <select name="board" id="board">
                                        <option value="select">Select</option>

                                        <%
                                            for (int i = 0; i < boardNames.size(); i++) {
                                                String val[] = boardNames.get(i).split(";");
                                                out.println("<option name='" + val[0] + "' value='" + boardNames.get(i) + "'>" + val[0] + "</option>");
                                            }
                                        %>

                                    </select>        
                                </td>
                            </tr>
                            <tr><td class="formtr">Password<font color="red">*</font></td><td class="formtr"><input type="password" size="30" name="password" id="password" placeholder="Enter Password" onblur="disablePawnColor()"></td></tr>
                            <tr><td>Select Pawn Color</td>
                                <td>
                                    <input type="radio" name="dieColor" id="radioBtn1" value="red"> Red <input type="radio" name="dieColor" id="radioBtn2" value="blue"> Blue <input type="radio" name="dieColor" id="radioBtn3" value="green"> Green <input type="radio" name="dieColor" id="radioBtn4" value="black"> Black     
                                <td>
                            </tr>
                            <tr><td></td><td></td></tr><tr><td></td><td></td></tr>
                            <tr><td><input type="submit" size="30" name="joinBtn" value="Submit" id="subBtn" class="button"></td>
                                <td>
                                    <%
                                        if (request.getParameter("err") != null) {
                                    %>
                            <center><font color="red"><h2>Sorry, Board is Full</h2></font></center>
                                <%                        }
                                %> 
                            </td>
                            </tr>
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