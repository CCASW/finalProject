/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import javax.swing.JFrame;
import java.awt.Component;
public class JavaProject extends JFrame{
    
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    public JavaProject(){
        super("GRAPH");
        setSize(WIDTH,HEIGHT);
        Graph theGraph=new Graph();
        ((Component)theGraph).setFocusable(true);
        getContentPane().add(theGraph);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    public static void main(String[] args) {
        JavaProject run=new JavaProject();
    }
    
}
