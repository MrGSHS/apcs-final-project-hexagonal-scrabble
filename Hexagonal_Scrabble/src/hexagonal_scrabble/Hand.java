/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Owen
 */
public class Hand {
    List<Tile> tiles;
    public final int MAX_SIZE = 7;
    
    public Hand(){
        tiles = new ArrayList<Tile>();
        for(int i = 0; i<MAX_SIZE; i++)
              tiles.add(TileBag.getInstance().next());
    }
    
    public void addTiles(int num){
        for(int i = 0; i<num; i++)
            tiles.add(TileBag.getInstance().next());
    }
    
    public void fill(){
       while(this.size()<MAX_SIZE && !TileBag.getInstance().isEmpty())
           tiles.add(TileBag.getInstance().next());
    }
    
    public int size(){
        return tiles.size();
    }
    public String toString(){
        String str="";
        for(Tile t : tiles)
             str+=t.getVal() + " ";
        return str;
    }
    public void draw(Graphics g){
        int x = 50, y=300;
        g.setColor(Color.PINK);
        g.fillRect(x-10,y-10,(Tile.length()+30)*7-10,Tile.length()+20);
        for(Tile t : tiles){
            t.draw(x,y,g);
            x+=Tile.length()+30;
        }
    }
    public Tile contains(double x, double y){
        for(Tile t : tiles){
                if(t.contains(x,y))
                    return t;
        }
        return null;
    }
    
    public void shuffle(){
        Collections.shuffle(tiles);
    }
}
