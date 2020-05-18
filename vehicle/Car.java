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
public class Car extends Vehicle{
    public String color;

   




    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    @Override
    public void input() {
        System.out.println("Nhap color");
         this.color  = new Scanner(System.in).nextLine();
        super.input(); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public void display() {
        System.out.println("gia chi cua color la :"+this.color);
        super.display(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
