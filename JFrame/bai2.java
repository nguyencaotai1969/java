/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class bai2 extends JFrame{
    public bai2(){
        super("bai2");
        JPanel pnflow = new JPanel();
        pnflow.setLayout(new FlowLayout());
        pnflow.setBackground(Color.PINK);
        JButton btn = new JButton("FLOW_LAYOUT");
        JButton btn1 = new JButton("add cac control");
        JButton btn2 = new JButton("Tren 1 Dong");
        JButton btn3 = new JButton("Het Cho Chua");
        JButton btn4 = new JButton("thi xuong dong");
        pnflow.add(btn);
        pnflow.add(btn1);
        pnflow.add(btn2);
        pnflow.add(btn3);
        pnflow.add(btn4);
        Container c = getContentPane();
        c.add(pnflow);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setVisible(true);
        
    }
    public static void main(String[] args){
        bai2 b = new bai2();
    }
}
