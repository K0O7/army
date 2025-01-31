package solvd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static final int MAX_POOL_SIZE = 5;  // Maximum number of connections
    private static final String URL = "jdbc:mysql://localhost:3306/Army";
    private static final String USER = "root";  // Change this to your database user
    private static final String PASSWORD = "password"; // Change this to your database password
    
    private static List<Connection> availableConnections = new ArrayList<>();
    private static List<Connection> usedConnections = new ArrayList<>();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
            for (int i = 0; i < MAX_POOL_SIZE; i++) {
                availableConnections.add(createConnection());
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error initializing connection pool", e);
        }
    }

    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    // Get a connection from the pool
    public static synchronized Connection getConnection() throws SQLException {
        if (availableConnections.isEmpty()) {
            throw new SQLException("No available connections in the pool");
        }
        Connection conn = availableConnections.remove(availableConnections.size() - 1);
        usedConnections.add(conn);
        return conn;
    }

    // Release a connection back to the pool
    public static synchronized void releaseConnection(Connection conn) {
        if (conn != null) {
            usedConnections.remove(conn);
            availableConnections.add(conn);
        }
    }

    // Close all connections when the application stops
    public static synchronized void shutdown() {
        for (Connection conn : availableConnections) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        for (Connection conn : usedConnections) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        availableConnections.clear();
        usedConnections.clear();
    }
}

