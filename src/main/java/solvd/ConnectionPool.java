package solvd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class ConnectionPool {
    private static final int MAX_POOL_SIZE = 10;
    private static final Map<String, String> DRIVER_MAP = new HashMap<>();
    
    static {
        DRIVER_MAP.put("mysql", "com.mysql.cj.jdbc.Driver");
        DRIVER_MAP.put("oracle", "oracle.jdbc.OracleDriver");
    }

    private static final Map<String, List<Connection>> availableConnections = new HashMap<>();
    private static final Map<String, List<Connection>> usedConnections = new HashMap<>();
    
    private static String dbType = "mysql";
    private static String url = "jdbc:mysql://34.205.43.78:3306/Army";
    private static String user = "root";
    private static String password = "";

    static {
        try {
            configureDatabase(dbType, url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("Error initializing connection pool", e);
        }
    }

    public static synchronized void configureDatabase(String databaseType, String dbUrl, String dbUser, String dbPassword) throws ClassNotFoundException, SQLException {
        if (!DRIVER_MAP.containsKey(databaseType)) {
            throw new IllegalArgumentException("Unsupported database type: " + databaseType);
        }

        Class.forName(DRIVER_MAP.get(databaseType));

        dbType = databaseType;
        url = dbUrl;
        user = dbUser;
        password = dbPassword;

        availableConnections.put(dbType, new ArrayList<>());
        usedConnections.put(dbType, new ArrayList<>());

        for (int i = 0; i < MAX_POOL_SIZE; i++) {
            availableConnections.get(dbType).add(createConnection());
        }
    }

    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static synchronized Connection getConnection() throws SQLException {
        List<Connection> pool = availableConnections.get(dbType);
        if (pool == null || pool.isEmpty()) {
            throw new SQLException("No available connections in the pool for " + dbType);
        }
        Connection conn = pool.remove(pool.size() - 1);
        usedConnections.get(dbType).add(conn);
        return conn;
    }

    public static synchronized void releaseConnection(Connection conn) {
        if (conn != null) {
            usedConnections.get(dbType).remove(conn);
            availableConnections.get(dbType).add(conn);
        }
    }

    public static synchronized void shutdown() {
        closeConnections(availableConnections.get(dbType));
        closeConnections(usedConnections.get(dbType));
        availableConnections.clear();
        usedConnections.clear();
    }

    private static void closeConnections(List<Connection> connections) {
        if (connections != null) {
            for (Connection conn : connections) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            connections.clear();
        }
    }
}
