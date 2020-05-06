/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SinhVienUTT extends Sinhvien {
    private String donVi;
    private double luong;

    public SinhVienUTT() {
    }

    public SinhVienUTT( String masv, String hoTen, String ngaySinh, String gioiTinh, float diemTB, String donVi, double luong) {
        super(masv, hoTen, ngaySinh, gioiTinh, diemTB);
        this.donVi = donVi;
        this.luong = luong;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return super.toString()+"SinhVienUTT{" + "donVi=" + donVi + ", luong=" + luong + '}';
    }
    public void input(){
            super.input();
            System.out.print("Nhap donVi:");
    this.setDonVi(new Scanner(System.in).nextLine());
            System.out.print("Nhap luong:");
    this.setLuong(new Scanner(System.in).nextDouble());
    }
    public void saveToFile(){
        BufferedWriter bw =null;
        try {
            bw = new BufferedWriter(new FileWriter("svutt.dat"));
            for(int i=0;i<2;i++){
                   SinhVienUTT sv = new SinhVienUTT();
            sv.input();
            String line = sv.getMasv()+"/"+sv.getHoTen()+"/"
                    +sv.getNgaySinh()+"/"+sv.getGioiTinh()+"/"
                    +sv.getDiemTB()+"/"+sv.getLuong()+"/"+sv.getDonVi();
            bw.write(line);
            bw.newLine();
            }
         
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(SinhVienUTT.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
}
