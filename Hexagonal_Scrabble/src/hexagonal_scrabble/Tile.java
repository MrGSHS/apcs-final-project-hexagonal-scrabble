/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JButton;

/**
 *
 * @author osimon8
 */
public class Tile extends JButton {
 private char val;
 private int points;
 private static int length = 50;
 public Tile(char val, int points){
     this.val = val;
     this.points = points;
 }
 public char getVal(){
     return val;
 }
 public void setVal(char newVal){
     val=newVal;
 }
 public int getPoints(){
     return points;
 }
 public void setPoints(char newPoints){
     val=newPoints;
 }
 public String toString(){
     return ""+val;
 }
 public static int length(){
     return length;
 }
 public void draw(int x, int y, Graphics g){
     g.setColor(Color.white);
     g.fillRect(x,y,length,length);
     g.setColor(Color.black);
     g.drawRect(x,y,length,length);
     Font f = g.getFont();
     f = f.deriveFont((float)40); 
     g.setFont(f); //set the font to a bigger size
     g.drawString(""+val,x+(int)(0.25*length),y+(int)(0.75*length));
 }
}

