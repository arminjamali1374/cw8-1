package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private static Connection connection = null;
    private static final String url = "jdbc:postgresql://localhost:5432/cw8";
    private static final String username = "postgres";
    private static final String password = "123456";

    private ConnectionUtils() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
