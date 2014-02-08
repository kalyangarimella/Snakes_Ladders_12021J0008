package com.SL.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
This class return the connection object whenever one request for it to connect to the mysql server.
 */

public class DBConnection {

    private String userName = null, password = null, url = null;

    public Connection getConnection() throws SQLException, ClassNotFoundException {

        userName = "root";
        password = "";
        url = "jdbc:mysql://localhost:3306/snakes_ladders_db";

        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection(url, userName, password);
    }
}
