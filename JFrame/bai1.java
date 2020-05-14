/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class bai1 extends JFrame{

    public bai1() {
    super("DEMO WInDOW");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(400,300);
    setLocationRelativeTo(null);
    setVisible(true);
    }
    public static void main(String[] args){
        bai1 b1 = new bai1();
    }
 
}
