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
 * @author Owen
 */
public class BlankTile extends Tile{
    Tile t;
    public BlankTile(){
        super(' ',0);
        t=null;
    }
    
    public BlankTile(int x, int y){
     super(x,y,' ',0);
     t=null;
 }
    
    public String toString(){
        return (t!=null)?t.toString():" ";
    }
    public char getVal(){
        return (t!=null)?t.getVal():' ';
}
    public void setVal(char s){
        t = new Tile(s,0);
    }
    public void setVal(Tile tile){
        int oldX = this.getX(), oldY = this.getY();
        t = tile;
        t.setPosition(oldX,oldY);
    }
    public void draw(Graphics g){
        if(t!=null)
            t.draw(g, new Color(192,3,3));
        else
            super.draw(g);
 }
}
