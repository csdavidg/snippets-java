package com.example.snippets.demo.java11.jdbc;

import java.sql.*;

public class TestConnection {

    public static void main(String[] args) throws SQLException {
        Connection conn =
                DriverManager.getConnection("jdbc:derby:zoo");
        var prepareStatement = conn.prepareStatement("");
        System.out.println(conn);
    }
}