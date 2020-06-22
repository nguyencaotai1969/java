/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanlySanPhamBai9;

/**
 *
 * @author Admin
 */
public class Entityproduct {
    private int id;
    private String productid;
    private String productname;
    private float uniprice;
    private int quantity;
    private String description;
    private int categoryid;

    public Entityproduct() {
    }

    public Entityproduct(int id, String productid, String productname, float uniprice, int quantity, String description,int categoryid) {
        this.id = id;
        this.productid = productid;
        this.productname = productname;
        this.uniprice = uniprice;
        this.quantity = quantity;
        this.description = description;
        this.categoryid = categoryid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public float getUniprice() {
        return uniprice;
    }

    public void setUniprice(float uniprice) {
        this.uniprice = uniprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getcategoryid() {
        return categoryid;
    }

    public void setcategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    @Override
    public String toString() {
        return "Entityproduct{" + "id=" + id + ", productid=" + productid + ", productname=" + productname + ", uniprice=" + uniprice + ", quantity=" + quantity + ", description=" + description + ", categoryid=" + categoryid + '}';
    }

   
    
}
