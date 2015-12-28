package com.lcw.db;

import com.lcw.jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <p>数据库工具类</p>
 *
 * @author liuchenwei
 * @date 2015/12/20
 */
public class DBUtil {

    private static final String CONFIG_FILE_PATH = "/config/datasource.properties";

    /** ConnectionFactory 单例 */
    private static ConnectionFactory connectionFactory;

    static {
        connectionFactory = new ConnectionFactory(CONFIG_FILE_PATH);
    }

    /**
     * 返回一个新的 Connection 对象
     *
     * @return java.sql.Connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException
    {
        return connectionFactory.create();
    }

    /**
     * 依次关闭数据库的相关连接对象
     *
     * @param connection Connection 对象
     * @param stmt       Statement 对象
     * @param rs         ResultSet 对象
     */
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
