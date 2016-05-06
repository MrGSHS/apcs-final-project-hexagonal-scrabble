/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import java.awt.Graphics;

/**
 *
 * @author osimon8
 */
public class Space {
    Tile tile;
    int x,y;
    public Space(){
        tile=null;
        x=0;
        y=0;
    }
    public Space(Tile t){
        tile=t;
    }
    public Space(int x, int y, Tile t){
        tile=t;
        this.x=x;
        this.y=y;
    }
    public Tile getTile(){
        return tile;
    }
    public void setTile(Tile t){
        tile = t;
    }
    public String toString(){
        return "t";//tile.toString();
    }
    public void draw(Graphics g){
        if(tile!=null)
            tile.draw(x,y,g);
    }
}
