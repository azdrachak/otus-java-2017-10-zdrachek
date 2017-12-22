package com.github.azdrachak.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mariadb://localhost:3306/homework09?user=root&password=root";
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
