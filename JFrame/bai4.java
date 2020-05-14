/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class bai4 extends JFrame {
    public bai4(){
        super("bai4");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setVisible(true);
        JPanel pn = new JPanel();
             pn.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
             JLabel jlb = new JLabel("North"); 
             pnNorth.add(jlb);
            pnNorth.setBackground(Color.red);
            pnNorth.setForeground(Color.pink);
            pn.add(pnNorth,BorderLayout.NORTH);
        JPanel pnEast = new JPanel();
             JLabel jlb1 = new JLabel("East");
             pnEast.add(jlb1);
            pnEast.setBackground(Color.blue);
            pnEast.setForeground(Color.green);
            pn.add(pnEast,BorderLayout.EAST);
        JPanel pnSouth = new JPanel();
             JLabel jlb2 = new JLabel("South");  
             pnSouth.add(jlb2);
            pnSouth.setBackground(Color.green);
            pnSouth.setForeground(Color.yellow);
            pn.add(pnSouth,BorderLayout.SOUTH);
        JPanel pnSwest = new JPanel();
             JLabel jlb3 = new JLabel("Swest");    
             pnSwest.add(jlb3);
            pnSwest.setBackground(Color.pink);
            pnSwest.setForeground(Color.yellow);
            pn.add(pnSwest,BorderLayout.WEST);
        JPanel pnCenter = new JPanel();
            JLabel jlb4 = new JLabel("Center");  
            pnCenter.add(jlb4);
            pnCenter.setBackground(Color.ORANGE);
            pnCenter.setForeground(Color.yellow);
            pnCenter.add(jlb);  
            pn.add(pnCenter,BorderLayout.CENTER);
           getContentPane().add(pn);
        

        
    }
    public static void main(String[] args){
        bai4 b = new bai4();
    }
}
