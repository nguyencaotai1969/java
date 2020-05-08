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
public class test {
  public static  void main(String[] agrs){
    
      int a = new Scanner(System.in).nextInt();
      switch(a){
          case 1 :
            Car car = new Car();
            car.input();

            Truck truck = new Truck();
            truck.input();
             
             
  }
  }  
}
