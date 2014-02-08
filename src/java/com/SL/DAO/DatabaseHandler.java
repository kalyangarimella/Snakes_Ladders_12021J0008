package com.SL.DAO;

import com.SL.ENTITY.*;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler {

    private Connection connection = null;
    private boolean flag = false, status = false, readStatus = false;
    private String commandText = "";
    private ArrayList<String> boardNames = null;
    private ArrayList<String> playersJoinedDetails = null;
    private ArrayList<String> gameDetails = null;
    private int noPlayers;

    public DatabaseHandler() throws SQLException, ClassNotFoundException {

        DBConnection db = new DBConnection();

        connection = db.getConnection();
    }

    public boolean readUserName(String userName) {

        commandText = "select * from reg_details_tb where username='" + userName + "'";

        try {

            PreparedStatement statement = connection.prepareStatement(commandText);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                flag = true;
                statement.close();
                rs.close();
                connection.close();
                return flag;
            } else {
                statement.close();
                rs.close();
                connection.close();
                return flag;
            }
        } catch (SQLException e) {

            System.out.println("There is some exception");            
            return flag;
        }
    }

    public String readPawnColor(String boardName, String boardPassword) {

        commandText = "select pawncolor from board_details_tb where boardname='" + boardName + "' and boardpassword='" + boardPassword + "'";

        boolean flagStatus = true;

        String pawnColor = "";

        try {

            PreparedStatement statement = connection.prepareStatement(commandText);

            ResultSet rs = statement.executeQuery();

            while (rs.next() && flagStatus == true) {

                pawnColor = rs.getString(1);

                flag = false;
            }
                statement.close();
                rs.close();
                connection.close();
                
            return pawnColor;

        } catch (SQLException e) {

            System.out.println("There is some exception");

            return pawnColor;
        }
    }

    public boolean readBoardName(String boardName) {

        commandText = "select * from board_details_tb where boardname='" + boardName + "'";

        try {

            PreparedStatement statement = connection.prepareStatement(commandText);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                
                readStatus = true;
                statement.close();
                rs.close();
                connection.close();
                
                return readStatus;
                
            } else {                
                
                statement.close();
                rs.close();
                connection.close();
                
                return readStatus;                
            }
        } catch (SQLException e) {

            System.out.println("There is some exception");

            return readStatus;
        }
    }

    public ArrayList<String> readBoardNames() {

        boardNames = new ArrayList<String>();

        commandText = "select boardname,boardpassword,pawncolor from board_details_tb";

        try {

            PreparedStatement statement = connection.prepareStatement(commandText);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                boardNames.add(rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3));
            }

            return boardNames;

        } catch (Exception e) {

            System.out.println("There is some exception");

            return boardNames;
        }
    }

    public boolean readLoginDetails(String userName, String password) {

        commandText = "select * from reg_details_tb where username='" + userName + "' and password='" + password + "'";

        try {

            PreparedStatement statement = connection.prepareStatement(commandText);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                status = true;

                return status;
            } else {
                return status;
            }
        } catch (Exception e) {

            System.out.println("There is some exception");

            return status;
        }
    }

    public void insertUserDetails(User user) throws Exception {

        commandText = "insert into reg_details_tb(firstname,username,birthday,gender,email,password,address,question,answer,altemail) values(?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(commandText);

        statement.setString(1, user.getFirstname());
        statement.setString(2, user.getUsername());
        statement.setString(3, user.getBirthday());
        statement.setString(4, user.getGender());
        statement.setString(5, user.getEmail());
        statement.setString(6, user.getPassword());
        statement.setString(7, user.getAddress());
        statement.setString(8, user.getQuestion());
        statement.setString(9, user.getAnswer());
        statement.setString(10, user.getAltemail());
        statement.execute();
    }

    public void insertGameDetails(Game game) throws Exception {

        commandText = "insert into board_details_tb(username,boardname,boardpassword,noofplayers,pawncolor) values(?,?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(commandText);

        statement.setString(1, game.getUserName());
        statement.setString(2, game.getBoardName());
        statement.setString(3, game.getBoardPassword());
        statement.setInt(4, game.getNoPlayers());
        statement.setString(5, game.getPawnColor());
        statement.execute();
    }

    public void insertJoinGameDetails(String playerName, String boardName, String pawnColor) throws Exception {

        commandText = "insert into players_joined_tb(playername,boardname,pawncolor) values(?,?,?)";

        PreparedStatement statement = connection.prepareStatement(commandText);

        statement.setString(1, playerName);
        statement.setString(2, boardName);
        statement.setString(3, pawnColor);

        statement.execute();
    }

    public void insertPlayerStatusData(String playerName,String status,String pawnColor,String boardName,int playerCount) throws Exception {

        commandText = "insert into playerstatus_tb(playername,status,pawncolor,boardname,playercount) values(?,?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(commandText);

        statement.setString(1, playerName);
        statement.setString(2, status);
        statement.setString(3, pawnColor);
        statement.setString(4, boardName);
        statement.setInt(5, playerCount);

        statement.execute();
    }

    public int readMaxNoPlayers(String boardname) {

        commandText = "select noofplayers from board_details_tb where boardname='" + boardname + "'";

        try {

            PreparedStatement statement = connection.prepareStatement(commandText);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                noPlayers = rs.getInt(1);
            }

            return noPlayers;

        } catch (Exception e) {

            System.out.println("There is some exception");

            return noPlayers;
        }
    }

    public String readActivePlayerStatus() {

        String currentPlayerName = "";

        commandText = "select playername from playerstatus_tb where status=1";

        try {

            PreparedStatement statement = connection.prepareStatement(commandText);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                currentPlayerName = rs.getString(1);
            }

            return currentPlayerName;

        } catch (Exception e) {

            System.out.println("There is some exception");

            return currentPlayerName;
        }
    }

    public String readUserPassword(String username,String question,String answer) {

        String password = "";

        commandText = "select password from reg_details_tb where username='" + username + "' and question ='" + question + "' and answer ='" + answer + "'";

        try {

            PreparedStatement statement = connection.prepareStatement(commandText);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                password = rs.getString(1);
            }

            return password;

        } catch (Exception e) {

            System.out.println("There is some exception");

            return password;
        }
    }
    
    public int readJoinNoPlayers(String boardname) {

        commandText = "select count(*) as noplayers from players_joined_tb where boardname='" + boardname + "'";

        try {

            PreparedStatement statement = connection.prepareStatement(commandText);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                noPlayers = rs.getInt(1);
            }

            return noPlayers;

        } catch (Exception e) {

            System.out.println("There is some exception");

            return noPlayers;
        }
    }

    public ArrayList<String> readPlayersJoined(String boardName) {

        playersJoinedDetails = new ArrayList<String>();

        commandText = "select playername,pawncolor from players_joined_tb where boardname='" + boardName + "'";

        try {

            PreparedStatement statement = connection.prepareStatement(commandText);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                playersJoinedDetails.add(rs.getString(1) + ";" + rs.getString(2));
            }

            return playersJoinedDetails;

        } catch (Exception e) {

            System.out.println("There is some exception");

            return playersJoinedDetails;
        }
    }
    
    
    public String readJoinedFirst(String boardName) {

        String joinedFirst="";

        commandText = "select playername from players_joined_tb where boardname ='"+boardName+"'";

        try {

            PreparedStatement statement = connection.prepareStatement(commandText);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                joinedFirst = rs.getString(1);
            }

            return joinedFirst;

        } catch (Exception e) {

            System.out.println("There is some exception");

            return joinedFirst;
        }
    }
    
    public void updatePlayerStatus() {
                
        String uname = "";
        String stat = "";

        commandText = "select * from playerstatus_tb";

        try {

            PreparedStatement statement = connection.prepareStatement(commandText);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                uname = uname + rs.getString(1) + ";";
                stat  = stat + rs.getString(2) + ";";
            }

            String userName[]   = uname.split(";");
            String userStatus[] = stat.split(";");
            
            for (int i = 0; i < userStatus.length; i++) {
                if (userStatus[i].equals("1") && i != userStatus.length-1) {
                    int bool = statement.executeUpdate("Update playerstatus_tb set status = '" + 0 + "' where playername='" + userName[i] + "'");
                    int bool1 = statement.executeUpdate("Update playerstatus_tb set status = '" + 1 + "' where playername='" + userName[i + 1] + "'");
                    break;
                }
                if (i == userStatus.length-1) {
                    int bool = statement.executeUpdate("Update playerstatus_tb set status = '" + 0 + "' where playername='" + userName[i] + "'");
                    int bool1 = statement.executeUpdate("Update playerstatus_tb set status = '" + 1 + "' where playername='" + userName[0] + "'");
                    break;
                }
            }

        } catch (Exception e) {

            System.out.println("There is some exception");

        }

    }
    
    public void updatePlayerCount(int playercount,String playerName){
         
        try {

            PreparedStatement statement = connection.prepareStatement(commandText);

            statement.executeUpdate("Update playerstatus_tb set playercount="+playercount+" where playername='"+playerName+"'");
             
        } catch (Exception e) {

            System.out.println("There is some exception");

        }
    }
    
    public int readPlayerCount(String playerName) {

        commandText = "select playercount from playerstatus_tb where playername ='"+playerName+"'";
        
        int playercount =0;
        
        try {

            PreparedStatement statement = connection.prepareStatement(commandText);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                playercount = rs.getInt(1);
            }

            return playercount;

        } catch (Exception e) {

            System.out.println("There is some exception");

            return playercount;
        }
    }
    
    public ArrayList<String> readGameData(String boardName) {

        gameDetails = new ArrayList<String>();

        commandText = "select playername,pawncolor,playercount from playerstatus_tb where boardname='" + boardName + "'";

        try {

            PreparedStatement statement = connection.prepareStatement(commandText);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                gameDetails.add(rs.getString(1) + ";" + rs.getString(2)+";"+rs.getInt(3));
            }

            return gameDetails;

        } catch (Exception e) {

            System.out.println("There is some exception");

            return gameDetails;
        }
    }
    
    public void deleteGameData() throws SQLException{
        
        Statement stmt1 = null,stmt2 = null,stmt3 = null;
        String commandText1="",commandText2="",commandText3="";
        
        commandText1 = "delete from playerstatus_tb";
        commandText2 = "delete from players_joined_tb";
        commandText3 = "delete from board_details_tb";
        
        try{
            stmt1 = connection.createStatement();
            stmt1.executeUpdate(commandText1);
            
            
            stmt2 = connection.createStatement();
            stmt2.executeUpdate(commandText2);
            
            
            stmt3 = connection.createStatement();
            stmt3.executeUpdate(commandText3);
            
        }
        catch (Exception e) {
            System.out.println("There is some exception");
        }
        finally{
            stmt1.close();
            stmt2.close();
            stmt3.close();
        }
    }    
}
