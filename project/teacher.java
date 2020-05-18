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
public class teacher extends NewClass {
    private String rank;
    public teacher(){
    }
    public teacher(String name,String addrese,String depratment,String rank ){
    super (name,addrese,depratment);
    this.rank=rank;
    }
    public void setRank(String rank)
    {
        this.rank=rank;
    }
      public String getRank()
    {
        return this.rank;
            }
      @Override
      public void print(){
      System.out.println(this.getName() +"|"+this.getAddrese()+"|"+this.getDepratment()+"|"+this.getRank());
      }
 
}
