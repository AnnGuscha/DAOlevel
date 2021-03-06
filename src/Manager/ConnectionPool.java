package manager;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

/**
 * Created by Anna on 12/1/2015.
 */
public class ConnectionPool {
    private static final Logger log = Logger.getLogger(ConnectionPool.class);
    private static ConnectionPool connectionPool;
    private Properties prop;
    private Vector<Connection> availableConns = new Vector<Connection>();
    private Vector<Connection> usedConns = new Vector<Connection>();
    private String url;
    private String user;
    private String password;

    private ConnectionPool (int initConnCnt)
    {
        try {
            this.url = ConfigManager.getInstance().getObject("DataURL");
            this.user= ConfigManager.getInstance().getObject("User");
            this.password= ConfigManager.getInstance().getObject("Password");

            Class.forName(ConfigManager.getInstance().getObject("Driver"));

            log.info("Create pool connection.");
        } catch (Exception e) {
            log.error("Error:", e);
            e.printStackTrace();
        }
        for (int i = 0; i < initConnCnt; i++) {
            availableConns.addElement(getConnection());
        }
    }

    public static synchronized ConnectionPool getConnectionPool() {
        if ( connectionPool == null ) {
            connectionPool = new ConnectionPool(5);
        }
        return connectionPool;
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            log.error("Error:", e);
            e.printStackTrace();
        }
        return conn;
    }

    public synchronized Connection retrieve() throws SQLException {
        Connection newConn = null;
        if (availableConns.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = availableConns.lastElement();
            availableConns.removeElement(newConn);
        }
        usedConns.addElement(newConn);
        return newConn;
    }

    public synchronized void putback(Connection c) throws NullPointerException {
        if (c != null) {
            if (usedConns.removeElement(c)) {
                availableConns.addElement(c);
            } else {
                throw new NullPointerException("Connection not in the usedConns array");
            }
        }
    }

    public int getAvailableConnsCnt() {
        return availableConns.size();
    }
}