/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *
 * @author Admin
 */
public class test {
    public static void main(String[] args){
        System.out.println("moi Ban Nhap SINH VIEN UTT");
        SinhVienUTT sinhVienUTT = new SinhVienUTT();
        sinhVienUTT.saveToFile();
        
        System.out.println("moi Ban Nhap SINH VIEN HTTT");
        SinhVienHTTT sinhVienHTTT = new SinhVienHTTT();
        sinhVienHTTT.SaveToFile();
    }

}
