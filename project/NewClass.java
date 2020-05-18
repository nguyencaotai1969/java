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
public class NewClass {
    private String name;
    private String addrese;
    private String depratment;
    public NewClass(){
        
    }
    public NewClass(String name,String addrese,String depratment){
        this.name=name;
       this.addrese=addrese; 
        this.depratment=depratment;
    }
    public void setName(String name)
    {
        this.name=name;
    }
      public String getName()
    {
        return this.name;
            }
 
    public void setAddrese(String addrese)
    {
        this.addrese=addrese;
    }
       public String getAddrese()
    {
        return this.addrese;
     }
         public void setdepratment(String depratment)
    {
        this.depratment=depratment;
    }
    public String getDepratment()
    {
        return this.depratment;
     }
    public void print(){
    System.out.print(this.name+ " ||"+this.addrese + "||"+this.depratment);
    }
  
  
    
}
