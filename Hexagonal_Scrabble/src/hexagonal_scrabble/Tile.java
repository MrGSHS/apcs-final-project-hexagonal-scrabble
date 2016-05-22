/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author osimon8
 */
public class Tile{
 private char val;
 private int points,x,y;
 private static int length = 50;
 private boolean selected = false;
 private boolean visible = true;
 private boolean permanent = false;
 int handIndex=-1;
 public Tile(char val, int points){
     this.val = val;
     this.points = points;
 }
 
 public Tile(int x, int y, char val, int points){
     this.val = val;
     this.points = points;
     this.x = x;
     this.y = y;
 }
 
 public Tile(int x, int y, char val, int points, int hand){
     this.val = val;
     this.points = points;
     this.x = x;
     this.y = y;
     handIndex = hand;
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
 
 public Tile getTile(){
     return this;
 }

 
 public void draw(int x, int y, Graphics g){ //draw at different point
     this.x=x;
     this.y=y;
     draw(g);
 }
 
 public void draw(int x, int y, Graphics g, Color c){ //draw at different point
     this.x=x;
     this.y=y;
     draw(g, c);
 }
 
 public void setPosition(int x, int y){
     this.x=x;
     this.y=y;
 }
 
  public void draw(Graphics g){
     this.draw(g, Color.black);
 }
  
  public void draw(Graphics g, Color c){
     if(visible){
        Color border = (this.getSelected())?Color.green:Color.black;
        g.setColor(Color.white);
        g.fillRect(x,y,length,length);
        g.setColor(border);
        g.drawRect(x,y,length,length);
        Font oldF = g.getFont();
        Font newF = oldF.deriveFont((float)40);
        g.setColor(c);
        g.setFont(newF); //set the font to a bigger size
        if(val=='Q') //Q must be drawn differently to fit
            g.drawString(""+val,x+(int)(0.05*length),y+(int)(0.75*length));
        else
           g.drawString(""+val,x+(int)(0.2*length),y+(int)(0.75*length));
        g.setFont(oldF); //reset font to prevent issues in future paints
        if(points==10) //a point value of 10 must be drawn differently to fit
            g.drawString(""+points,x+(int)(0.65*length),y+(int)(0.9*length)); 
        else
           g.drawString(""+points,x+(int)(0.8*length),y+(int)(0.9*length)); 
     }
 }
 
 public boolean contains(double x, double y){
     return((x>=this.x && x<=this.x+length)&&(y>=this.y && y<=this.y+length));
 }
 
 public int getX(){
     return x;
 }
 
 public int getY(){
     return x;
 }
 
 public Tile setTile(Tile t){
     if(t!=null){
        val = t.getVal();
        x = t.getVal();
        y = t.getVal();
        points = t.getVal();
     }
     return this;
    }
 public void setSelected(boolean state){
     selected = state;
     }
 
public boolean getSelected(){
    return selected;
}
 public void setVisible(boolean vis){
     visible = vis;
 }
 public boolean isVisible(){
     return visible;
 }
 public void setHandIndex(int index){
     handIndex= index;
     }
 
public int getHandIndex(){
    return handIndex;
}
public void setPermanent(boolean perm){
     permanent = perm;
 }
 public boolean isPermanent(){
     return permanent;
 }
}

