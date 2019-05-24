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
public class ImpDots implements ObjList{
    private List<ImpDot>impdots;
    public ImpDots(int size){
        impdots=new ArrayList<ImpDot>(size);
    }
    public ImpDots(){
        impdots=new ArrayList<ImpDot>();
    }
    public void add(Object d){
        impdots.add((ImpDot)d);
    }
    public void draw(Graphics window){
        for(int i=0;i<impdots.size();i++){
            if(impdots.get(i).isDraw()) impdots.get(i).draw(window);
        }
    }
    public int size(){
        return impdots.size();
    }
    public ImpDot get(int a){
        return impdots.get(a);
    }
}