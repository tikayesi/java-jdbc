package com.enigma.tokosaya.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private final String url = "jdbc:postgresql://localhost/shopee";
    private final String user = "postgres";
    private final String password = "P@ssw0rd";

    public Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected tp the postgreSQL server succefully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
