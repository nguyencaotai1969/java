/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


/**
 *
 * @author Admin
 */
public class bai5 extends JFrame{

    public bai5() {
        super("bai5");
    JPanel pn = new JPanel();
        pn.setLayout(new BorderLayout());
        JPanel pnNorh = new JPanel();
        JLabel lb = new JLabel("Giả Phương Trình Bậc 2");
        pnNorh.add(lb);
        pnNorh.setBackground(Color.red);
        pn.add(pnNorh,BorderLayout.NORTH);
        
    JPanel pnNorh1 = new JPanel();
        JLabel lb1 = new JLabel("Nhập a,b,c");
        pnNorh1.add(lb1);
        pnNorh1.add(lb1);
        pnNorh1.setBackground(Color.blue);
        pn.add(pnNorh1,BorderLayout.CENTER);

    JPanel pnNorh2 = new JPanel();
//        JLabel lb2 = new JLabel("Chọn Thao Tác");

        JButton btn2 = new JButton("Giải");
        JButton btn3 = new JButton("Xóa Trắng");
        JButton btn4 = new JButton("Thoát");
//        pnNorh2.add(lb2);
        pnNorh2.add(btn2);
        pnNorh2.add(btn3);
        pnNorh2.add(btn4);
        pnNorh2.setBackground(Color.GREEN);
        pn.add(pnNorh2,BorderLayout.SOUTH);
                
        
        
        
        
        getContentPane().add(pn);
    }
    public static void main(String[] args){
        bai5 b = new bai5();
        b.setDefaultCloseOperation(EXIT_ON_CLOSE);
        b.setVisible(true);
        b.setSize(400,400);

    }
}
