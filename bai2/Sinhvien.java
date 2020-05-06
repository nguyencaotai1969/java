/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Sinhvien {
    private String masv;
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private Float diemTB;

    public Sinhvien() {
    }

    public Sinhvien(String masv, String hoTen, String ngaySinh, String gioiTinh, Float diemTB) {
        this.masv = masv;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diemTB = diemTB;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(Float diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return "Sinhvien{" + "masv=" + masv + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diemTB=" + diemTB + '}';
    }
    public void input(){
            System.out.print("Nhap Ma Sv:");
    this.setMasv(new Scanner(System.in).nextLine());
            System.out.print("Nhap Hoten:");
    this.setHoTen(new Scanner(System.in).nextLine());
            System.out.print("Nhap ngay sinh:");
    this.setNgaySinh(new Scanner(System.in).nextLine());
            System.out.print("Nhap gioi tinh:");
    this.setGioiTinh(new Scanner(System.in).nextLine());
            System.out.print("Nhap diem  TB:");
    this.setDiemTB(new Scanner(System.in).nextFloat());
    
    }
    
}
