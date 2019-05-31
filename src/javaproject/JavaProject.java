/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import javax.swing.JFrame;
import java.awt.Component;
public class JavaProject extends JFrame{
    
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    
    Graph theGraph;
    FramePanel form;
    public JavaProject(){
        super("GRAPH");
        setSize(WIDTH,HEIGHT);
        form=new FramePanel();
        getContentPane().add(form);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    public JavaProject(int a){
        super("GRAPH");
        setSize(800,600);
        theGraph=new Graph();
        form=new FramePanel();
        ((Component)theGraph).setFocusable(true);
        getContentPane().add(theGraph);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
  
    
    public static void main(String[] args) {
        OpeningFrame open=new OpeningFrame();
        open.go();
        JavaProject go=new JavaProject();
        JavaProject run=new JavaProject(1);
    }
    
}
