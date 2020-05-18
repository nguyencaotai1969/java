/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Admin
 */
public class Student extends NewClass{
    private String ClassName;
    public Student(){}
    public Student(String name,String addrese,String depratment,String ClassName){
    super(name,addrese,depratment);
    this.ClassName=ClassName;
    }
    public void setClass(String Class){
    this.ClassName=ClassName;
    }
   
    public String getClassName(){
        return this.ClassName;
    }
     @Override
     public void print(){
         System.out.println(this.getName() +"|"+this.getAddrese()+"|"+this.getDepratment()+"|"+this.getClassName());
     }
}
