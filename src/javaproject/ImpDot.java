/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

/**
 *
 * @author wainsteins8322
 */
import java.awt.Color;
import java.awt.Graphics;
public class ImpDot extends AbstractShape{
    private int xPos;
    private int yPos;
    private int radius;
    private boolean draw;
    public ImpDot(int x, int y){
        super(x,y);
        radius=4;
        xPos=this.getxPos();
        yPos=this.getyPos();
        draw=false;
    }
    public ImpDot(int x, int y, int r){
        super(x,y);
        radius=r;
        xPos=this.getxPos();
        yPos=this.getyPos();
        draw=false;
    }
    public void draw(Graphics window){
        window.fillOval(xPos,yPos,2*radius,2*radius);
    }
    /**
     * @return the xPos
     */
    public int getxPos() {
        return xPos;
    }
    /**
     * @param xPos the xPos to set
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * @return the yPos
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * @param yPos the yPos to set
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * @return the draw
     */
    public boolean isDraw() {
        return draw;
    }

    /**
     * @param draw the draw to set
     */
    public void setDraw(boolean draw) {
        this.draw = draw;
    }
}
