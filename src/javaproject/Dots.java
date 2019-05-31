/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
public class Dots implements ObjList{
    private List<Dot>dots;
    public Dots(int size){
        dots=new ArrayList<Dot>(size);
    }
    public Dots(){
        dots=new ArrayList<Dot>();
    }
    public void add(Object d){
        dots.add((Dot)d);
    }
    public void draw(Graphics window){
        for(int i=0;i<dots.size();i++){
            dots.get(i).draw(window);
        }
    }
    public int size(){
        return dots.size();
    }
    public void setColor(Color c){
        for(int i=0;i<dots.size();i++){
            dots.get(i).setColor(c);
        }
    }
    public Dot get(int a){
        return dots.get(a);
    }
}
