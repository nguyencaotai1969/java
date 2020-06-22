/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanlySanPhamBai9;

import QLSinhvien.MyConnection;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */


/**
 *
 * @author BMLaptop
 */
public class MyConnect {
    private String hostName = "localhost";
    private String sqlInstanceName = "SQLEXPRESS";
    private String database = "Quanlysanphambai9";
    private String userName = "sa";
    private String password = "123";
    private String url="jdbc:sqlserver://" + hostName + ":1433" + ";instance=" + sqlInstanceName + ";databaseName=" + database;
    
    private Connection conn;

    public Connection getInstance(){
        if ( conn == null) {
            conn = openConnection();
        }
        return conn;
    }
    
    public Connection openConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void closeConnection(){
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