/**
 * 
 */
package com.lcw.jdbc;

import com.lcw.util.CommonUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接工厂
 */
public class ConnectionFactory {

    private String configFilePath;

	private String driver;
	private String url;
	private String username;
	private String password;

    public ConnectionFactory(String configFilePath) {
        if(CommonUtil.isEmpty(configFilePath)) {
            throw new IllegalArgumentException("configFilePath cannot be null.");
        }
        this.configFilePath = configFilePath;
        init();
    }

	/**
	 * 创建一个数据库连接
	 */
	public Connection create() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	private void init() {
        Properties config = loadProperties();

		this.driver = config.getProperty("driver");
        this.url = config.getProperty("url");
        this.username = config.getProperty("username");
        this.password = config.getProperty("password");

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Properties loadProperties() {
		Properties settings = new Properties();
		try {
			settings.load(this.getClass().getResourceAsStream(configFilePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return settings;
	}
}
