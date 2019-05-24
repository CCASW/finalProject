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
public abstract class AbstractShape {
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color col;
    public AbstractShape(int x, int y){
        xPos=x;
        yPos=y;
        height=2;
        width=2;
        col=Color.BLACK;
    }
    public AbstractShape(int x, int y, int w, int h, Color c){
        xPos=x;
        yPos=y;
        width=w;
        height=h;
        col=c;
    }
   // public abstract void draw(Graphics window);

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
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the col
     */
    public Color getCol() {
        return col;
    }

    /**
     * @param col the col to set
     */
    public void setCol(Color col) {
        this.col = col;
    }
}
