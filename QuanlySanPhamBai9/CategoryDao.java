/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanlySanPhamBai9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public class CategoryDao implements Dao<Entitycategory> {
    static final String TABLE_NAME = "category";
    MyConnect myConnection = new MyConnect();
    Connection conn = myConnection.getInstance();
    @Override
    public List<Entitycategory> getAll() {
        List<Entitycategory> list =new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM "+TABLE_NAME;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                list.add(new Entitycategory(rs.getInt("id"),rs.getString("name"),rs.getString("description")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(ps !=null){
                    ps.close();
                }
                 if(rs !=null){
                    rs.close();
                }
            } catch (Exception e) {
            }
        }
        return list;
    }

    @Override
    public Optional<Entitycategory> get(int id) {
        Entitycategory cate = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM "+TABLE_NAME+" where id =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {                
                cate = new Entitycategory(rs.getInt("id"),rs.getString("name"),rs.getString("description"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(ps !=null){
                    ps.close();
                }
                 if(rs !=null){
                    rs.close();
                }
            } catch (Exception e) {
            }
        }
        return Optional.of(cate);
    }

    @Override
    public int insert(Entitycategory t) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "Insert into "+TABLE_NAME+"(name,description) values(?, ?)";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setNString(1, t.getName());
            ps.setNString(2, t.getDescription());
            if(ps.executeUpdate() >0){
                rs = ps.getGeneratedKeys();
                while(rs.next()){
                    return rs.getInt(1);
                }
                
            }
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(ps !=null){
                    ps.close();
                }
                 if(rs !=null){
                    rs.close();
                }
            } catch (Exception e) {
            }
        }
        return -1;
    }

    @Override
    public boolean update(Entitycategory t) {
        PreparedStatement ps = null;
        try {
            String sql = "update "+TABLE_NAME+" set name = ?, description =? where id=?";
            ps = conn.prepareStatement(sql);
            ps.setNString(1, t.getName());
            ps.setNString(2, t.getDescription());
            ps.setInt(3,t.getId());
            if(ps.executeUpdate() >0){
               return true;
                
            }
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(ps !=null){
                    ps.close();
                }
            
            } catch (Exception e) {
            }
        }
        return false;
    }

    @Override
    public boolean delete(Entitycategory t) {
       PreparedStatement ps = null;
        try {
            String sql = "delete from "+TABLE_NAME+" where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,t.getId());
            if(ps.executeUpdate() >0){
               return true;
            }
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(ps !=null){
                    ps.close();
                }
            
            } catch (Exception e) {
            }
        }
        return false;
    }

    public boolean delete(int id) {
         PreparedStatement ps = null;
        try {
            String sql = "delete from "+TABLE_NAME+" where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            if(ps.executeUpdate() >0){
               return true;
            }
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(ps !=null){
                    ps.close();
                }
            
            } catch (Exception e) {
            }
        }
        return false;
    }
    
    public static void main(String[] args){
       CategoryDao categoryDao = new CategoryDao();
       System.out.println(categoryDao.get(1));
       Entitycategory c1 = new Entitycategory(1,"Cao tai","dep trai");
       System.out.println(categoryDao.update(c1));
    }
}
