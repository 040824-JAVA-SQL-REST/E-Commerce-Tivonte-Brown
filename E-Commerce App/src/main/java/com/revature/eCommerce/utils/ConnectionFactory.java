package com.revature.eCommerce.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;


public class ConnectionFactory{
    private static  ConnectionFactory instance;
    public Connection conn;

    private ConnectionFactory() throws IOException, SQLException {
        loadProperties();
    }

    public static ConnectionFactory getInstance()  throws IOException, SQLException {
        if(instance == null || instance.getConnection().isClosed()){
            return new ConnectionFactory();
        }
        return instance;
    }
    public Connection getConnection(){
        return conn;
    }


        private void loadProperties() throws IOException, SQLException {
            InputStream is = getClass().getClassLoader().getResourceAsStream("application.properties");
            Properties p = new Properties();
            p.load(is);
            conn= DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"))

        }
}




