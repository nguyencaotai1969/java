/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class bai3 extends JFrame{
        public bai3(){
            super("bai3");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(200,300);
            setVisible(true);
            JPanel pnbox = new JPanel();
            pnbox.setLayout(new BoxLayout(pnbox,BoxLayout.Y_AXIS));
            Font font = new Font("Arial",Font.BOLD/Font.ITALIC,25);
            JButton btn1 = new JButton("Button");
            btn1.setBackground(Color.red);
            btn1.setForeground(Color.blue);
            btn1.setFont(font);
            pnbox.add(btn1);
            
            JButton btn2 = new JButton("X_AXIT");
            btn2.setBackground(Color.green);
            btn2.setForeground(Color.ORANGE);
            btn2.setFont(font);
            pnbox.add(btn2);
            
            JButton btn3 = new JButton("Y_AXIT");
            btn3.setBackground(Color.PINK);
            btn3.setForeground(Color.yellow);
            btn3.setFont(font);
            pnbox.add(btn3);
            
            Container c = getContentPane();
            c.add(pnbox);
        }
        public static void main(String[] agrs){
            bai3 b = new bai3();
        }
}
