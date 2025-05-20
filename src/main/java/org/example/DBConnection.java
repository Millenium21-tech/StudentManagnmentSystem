package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/Database_Managnment_System";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1221";

    public static Connection getConnection()throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}
