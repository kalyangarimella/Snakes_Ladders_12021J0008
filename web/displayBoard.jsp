<%-- 
    Document   : displayBoard
    Created on : Mar 6, 2013, 1:23:40 PM
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
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script>
            function start(boardName){
                document.location.href="/Snakes_Ladders_12021J0008/GameController?boardName="+boardName;
            }
        </script>
    </head>
    <body bgcolor="ghostWhite">            
        <%
            DatabaseHandler dbh = new DatabaseHandler();
            DisplayHandler dh = new DisplayHandler();
            String boardName = request.getParameter("boardName");
            String currentPlayerName = dbh.readActivePlayerStatus();
            ArrayList<String> gameDetails = dbh.readGameData(boardName);
            String contextPath = request.getContextPath();
        %>

        <div class="root">
            <div class="siteName">
                <p class="websiteName">Snakes and Ladders Game</p>
                <p class="tagLine">A classic online board game and it's fun!</p>
            </div>            
            <div id="content" class="content">

                <div class="boardDisp">

                    <table>
                        <tr class="trr">
                            <td id="b100" class="tdd"></td><td id="b99" class="tdd"></td><td id="b98" class="tdd"></td><td id="b97" class="tdd"></td><td id="b96" class="tdd"></td><td id="b95" class="tdd"></td><td id="b94" class="tdd"></td><td id="b93" class="tdd"></td><td id="b92" class="tdd"></td><td id="b91" class="tdd"></td>
                        </tr> <!-- one -->

                        <tr class="trr">
                            <td id="b81" class="tdd"></td><td id="b82" class="tdd"></td><td id="b83" class="tdd"></td><td id="b84" class="tdd"></td><td id="b85" class="tdd"></td><td id="b86" class="tdd"></td><td id="b87" class="tdd"></td><td id="b88" class="tdd"></td><td id="b89" class="tdd"></td><td id="b90" class="tdd"></td>
                        </tr> <!-- two -->

                        <tr class="trr">
                            <td id="b80" class="tdd"></td><td id="b79" class="tdd"></td><td id="b78" class="tdd"></td><td id="b77" class="tdd"></td><td id="b76" class="tdd"></td><td id="b75" class="tdd"></td><td id="b74" class="tdd"></td><td id="b73" class="tdd"></td><td id="b72" class="tdd"></td><td id="b71" class="tdd"></td>
                        </tr> <!-- three -->

                        <tr class="trr">
                            <td id="b61" class="tdd"></td><td id="b62" class="tdd"></td><td id="b63" class="tdd"></td><td id="b64" class="tdd"></td><td id="b65" class="tdd"></td><td id="b66" class="tdd"></td><td id="b67" class="tdd"></td><td id="b68" class="tdd"></td><td id="b69" class="tdd"></td><td id="b70" class="tdd"></td>
                        </tr> <!-- four -->

                        <tr class="trr">
                            <td id="b60" class="tdd"></td><td id="b59" class="tdd"></td><td id="b58" class="tdd"></td><td id="b57" class="tdd"></td><td id="b56" class="tdd"></td><td id="b55" class="tdd"></td><td id="b54" class="tdd"></td><td id="b53" class="tdd"></td><td id="b52" class="tdd"></td><td id="b51" class="tdd"></td>
                        </tr> <!-- five -->

                        <tr class="trr">
                            <td id="b41" class="tdd"></td><td id="b42" class="tdd"></td><td id="b43" class="tdd"></td><td id="b44" class="tdd"></td><td id="b45" class="tdd"></td><td id="b46" class="tdd"></td><td id="b47" class="tdd"></td><td id="b48" class="tdd"></td><td id="b49" class="tdd"></td><td id="b50" class="tdd"></td>
                        </tr> <!-- six -->

                        <tr class="trr">
                            <td id="b40" class="tdd"></td><td id="b39" class="tdd"></td><td id="b38" class="tdd"></td><td id="b37" class="tdd"></td><td id="b36" class="tdd"></td><td id="b35" class="tdd"></td><td id="b34" class="tdd"></td><td id="b33" class="tdd"></td><td id="b32" class="tdd"></td><td id="b31" class="tdd"></td>
                        </tr> <!-- seven-->

                        <tr class="trr">
                            <td id="b21" class="tdd"></td><td id="b22" class="tdd"></td><td id="b23" class="tdd"></td><td id="b24" class="tdd"></td><td id="b25" class="tdd"></td><td id="b26" class="tdd"></td><td id="b27" class="tdd"></td><td id="b28" class="tdd"></td><td id="b29" class="tdd"></td><td id="b30" class="tdd"></td>
                        </tr> <!-- eight -->

                        <tr class="trr">
                            <td id="b20" class="tdd"></td><td id="b19" class="tdd"></td><td id="b18" class="tdd"></td><td id="b17" class="tdd"></td><td id="b16" class="tdd"></td><td id="b15" class="tdd"></td><td id="b14" class="tdd"></td><td id="b13" class="tdd"></td><td id="b12"></td><td id="b11"></td>
                        </tr> <!-- nine-->

                        <tr class="trr">
                            <td id="b1" class="tdd"></td><td id="b2" class="tdd"></td><td id="b3" class="tdd"></td><td id="b4" class="tdd"></td><td id="b5" class="tdd"></td><td id="b6" class="tdd"></td><td id="b7" class="tdd"></td><td id="b8" class="tdd"></td><td id="b9" class="tdd">9 </td><td id="b10" class="tdd">10 </td>
                        </tr> <!-- ten -->


                    </table>    
                </div>
                <%
                    if (request.getParameter("dieValue") != null) {
                        for (int i = 0; i < gameDetails.size(); i++) {
                            String gameData[] = gameDetails.get(i).split(";");
                %>
                <script>
                    document.getElementById("b<%=gameData[2]%>").innerHTML="<img src='images/<%=gameData[1]%>.gif'>";
                </script>    
                <%      }
                    }
                %>
                <%
                    if (currentPlayerName.equals(session.getAttribute("USERNAME").toString())) {
                %>
                <font color="red" class="text">Click to Roll Die</font>
                <input type="image" src="images/1.jpg" value="Die" class="die" onclick="this.disabled=true;start('<%=boardName%>');">
                <br>
                <font color="red" class="playerStatus"><%=session.getAttribute("USERNAME").toString()%> Roll your Die</font>
                <%
                } else {
                %>
                <font color="red" class="playerStatus"><%=session.getAttribute("USERNAME").toString()%> wait for your turn</font>
                <meta http-equiv="refresh" content="5">
                <%     }
                %>                
                <font color="red" class="noOfPlayers">Die Rolled Value: <%=request.getParameter("dieVal") == null ? "" : request.getParameter("dieVal")%></font>
                <table class="scoreBoard">
                    <tr><td><b>Name </b></td><td><b> Color </b></td><td>Pawn</td><td><b> Position</b></td></tr>
                    <%
                        for (int i = 0; i < gameDetails.size(); i++) {
                            String arr[] = gameDetails.get(i).split(";");
                            out.println("<tr><td><font color='" + arr[1] + "'>" + arr[0] + "</font></td><td><font color='" + arr[1] + "'>" + arr[1] + " </font></td><td><img src=images/" + arr[1] + ".gif></td><td><font color='" + arr[1] + "'>" + arr[2] + "</font></td></tr>");

                            if (Integer.parseInt(arr[2]) == 100) {
                                dh.displayGameWinnerPage(request, response, contextPath, arr[0]);
                            }
                        }
                    %>
                </table>
            </div>
        </div>
    </body>
</html>