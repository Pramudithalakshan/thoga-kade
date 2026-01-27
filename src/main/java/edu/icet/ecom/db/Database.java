package edu.icet.ecom.db;


import edu.icet.ecom.exception.DatabaseConnectionException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private static  Connection connection;
    private Database(){}

    private static final Properties properties = new Properties();
    static {
        try {
            properties.load(Database.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            throw new DatabaseConnectionException("Database connection not found");
        }
    }

    public static Connection getInstance() throws SQLException{
        return connection==null ? DriverManager.getConnection(properties.getProperty("db.url"),properties.getProperty("db.user"),properties.getProperty("db.password")) : connection;
    }
}
