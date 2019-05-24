
package javaproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.lang.Math;
public class Graph extends Canvas implements Runnable{
    private String f;
    private int mult;
    private int sinMult;
    private int div;
    private int add;
    private int base;
    private int exp;
    private Dots dots;
    private ImpDots imps;
    private boolean sine;
    private boolean hold;
    private Scanner key;
    public Graph(){
        setBackground(Color.WHITE);
        setVisible(true);
        f="f(x)=";
        mult=1;
        add=0;
        sinMult=1;
        base=-1;
        exp=1;
        div=1;
        sine=false;
        dots=new Dots();
        imps=new ImpDots();
        Scanner key=new Scanner(System.in);
        for(int i=0;i<800;i++){
            dots.add(new Dot(i,300));
            imps.add(new ImpDot(i,400));
        }
        new Thread(this).start();
        hold=false;
        setVisible(true);
    }
    public void update(Graphics window){
        paint(window);
    }
    public boolean isNum(char c){
        return (c>=48&&c<=57);
    }
    public void paint(Graphics window){
        window.drawLine(0, 300, 800, 300);
        window.drawLine(400, 0, 400, 600);
        f="f(x)=x";//will add scanner later for user input
        for(int i=5;i<f.length();i++){
            if(f.charAt(i)=='x'){
                if(f.charAt(i-1)!=' '&&f.charAt(i-1)!='+'&&f.charAt(i-1)!='='&&f.charAt(i-1)!='n'){
                    mult=Character.getNumericValue(f.charAt(i-1));
                    if(isNum(f.charAt(i-2))) mult+=10*Character.getNumericValue(f.charAt(i-2));;
                    if(f.charAt(i-2)=='-'||f.charAt(i-3)=='-') mult*=-1;
                    if(f.charAt(i-1)=='-'){ mult=-1;
                    if(isNum(f.charAt(i-2))) add=Character.getNumericValue(f.charAt(i-2));
                    if(isNum(f.charAt(i-3))) add+=10*Character.getNumericValue(f.charAt(i-3));
                    if(f.charAt(i-3)=='-'||f.charAt(i-4)=='-') add*=-1;}
                }
            
                if(f.charAt(i-1)=='+') add=Character.getNumericValue(f.charAt(i-2));
                if(i+1<f.length()&&f.charAt(i+1)=='+') add=Character.getNumericValue(f.charAt(i+2));
                if(f.charAt(i-2)=='+') add=Character.getNumericValue(f.charAt(i-3));
                if(i+1<f.length()&&f.charAt(i+1)=='^'){ 
                    exp=Character.getNumericValue(f.charAt(i+2));
                    if(i+3<f.length()&&f.charAt(i+3)=='/') div=Character.getNumericValue(f.charAt(i+4));}
                if(f.charAt(i-1)=='^') base=Character.getNumericValue(f.charAt(i-2));
                if(i+1<f.length()&&f.charAt(i+1)=='/'){
                    div=Character.getNumericValue(f.charAt(i+2));
                    if(i+3<f.length()&&(f.charAt(i+3)=='-'||f.charAt(i+3)=='+')){
                        add=Character.getNumericValue(f.charAt(i+4));
                        if(i+5<f.length()&&isNum(f.charAt(i+5))){
                            add*=10;
                            add+=Character.getNumericValue(f.charAt(i+5));
                        }
                        if(f.charAt(i+3)=='-') add*=-1;
                    }
                }
                if(i+3<f.length()&&isNum(f.charAt(i+3))){div*=10; div+=Character.getNumericValue(f.charAt(i+3));}
                
        }if(f.charAt(i-1)=='n'&&f.charAt(i-2)=='i'&&f.charAt(i-3)=='s'){//checks for the letters s-i-n
                sine=true;
                if(isNum(f.charAt(i-4))) sinMult=Character.getNumericValue(f.charAt(i-4));
            }
            
        }
        for(int i=0;i<dots.size();i++){
            if(sine)
                dots.get(i).setyPos((300-(add*25)-(int)(30*sinMult*Math.sin(.1*mult*((dots.get(i).getxPos()-400)/div)))));
            else if(base==-1)
                if(exp!=1)
                dots.get(i).setyPos((int)(300+(Math.pow((dots.get(i).getxPos()-400)/5,exp))*-1*((float)mult/div)-(add*25)));
                else dots.get(i).setyPos((int)(300+(dots.get(i).getxPos()-400)*-1*((float)mult/div)-(add*25)));
            else
                dots.get(i).setyPos((int)(300-(Math.pow(base,dots.get(i).getxPos()-400))*-1*((float)mult/div)-(add*25)));
            
            int thickness=2;//need to modify thickness as the spacing is usually greater than the dots can cover
            if(exp!=1) thickness=Math.abs((exp-1)*(dots.get(i).getxPos()-400))/3;
            else if(!sine)thickness=(2*mult)/div;
            else if(sine) thickness=Math.min(5*mult*sinMult,10*sinMult);//modification depends on the function used
            dots.get(i).setHeight(thickness);
            if(Math.abs(dots.get(i).getyPos()-300)<=thickness/4){
                for(int j=0;j<imps.size();j++){
                    if(!imps.get(j).isDraw()){
                        imps.get(j).setxPos(dots.get(i).getxPos()-imps.get(j).getRadius());
                        imps.get(j).setyPos(300-imps.get(j).getRadius());
                        imps.get(j).setDraw(true);
                        break;
                    }
                }
            }
        }
        dots.draw(window);
        window.setColor(Color.BLUE);
        imps.draw(window);
        window.setColor(Color.BLACK);
    }
    public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

