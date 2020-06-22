/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanlySanPhamBai9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public class ProductDao implements Dao<Entityproduct> {
    static final String TABLE_NAME = "product";
    MyConnect myConnection = new MyConnect();
    Connection conn = myConnection.getInstance();
    @Override
    public List<Entityproduct> getAll() {
        List<Entityproduct> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM " + TABLE_NAME;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new 
                Entityproduct(
                rs.getInt("id"), 
                rs.getString("productid"), 
                rs.getString("productname"),
                rs.getFloat("uniprice"),
                rs.getInt("quantity"),
                rs.getString("description"),
                rs.getInt("categoryid")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
        }
        return list;
    }

    @Override
    public Optional<Entityproduct> get(int id) {
        Entityproduct cate = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM "+TABLE_NAME+" where id =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {                
                cate = new Entityproduct(rs.getInt("id"), 
                rs.getString("productid"), 
                rs.getString("productname"),
                rs.getFloat("uniprice"),
                rs.getInt("quantity"),
                rs.getString("description"),
                rs.getInt("categoryid"));
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
    public int insert(Entityproduct t) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "Insert into "+TABLE_NAME+"(productid,productname,uniprice,quantity,description,categoryid) values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setNString(1, t.getProductid());
            ps.setNString(2, t.getProductname());
            ps.setFloat(3,t.getUniprice());
            ps.setInt(4, t.getQuantity());
            ps.setNString(5,t.getDescription());
            ps.setInt(6,t.getcategoryid());
            
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
    public boolean update(Entityproduct t) {
             PreparedStatement ps = null;
        try {
            String sql = "update "+TABLE_NAME+" set productid = ?, productname = ?,uniprice=?,quantity=?,description=?,categoryid=? where id=?";
            ps = conn.prepareStatement(sql);
            ps.setNString(1, t.getProductid());
            ps.setNString(2, t.getProductname());
            ps.setFloat(3,t.getUniprice());
            ps.setInt(4, t.getQuantity());
            ps.setNString(5,t.getDescription());
            ps.setInt(6,t.getcategoryid());
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
    public boolean delete(Entityproduct t) {
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
     public List<Entityproduct> getByCategoryId(int categoryid) {
        List<Entityproduct> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM " + TABLE_NAME + "where categoryid = "+categoryid;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new 
                Entityproduct(
                rs.getInt("id"), 
                rs.getString("productid"), 
                rs.getString("productname"),
                rs.getFloat("uniprice"),
                rs.getInt("quantity"),
                rs.getString("description"),
                rs.getInt("categoryid")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
        }
        return list;
    }
    public static void main(String[] args){
        ProductDao categoryDao = new ProductDao();
        for (Entityproduct c : categoryDao.getByCategoryId(1)) {
            System.out.println(c);
        }
    }

    
}

    

