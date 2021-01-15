package com.enigma.tokosaya.main;

import com.enigma.tokosaya.config.DBConnector;

import java.sql.*;
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

        String querynya = "SELECT * FROM customer where email = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(querynya);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()) {
            System.out.println("Login success!!!");
            System.out.println("welcome" + resultSet.getString("name"));
        } else {
            System.out.println("Login Failed!!!");
        }

        connection.close();

    }
}
