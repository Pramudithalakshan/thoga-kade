package edu.icet.ecom.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection connection;
    private Database(){}

    public static Connection getInstance() throws SQLException{
            return connection==null ? DriverManager.getConnection("jdbc:mysql://localhost:3306/thoga_kade") : connection;
    }
}
