package edu.icet.ecom.db;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    public static Connection connection;
    private Database(){}

    private static Properties properties = new Properties();
    static {
        try {
            properties.load(Database.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getInstance() throws SQLException{

        return connection==null ? DriverManager.getConnection(properties.getProperty("db.url"),properties.getProperty("db.user"),properties.getProperty("db.password")) : connection;
    }
}
