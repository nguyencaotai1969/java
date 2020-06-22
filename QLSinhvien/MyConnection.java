/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSinhvien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BMLaptop
 */
public class MyConnection {
    private static String hostName = "localhost";
    private static String database = "qlsv_java";
    private static String userName = "root";
    private static String password = "";
    private static String url="jdbc:mysql://" + hostName + ":3306/" + database;
    private static Connection conn;

    public static Connection getInstance(){
        if ( conn == null) {
            conn = openConnection();
        }
        return conn;
    }
    
    public static Connection openConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection(){
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (MyConnection.getInstance()!=null) {
            System.out.println("Connect successfull");
        }else{
            System.out.println("Connect not successfull");
        }

    }
}
