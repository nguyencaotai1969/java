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
public class Vehicle implements IVehicle{
       
    
    private String maker;
    private String model;
    private double price;

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "maker=" + maker + ", model=" + model + ", price=" + price + '}';
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public Vehicle(String maker, String model, double price) {
        this.maker = maker;
        this.model = model;
        this.price = price;
    }

    public Vehicle() {
        this.maker="abc";
        this.model="xyz";
        this.price=3;
    }
    @Override
    public void input() {
           System.out.print("Nhap Ma maker:");
        this.setMaker(new Scanner(System.in).nextLine());
           System.out.print("Nhap Ma model:");
        this.setModel(new Scanner(System.in).nextLine());
           System.out.print("Nhap Ma price:");
        this.setPrice(new Scanner(System.in).nextDouble());
    }

    @Override
    public void display() {
       
    }
}
