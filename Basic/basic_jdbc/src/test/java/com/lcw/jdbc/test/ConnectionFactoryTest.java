/**
 * 
 */
package com.lcw.jdbc.test;

import com.lcw.jdbc.ConnectionFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertTrue;

/**
 * <p>数据库连接工厂测试用例</p>
 *
 * @author liuchenwei
 * @date 2015/12/20
 */
public class ConnectionFactoryTest {

    private static final String CONFIG_FILE_PATH = "/config/datasource.properties";

    @Test
    public void testConnection() {
        ConnectionFactory factory = new ConnectionFactory(CONFIG_FILE_PATH);

        String sql = "select 1 ";

        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection = factory.create();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.print(rs.getInt(1));
                assertTrue(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            assertTrue(false);// 出了异常意味着测试失败
        } finally {
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
                assertTrue(false);
            }
        }
    }
}
