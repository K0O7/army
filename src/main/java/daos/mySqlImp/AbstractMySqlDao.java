package daos.mySqlImp;

import java.sql.Connection;
import java.sql.SQLException;

import solvd.ConnectionPool;

public abstract class AbstractMySqlDao {

    protected Connection getConnection() throws SQLException {
        return ConnectionPool.getConnection();
    }

    protected void releaseConnection(Connection conn) {
        ConnectionPool.releaseConnection(conn);
    }
}
