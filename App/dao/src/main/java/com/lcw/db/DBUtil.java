package com.lcw.db;

import com.lcw.jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vic on 2015/12/20.
 */
public class DBUtil {

    private static final String CONFIG_FILE_PATH = "/config/datasource.properties";

    private static ConnectionFactory connectionFactory;

    static {
        connectionFactory = new ConnectionFactory(CONFIG_FILE_PATH);
    }

    public static Connection getConnection() throws SQLException {
        return connectionFactory.create();
    }

    public static void closeQiuetly(Connection connection, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
