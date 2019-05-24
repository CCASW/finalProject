/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.awt.Graphics;
public interface ObjList {
    public void add(Object obj);
    public void draw(Graphics window);
    public int size();
    public Object get(int index);
}