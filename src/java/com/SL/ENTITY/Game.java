
package com.SL.ENTITY;

/**
 *
 * @author Kalyan Kasyap
 */

public class Game {
    
    private String userName,boardName,boardPassword,pawnColor;
    private int noPlayers;

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardPassword() {
        return boardPassword;
    }

    public void setBoardPassword(String boardPassword) {
        this.boardPassword = boardPassword;
    }

    public int getNoPlayers() {
        return noPlayers;
    }

    public void setNoPlayers(int noPlayers) {
        this.noPlayers = noPlayers;
    }

    public String getPawnColor() {
        return pawnColor;
    }

    public void setPawnColor(String pawnColor) {
        this.pawnColor = pawnColor;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }  
}
