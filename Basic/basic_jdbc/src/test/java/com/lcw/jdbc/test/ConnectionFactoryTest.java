/**
 * 
 */
package com.lcw.jdbc.test;

import com.lcw.jdbc.ConnectionFactory;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactoryTest {

    private static final String CONFIG_FILE_PATH = "/config/datasource.properties";

    @Test
    public void testIsEmpty() {
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
                Assert.assertTrue(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.assertTrue(false);
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
                Assert.assertTrue(false);
            }
        }
    }
}
