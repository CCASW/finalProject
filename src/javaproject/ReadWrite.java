/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class ReadWrite {
    private FramePanel f;
    public ReadWrite(){
        f=new FramePanel();
    }
    public String go(){
        FramePanel f=new FramePanel();
        try(FileOutputStream FOut=new FileOutputStream("persistence.dat");
                ObjectOutputStream OOut=new ObjectOutputStream(FOut)){
            String A=f.func;
            OOut.writeObject(A);
        }catch (Exception e){}
        
        try(FileInputStream FIn=new FileInputStream("persistence.dat");
                ObjectInputStream OIn=new ObjectInputStream(FIn)){
            String A=(String)OIn.readObject();
            return A;
        }catch (Exception e){}
        return "";
    }
}
