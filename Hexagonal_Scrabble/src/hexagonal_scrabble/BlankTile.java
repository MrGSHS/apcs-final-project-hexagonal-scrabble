/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import java.awt.Color;
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
    
    @Override
    public String toString(){
        return (t!=null)?t.toString():" ";
    }
    @Override
    public char getVal(){
        return (t!=null)?t.getVal():' ';
}

    /**
     *sets a new value for the contained tile
     * @param s
     */
    @Override
    public void setVal(char s){
        t = new Tile(getX(),getY(),s,0);
    }
    public void setVal(Tile tile){
        int oldX, oldY;
        if(t!=null){
            oldX = t.getX();
            oldY = t.getY();
        }
        else{
             oldX = this.getX();
             oldY = this.getY();
        }
        t = new Tile(oldX,oldY,tile.getVal(),0);
        t.setSelected(tile.getSelected());
    }
    @Override
    public void draw(Graphics g){
        if(t!=null){
            t.draw(g, new Color(192,3,3));
        }
        else{
            super.draw(g);
        }
 }
    
    @Override
    public Tile getTile(){
        return t;
    }
    
    @Override
    public Tile setTile(Tile t){
     this.t = t;
     return t;
    }
    
    @Override
    public void setPosition(int x,int y){
        if(t!=null){
            super.setPosition(x,y);
            t.setPosition(x,y);
        }
        else 
            super.setPosition(x,y);
    }
     
    @Override
    public void setSelected(boolean b){
        if(t!=null)
            t.setSelected(b);
        else 
            super.setSelected(b);
    }
    
    @Override
    public boolean getSelected(){
        if(t!=null)
            return t.getSelected();
        else 
            return super.getSelected();
    }
    
    @Override
    public void setHandIndex(int i){
        super.setHandIndex(i);
        if(t!=null)
            t.setHandIndex(i);
    }
    
    public boolean contains(int x, int y){
        if(t!=null)
            return t.contains(x,y);
        else 
            return super.contains(x,y);
    
    }
    
    
}
