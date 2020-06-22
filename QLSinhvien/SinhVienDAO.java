/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSinhvien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SinhVienDAO {
    public static List<SinhVien> getAll(){
        List<SinhVien> list = new ArrayList<>();
        String sql = "select * from sinhvien";
        Connection conn = MyConnection.openConnection();
        try {
            if(conn !=null){
                Statement  stmt = conn.createStatement();
             ResultSet   rs = stmt.executeQuery(sql);
            while(rs.next()){
                list.add(new SinhVien(rs.getInt("masv"), rs.getString("hoTen"), rs.getInt("tuoi")));
                }    
            }else{
                 System.out.print("die");
            }
            
        } catch (SQLException ex) {
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
   public boolean inster(SinhVien sv){
        String sql = "INSERT INTO sinhvien VALUES (null,'"+sv.getHoTen()+"','"+sv.getTuoi()+"')";
        Connection conn = MyConnection.openConnection();
        try {
             
              if(conn != null){  
               Statement  stmt = conn.createStatement();
                int i = stmt.executeUpdate(sql);
                  System.out.print("i"+i);
                if(i > 0){
                    return true;
                }else{
                    return false;
                }
             }else{
                  System.out.print("die sql");
              }
             }catch (SQLException e) {
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            return false;    
    }
   public static int getLastID(){
       String sql = "SELECT Max(masv) as idMax from sinhvien";
        Connection conn = MyConnection.openConnection();
        try{
            if(conn !=null){
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if(rs.next()){
                    return rs.getInt(1);
                }else{
                    return 0;
                }
            }
        }catch(SQLException e){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       return 0;

   }
      public static boolean Update(SinhVien sv){
        String sql = "UPDATE sinhvien set hoten='"+sv.getHoTen()+"',tuoi="+sv.getTuoi()+" where masv="+sv.getMaSV();
        Connection conn = MyConnection.openConnection();
                try{
            if(conn !=null){
                Statement stmt = conn.createStatement();
                int i = stmt.executeUpdate(sql);
                if(i >0){
                    return true;
                }else{
                    return false;
                }
            }
        }catch(SQLException e){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       return false;

   }
   public boolean delete(int maSV){
        String sql = "DELETE from sinhvien where masv='"+maSV+"'";
        Connection conn = MyConnection.openConnection();
        try{
            if(conn !=null){
                Statement stmt = conn.createStatement();
                int i = stmt.executeUpdate(sql);
                if(i >0){
                    return true;
                }else{
                    return false;
                }
            }
        }catch(SQLException e){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       return false;
   }
   
    public static void main(String[] args) {
        SinhVienDAO sinhVienDAO = new SinhVienDAO();
//        List<SinhVien> list = sinhVienDAO.getAll();
//        for(SinhVien sinhVien : list){
//            System.out.println(sinhVien);
//        }    
//        System.out.print(sinhVienDAO.getLastID());
    }
}
