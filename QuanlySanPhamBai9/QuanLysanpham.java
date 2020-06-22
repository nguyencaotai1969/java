/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanlySanPhamBai9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLysanpham extends JFrame implements ActionListener,MouseListener{ 
        Entitycategory cateupdate;
        JButton btnNewCate ;
        JButton btnUpdateNewCate ;
        JButton btnRemoveNewCate ;
         JButton btnNew;
        JButton btnSave;
        JButton btnRemove;     
    JList listDanhMuc;
    CategoryDao categoryDao = new CategoryDao();
    ProductDao productDao = new ProductDao();
    JComboBox<Entitycategory> cbCategory ;
    JTextField txtProductID ;
    JTextField txtProductName;
    JTextField txtProductPrice ;
    JTextField txtQuantity ;
    JTextArea txtDescription ;
    DefaultListModel<Entitycategory> listModelCategory = new DefaultListModel<>();
    JTable tabelSanPham ;
    public QuanLysanpham() {
    }

    public QuanLysanpham(String title) throws HeadlessException {
        super(title);
        initUI();
        addAction();
        loadDataToCategory();
        loadDataToJTabelProduct();
    }
    private void initUI(){
        this.setSize(700,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JMenuBar menuBar = new JMenuBar();
        //tao 1 cay menu dau tien->file
        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);
        this.setJMenuBar(menuBar);
        //ket thuc gan menu
        
        //bat dau layout tong
        JPanel pnBorder = new JPanel(new BorderLayout(5,5));
        
        
        //tao vung not truoc 
        JPanel pnNorth = new JPanel();
        JLabel lblTitle = new JLabel("quan ly San Pham");
        lblTitle.setFont(new Font("Tahoma",Font.BOLD,40));
        lblTitle.setForeground(Color.blue);
        pnNorth.add(lblTitle);
        pnBorder.add(pnNorth,BorderLayout.NORTH);
        //ket thuc vung north
        this.add(pnBorder);
          //tao vung west truoc 
        JPanel pnWest = new JPanel();
        JPanel pnBorderWest= new JPanel(new BorderLayout());
        //vung center
         listDanhMuc = new JList();//khoi tao model sau
        
        
        listDanhMuc.setPreferredSize(new Dimension(250,400));
        JPanel pnCenterWest = new JPanel();
        Border boderDanhMuc = BorderFactory.createLineBorder(Color.red);
        TitledBorder titleborderdanhmuc = new TitledBorder(boderDanhMuc,"danh Muc san Pham");
        pnCenterWest.setBorder(titleborderdanhmuc);
//        pnCenterWest.setPreferredSize(new Dimension(100,500));
        pnCenterWest.add(listDanhMuc);
        pnBorderWest.add(pnCenterWest,BorderLayout.CENTER);
        JPanel pnsouthWest = new JPanel();
         btnNewCate = new JButton("New");
         btnUpdateNewCate = new JButton("Update");
         btnRemoveNewCate = new JButton("Remove");
        pnsouthWest.add(btnNewCate);
        pnsouthWest.add(btnUpdateNewCate);
        pnsouthWest.add(btnRemoveNewCate);
        pnBorderWest.add(pnsouthWest,BorderLayout.SOUTH);
        pnBorderWest.add(pnCenterWest,BorderLayout.CENTER);
        pnWest.add(pnBorderWest,BorderLayout.CENTER);
        pnBorder.add(pnWest,BorderLayout.WEST);
        //ket thuc vung west
        // bat dau vung center tong
        //dung 1 boxlayout lam tong 
        JPanel pnBoxCenter = new JPanel();
        tabelSanPham = new JTable();
        pnBoxCenter.setLayout(new BoxLayout(pnBoxCenter,BoxLayout.Y_AXIS));
        //vung phia tren chua 1 borderlayout
        JPanel pnBorderVungtren = new JPanel(new BorderLayout());
       
        JLabel lblThongTinChiTiet = new JLabel("thong tin chi tiet");
        lblThongTinChiTiet.setFont(new Font("Tahoma",Font.BOLD,16));
        JPanel pnTitle = new JPanel();
        pnTitle.add(lblThongTinChiTiet);
        
        // tao jtabel 
        JPanel pnJTable = new JPanel();
       
        pnJTable.add(tabelSanPham);
        
        pnBorderVungtren.add(pnTitle,BorderLayout.NORTH);
        pnBorderVungtren.add(new JScrollPane(tabelSanPham),BorderLayout.CENTER);
        pnBoxCenter.add(pnBorderVungtren);
        //tap panel x-Axits chua vung trai Jlabel va vung phai JText
        JPanel pnFormInput = new JPanel();
        pnFormInput.setLayout(new BoxLayout(pnFormInput, BoxLayout.X_AXIS));
        
        JPanel pnLeftLabel = new JPanel();
        pnLeftLabel.setLayout(new BoxLayout(pnLeftLabel, BoxLayout.Y_AXIS));
        JLabel lblCategory = new JLabel("Category: ");
        JLabel lblProductID = new JLabel("Product ID: ");
        JLabel lblProductName = new JLabel("Product Name: ");
        JLabel lblProductPrice = new JLabel("Product Price: ");
        JLabel lblQuantity = new JLabel("Quantity: ");
        JLabel lblDescription = new JLabel("Description: ");
        
        //pnLeftLabel.add(Box.createVerticalStrut(10));
        pnLeftLabel.add(lblCategory);
        pnLeftLabel.add(Box.createVerticalStrut(10));
        pnLeftLabel.add(lblProductID);
        pnLeftLabel.add(Box.createVerticalStrut(15));
        pnLeftLabel.add(lblProductName);
        pnLeftLabel.add(Box.createVerticalStrut(20));
        pnLeftLabel.add(lblProductPrice);
        pnLeftLabel.add(Box.createVerticalStrut(10));
        pnLeftLabel.add(lblQuantity);
        pnLeftLabel.add(Box.createVerticalStrut(10));
        pnLeftLabel.add(lblDescription);
        
        JPanel pnRightText = new JPanel();
        pnRightText.setLayout(new BoxLayout(pnRightText, BoxLayout.Y_AXIS));
        cbCategory = new JComboBox<>();
         txtProductID = new JTextField(20);
         txtProductName = new JTextField(20);
         txtProductPrice = new JTextField(20);
         txtQuantity = new JTextField(20);
         txtDescription = new JTextArea(3, 20);
        pnRightText.add(Box.createVerticalStrut(10));
        pnRightText.add(cbCategory);
        pnRightText.add(Box.createVerticalStrut(10));
        pnRightText.add(txtProductID);
        pnRightText.add(Box.createVerticalStrut(10));
        pnRightText.add(txtProductName);
        pnRightText.add(Box.createVerticalStrut(10));
        pnRightText.add(txtProductPrice);
        pnRightText.add(Box.createVerticalStrut(10));
        pnRightText.add(txtQuantity);
        pnRightText.add(Box.createVerticalStrut(10));
        pnRightText.add(txtDescription);
        
        pnFormInput.add(pnLeftLabel);
        pnFormInput.add(pnRightText);
        pnBoxCenter.add(pnFormInput);
       
       
        JPanel pnTheButton = new JPanel();
         btnNew = new JButton("New");
         btnSave = new JButton("Save");
         btnRemove = new JButton("Remove");        
        pnTheButton.add(btnNew);
        pnTheButton.add(btnSave);
        pnTheButton.add(btnRemove);
        pnBoxCenter.add(pnTheButton);
        
        
        
        pnBorder.add(new JPanel().add(pnBoxCenter),BorderLayout.CENTER);
                
        // ket thuc vung center tong
        
//        menuBar.add(menu);
    }
    private void addAction(){
        btnNewCate.addActionListener(this);
        btnUpdateNewCate.addActionListener(this);
        btnRemoveNewCate.addActionListener(this);
        listDanhMuc.addMouseListener(this);
    }
    public static void main(String[] args){
        new QuanLysanpham("ql sv").setVisible(true);
    }

    private void loadDataToCategory() {
        listModelCategory.clear();
        for(Entitycategory c :categoryDao.getAll()){
            listModelCategory.addElement(c);
              cbCategory.addItem(c);
        }
        listDanhMuc.setModel(listModelCategory);
        
    }
   private void loadDataToJTabelProduct() {
        String columnNames[] = {"category","productId","producname","unitprice","quantity","Description"};
//        Object[][] rowData = {{"1","Den","2000","3","Abc"}};
        DefaultTableModel tbnModelProduct = new DefaultTableModel();
        tbnModelProduct.setColumnIdentifiers(columnNames);
        Object[] rowData = null;
        for(Entityproduct c :productDao.getAll()){
            System.out.println(c);
            Entitycategory cate = categoryDao.get(c.getcategoryid()).get();
             rowData = new Object[]{cate.getName(),c.getProductid(),c.getProductname(),String.format("%.0f",c.getUniprice()),c.getQuantity(),c.getDescription()};
          tbnModelProduct.addRow(rowData);
        }
         
        tabelSanPham.setModel(tbnModelProduct);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnNewCate) {
            frmcategory Frmcategory = new frmcategory();
            Frmcategory.setVisible(true);
            this.dispose();
        } else if(e.getSource()==btnUpdateNewCate){
             if(cateupdate !=null){
                  frmcategory Frmcategory = new frmcategory(cateupdate);
                    Frmcategory.setVisible(true);
                    this.dispose();
             }else{
                 JOptionPane.showMessageDialog(rootPane,"Ban Phai Chon it nhat 1 danh muc de sua");
             }
        }else if(e.getSource()==btnRemoveNewCate){
            if(cateupdate !=null){
                if(categoryDao.delete(cateupdate)){
                         while (true) {
                            int response = JOptionPane.showConfirmDialog(null,
                                    "Ban co muon trac chan xoa","xoa", JOptionPane.YES_NO_OPTION);
                            if (response == JOptionPane.YES_OPTION) {
                                 JOptionPane.showMessageDialog(rootPane,"Xoa Thanh Cong");
                                    loadDataToCategory();
                                break;
                            } else if (response == JOptionPane.NO_OPTION) {
                                JOptionPane.showMessageDialog(null, "You shall not pass!", "Minor Detected",
                                        JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                            JOptionPane.showMessageDialog(null, "You must answer the question.", "Aversion Detected",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                 
                }else{
                    JOptionPane.showMessageDialog(rootPane,"Ban Phai chon 1 muc de xoa");
                }
           
             }else{
                 JOptionPane.showMessageDialog(rootPane,"Ban Phai Chon it nhat 1 danh muc de xoa");
             }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       cateupdate = (Entitycategory) listDanhMuc.getSelectedValue();  
       cateupdate.getId();
      
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
    
}
