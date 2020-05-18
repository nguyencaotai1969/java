/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class Class {
    private String name;
    private ArrayList<Student> studentList = new ArrayList();
    private int numOfStudent;
    private teacher advisor;
    
    public Class(){
    
}
    public Class(String name,int numOfStudent,ArrayList<Student> studentList){
        this.name= name;
        this.numOfStudent = numOfStudent;
    }
    public void setName(String name){
    this.name = name;
            }
    public String getName(){
        return this.name;
    }
     public void setNumOfStudent(int numOfStudent){
    this.numOfStudent = numOfStudent;
            }
    public int getnumOfStudent(){
        return this.numOfStudent;
    }
    public void setAdvisor(teacher advisor){
    this.advisor = advisor;
            }
    public teacher getAdvisor(){
        return this.advisor;
    }
    public void print(){
        System.out.println("Ten lop:"+ this.getName() + "si so lo : "+ this.getnumOfStudent());
        System.out.println("Giao vien chu nhiem :");
        this.getAdvisor().print();
        System.out.println("danh sach lop nhu sau");
        for(int i = 0;i<this.getnumOfStudent();i++){
            Student student = studentList.get(i);
            
        }
                
    }
}
