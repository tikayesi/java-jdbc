package com.enigma.tokosaya.main;

import com.enigma.tokosaya.config.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Email =");
        String email = scanner.nextLine();
        System.out.print("Password =");
        String password = scanner.nextLine();

        DBConnector dbConnector = new DBConnector();
        Connection connection = dbConnector.connect();

        Statement statement = connection.createStatement();
        String querynya = "SELECT * FROM customer where email ='"+ email+"' AND  password = '"+ password +"'";
        ResultSet resultSet = statement.executeQuery(querynya);

        if(resultSet.next()) {
            System.out.println("Login success!!!");
            System.out.println("welcome" + resultSet.getString("name"));
        } else {
            System.out.println("Login Failed!!!");
        }

        statement.close();
        connection.close();

    }
}
