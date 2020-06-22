/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package QLSinhvien;

import QLSinhvien.SinhVienDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author BMLaptop
 */
public class FrmQLSV extends JFrame implements ActionListener {

    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnRemove;
    private JButton btnClear;
    private JTextField txtMaSV;
    private JTextField txtHoTen;
    private JTextField txtTuoi;
    private DefaultListModel<SinhVien> model;
    private JList lstSinhVien;
    private ArrayList<SinhVien> listSV;

    public FrmQLSV(String title) throws HeadlessException {
        super(title);
        listSV = (ArrayList<SinhVien>) SinhVienDAO.getAll();
        initUI();
        addAction();
        
    }

    private void addAction() {
        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnRemove.addActionListener(this);
        btnClear.addActionListener(this);
        lstSinhVien.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {       
                SinhVien svUpdate = (SinhVien) lstSinhVien.getSelectedValue();
                txtMaSV.setText(String.valueOf(svUpdate.getMaSV()));
                txtMaSV.setEditable(false);
                txtHoTen.setText(svUpdate.getHoTen());
                txtTuoi.setText(String.valueOf(svUpdate.getTuoi()));
                System.out.print("ok");
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    private void initUI() {
        this.setSize(600, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel pnBorder = new JPanel(new BorderLayout());
        //bắt đầu vùng north
        JPanel pnNorth = new JPanel();
        Font fTitle = new Font("Tahoma", Font.BOLD, 20);
        JLabel lblTitle = new JLabel("THÔNG TIN SINH VIÊN");
        lblTitle.setFont(fTitle);
        lblTitle.setForeground(Color.red);
        pnNorth.add(lblTitle);
        pnBorder.add(pnNorth, BorderLayout.NORTH);
        //kết thúc vùng north

        //bắt đầu vùng south
        JPanel pnSouth = new JPanel();
        btnAdd = new JButton("Add");
        pnSouth.add(btnAdd);
        btnRemove = new JButton("Remove");
        pnSouth.add(btnRemove);
        btnUpdate = new JButton("Update");
        pnSouth.add(btnUpdate);
        btnClear = new JButton("Clear");
        pnSouth.add(btnClear);
        pnBorder.add(pnSouth, BorderLayout.SOUTH);
        //kết thúc vùng south

        //bắt đầu vùng west 
        JPanel pnWest = new JPanel();
        Border borderWest = BorderFactory.createLineBorder(Color.RED);
        TitledBorder titledBorder = new TitledBorder(borderWest, "Danh sách sv");
        pnWest.setBorder(titledBorder);
        model = new DefaultListModel();
        for (SinhVien sv : listSV) {
            model.addElement(sv);
        }

        lstSinhVien = new JList();
        lstSinhVien.setModel(model);
//        lstSinhVien.setPreferredSize(new Dimension(150, 200));
        pnWest.add(new JScrollPane(lstSinhVien));
        pnBorder.add(pnWest, BorderLayout.WEST);
        //kết thúc vùng west

        //Bắt vùng center
        JPanel pnCenter = new JPanel();
        JPanel pnLabel = new JPanel();
        pnLabel.setLayout(new BoxLayout(pnLabel, BoxLayout.Y_AXIS));
        JLabel lblMaSV = new JLabel("Mã SV: ");
        JLabel lblHoTen = new JLabel("Họ Tên: ");
        JLabel lblTuoi = new JLabel("Tuổi: ");
        pnLabel.add(lblMaSV);
        pnLabel.add(Box.createVerticalStrut(25));
        pnLabel.add(lblHoTen);
        pnLabel.add(Box.createVerticalStrut(25));
        pnLabel.add(lblTuoi);
        JPanel pnTextField = new JPanel();
        pnTextField.setLayout(new BoxLayout(pnTextField, BoxLayout.Y_AXIS));
        txtMaSV = new JTextField(20);
        txtHoTen = new JTextField(20);
        txtTuoi = new JTextField(20);
        pnTextField.add(txtMaSV);
        pnTextField.add(Box.createVerticalStrut(25));
        pnTextField.add(txtHoTen);
        pnTextField.add(Box.createVerticalStrut(25));
        pnTextField.add(txtTuoi);
        pnCenter.add(pnLabel);
        pnCenter.add(pnTextField);
        pnBorder.add(pnCenter, BorderLayout.CENTER);

        //Kết thúc vùng center
        this.add(pnBorder);
    }

    public static void main(String[] args) {
        new FrmQLSV("Quản lý sinh viên").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SinhVienDAO SinhVienDao = new SinhVienDAO();
        if (e.getActionCommand().equals("Clear")) {
            System.out.println("Clear");
        } else if (e.getActionCommand().equals("Add")) {            
//            int masv = Integer.parseInt(txtMaSV.getText());
            String hoTen = txtHoTen.getText().trim();
            int tuoi = Integer.parseInt(txtTuoi.getText());
             SinhVien svNew = null;
            if(SinhVienDao.inster(new SinhVien(0,hoTen,tuoi) )){
                 svNew = new SinhVien(SinhVienDAO.getLastID(),hoTen,tuoi);
                 JOptionPane.showMessageDialog(rootPane, "Thêm sinh viên "+hoTen+"thành công!");
                  model.addElement(svNew);
            }else{
                 JOptionPane.showMessageDialog(rootPane, "Thêm sinh viên khong thành công!");
            }
        } else if (e.getActionCommand().equals("Remove")) {
            int index = lstSinhVien.getSelectedIndex();
            if(index >=0){
            SinhVien sv = (SinhVien) lstSinhVien.getSelectedValue(); 
            if(SinhVienDao.delete(sv.getMaSV())){    
                JOptionPane.showMessageDialog(rootPane, "Xoa Thanh Cong Sinh Vien"+sv.getHoTen());
                 model.remove(index);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Xoa khong Thanh Cong Sinh Vien"+sv.getHoTen());
            }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Bạn Phải Trọn 1 người để xóa");
            }
            
        }else if (e.getActionCommand().equals("Update")) {
           int index = lstSinhVien.getSelectedIndex();
           if(index >=0){
               SinhVien svupdate = new SinhVien(Integer.parseInt(txtMaSV.getText().trim()),txtHoTen.getText().trim(),Integer.parseInt(txtTuoi.getText().trim()));
               if(SinhVienDao.Update(svupdate)){
                   JOptionPane.showMessageDialog(rootPane, "Sua Thanh Cong");
                   model.set(index,svupdate);
               }else{
                   JOptionPane.showMessageDialog(rootPane, "chua sua duoc");
               }
           }else{
                JOptionPane.showMessageDialog(rootPane, "Bạn Phải Trọn 1 người để Sua");
           }
        }
    }

}
