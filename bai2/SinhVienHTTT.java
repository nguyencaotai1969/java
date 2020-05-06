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
public class SinhVienHTTT extends Sinhvien{
    private float hocphi;

    public SinhVienHTTT() {
    }

    public SinhVienHTTT( final String masv, final String hoTen, final String ngaySinh, final String gioiTinh,
            final float diemTB, final float hocphi) {
        super(masv, hoTen, ngaySinh, gioiTinh, diemTB);
        this.hocphi = hocphi;
    }

    public float getHocphi() {
        return hocphi;
    }

    public void setHocphi(final float hocphi) {
        this.hocphi = hocphi;
    }

    @Override
    public String toString() {
        return super.toString() + "SinhVienHTTT{" + "hocphi=" + hocphi + '}';
    }

    public void input() {
        super.input();
        System.out.print("Nhap hoc phi:");
        this.setHocphi(new Scanner(System.in).nextFloat());

    }

    public void SaveToFile() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("svhttt.dat"));
            for (int i = 0; i < 2; i++) {
                final SinhVienHTTT sv = new SinhVienHTTT();
                sv.input();
                final String Line = sv.getMasv() + "/" + sv.getHoTen() + "/" + sv.getNgaySinh() + "/" + sv.getGioiTinh()
                        + "/" + sv.getDiemTB() + "/" + sv.getHocphi();
                bw.write(Line);
                bw.newLine();
            }
        } catch (final IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (final IOException ex) {
                Logger.getLogger(SinhVienHTTT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }


    
}
