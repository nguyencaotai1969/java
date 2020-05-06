/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Book implements Serializable{
private int id;
private String authors;
private String title;
private String category;
List<Book> list = new ArrayList<>();

    public Book() {
    }

    public Book(int id, String authors, String title, String category) {
        this.id = id;
        this.authors = authors;
        this.title = title;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", authors=" + authors + ", title=" + title + ", category=" + category + '}';
    }
    public void addBooks(){
        System.out.println("Nhap SO Luong sach");
        int n = new Scanner(System.in).nextInt();
        Book b = null;
        for(int i = 0;i<n;i++){
            b = new Book();
            System.out.print("Nhap Id =");
            b.setId(new Scanner(System.in).nextInt());
            System.out.print("Nhap authors =");
            b.setAuthors(new Scanner(System.in).nextLine());
            System.out.print("Nhap title =");
            b.setTitle(new Scanner(System.in).nextLine());
           while(true){
            System.out.print("Nhap category(Tap Chi,KHXH,KHTN,Luan van) =");
            String cate = new Scanner(System.in).nextLine();
            if(cate !=null){
                String category = "Tap Chi, KHXH, KHTN, Luan van";
                category = Normalizer.normalize(category, Normalizer.Form.NFD);
                int idex = category.indexOf(cate); 
                if(idex>0){
                 b.setCategory(cate);
                     break;
                }
            }
           
           }
            list.add(b);
        }
    }
    public void addBookToFile(){
        
    ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(new FileOutputStream("books.dat"));
        for (Book book : list) {
            oos.writeObject(book);
        }    
        }catch(Exception e){
            e.printStackTrace();
        }finally{
        try {
            oos.close();
        } catch (IOException ex) {
        }
        }
           
    }
    public void printBooks(){
        ObjectInputStream ois = null;
    try{
        ois = new ObjectInputStream(new FileInputStream("books.dat"));
        Book b = null;
        try{ 
        while((b = (Book)ois.readObject()) != null){
        System.out.println(b);
        }
        }catch(Exception e){
        }
        }catch(Exception e){
        e.printStackTrace();
    }finally{
            try {
                ois. close();
            } catch (IOException ex) {
         }
    }
    }
  
    public void confirmDeleteFile(){
    try{
        File file = new File("books.dat");
        System.out.print("ban co muon xoa file khong chon 1 de xoa chon 2 bo qua");
        System.out.print("chon :");
        int so = new Scanner(System.in).nextInt();
        switch(so){
            case 1: 
                System.out.print("nhap duong dan thu muc");
                String dirPath = new Scanner(System.in).nextLine();
                dirPath += "/copy-"+file.getName();
                System.out.print(dirPath);
                backup(dirPath);
                file.delete();
                break;
            case 2: break;
        }
    }catch(Exception e){
        
    e.printStackTrace();
    }

    }
      public static void main(String[] args){
          String cate = "luan van";
          String str = "tap tri, KHXH, KHTN, luan van";
    Book b = new Book();
    b.addBooks();
    b.addBookToFile();
    b.printBooks();
    b.confirmDeleteFile();
    }

    private void backup(String dirPath) {
          ObjectInputStream ois = null;
          ObjectOutputStream oos = null;
    try{
        ois = new ObjectInputStream(new FileInputStream("books.dat"));
        oos = new ObjectOutputStream(new FileOutputStream(new File(dirPath)));
        Book b = null;
        try{ 
        while((b = (Book)ois.readObject()) != null){
//        System.out.println(b);
oos.writeObject(b);
        }
        }catch(Exception e){
        }
        }catch(Exception e){
        e.printStackTrace();
    }finally{
            try {
                ois. close();
                oos.close();
            } catch (IOException ex) {
         }
    }
    }
}
