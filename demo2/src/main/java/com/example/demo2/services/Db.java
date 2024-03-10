package com.example.demo2.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

    private Connection con;

    public Connection getcon(){
        return con;
    }

    public Db() {

        String host = "mysql-171d1836-edrifayoub36-9292.a.aivencloud.com";
        String port = "26643";
        String databaseName = "servlet";
        String userName = "avnadmin";
        String password = "AVNS_WgEP5wcESe1-e5umfSH";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + databaseName + "?sslmode=require", userName, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void closecon(){
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
