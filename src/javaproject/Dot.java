package javaproject;

import java.awt.Color;
import java.awt.Graphics;
public class Dot extends AbstractShape{
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color col;
    public Dot(int x, int y){
        super(x,y,2,2,Color.BLACK);
    }
    public void setColor(Color c){
        col=c;
    }
    public Dot(int x, int y, int w, int h, Color c){
        super(x,y,w,h,c);
    }
    public void draw(Graphics window){
        window.setColor(col);
        window.fillRect(getxPos(),getyPos(),getWidth(),getHeight());
    }
}
