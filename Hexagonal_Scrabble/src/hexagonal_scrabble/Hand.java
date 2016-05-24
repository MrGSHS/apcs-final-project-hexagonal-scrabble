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
    private boolean visible = true;
    
    public Hand(){
        tiles = new ArrayList<Tile>();
        for(int i = 0; i<MAX_SIZE; i++){
              Tile temp = TileBag.getInstance().next();
              tiles.add(temp);
              temp.setHandIndex(i);
        }
    }
    
    public void addTiles(int num){
        for(int i = 0; i<num; i++)
            tiles.add(TileBag.getInstance().next());
        setIndices();
    }
    
    public void fill(){
       while(this.size()<MAX_SIZE && !TileBag.getInstance().isEmpty())
           tiles.add(TileBag.getInstance().next());
       setIndices();
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
        if(visible){
            int x = 350, y=630;
            g.setColor(Color.PINK);
            g.fillRect(x-10,y-10,(Tile.length()+30)*7-10,Tile.length()+20);
            for(Tile t : tiles){
                t.draw(x,y,g);
                x+=Tile.length()+30;
            }
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
        setIndices();
    }
    
    public void deselect(){
        for(Tile t : tiles)
            t.setSelected(false);
    }
    
    public void replace(Tile old, Tile t){
         Collections.replaceAll(tiles,old,t);
         setIndices();
    }
    
    public Tile getSelected(){
        for(Tile t : tiles){
            if(t.getSelected())
                return t;
    }
        return null;
    }
    
    public List<Tile> getAllSelected(){
        List<Tile> temp = new ArrayList<>();
        for(Tile t : tiles){
            if(t.getSelected())
                temp.add(t);
    }
        return temp;
    }
    
    public void setVisible(boolean vis){
     visible = vis;
 }
    public boolean isVisible(){
     return visible;
 }
    public void setAllVisible(boolean vis){
        for(Tile t : tiles)
            t.setVisible(vis);
    }
    
    public Tile remove(int index){
        Tile t = tiles.remove(index);
        setIndices();
        return t;
    }
    
    public void remove(List<Tile> l){
        for(Tile t : l){
            if(tiles.contains(t))
                remove(t.getHandIndex());
        }
    }
    
    public void add(Tile t){
        tiles.add(t);
        setIndices();
    }
    
    public void add(List<Tile> ts){
        int size = ts.size();
        for(int i =0; i<size; i++){
            if(tiles.size()<7)
                tiles.add(ts.remove(0));
        }
    }
    
    private void setIndices(){
        for(int i = 0; i<tiles.size(); i++){
            Tile t = tiles.get(i);
            t.setHandIndex(i);
        }
    }
    
}
