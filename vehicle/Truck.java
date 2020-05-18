/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Truck extends Vehicle{
    public int truckload;

    public int getTruckload() {
        return truckload;
    }

    public void setTruckload(int truckload) {
        this.truckload = truckload;
    }
    @Override
    public void input() {
        System.out.println("moi nhap truckload");
        this.truckload = new Scanner(System.in).nextInt();
        super.input(); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void display() {
        System.out.println("gia chi cua truckload la :"+this.truckload);
        super.display(); //To change body of generated methods, choose Tools | Templates.
    }
}
