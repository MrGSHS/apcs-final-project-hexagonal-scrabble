/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author osimon8
 */
public class Space {
    Tile tile;
    int x,y;
    static int radius = 10;
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
     int radius = Space.getRadius();
     int yMod = (int)((Math.sqrt(3)/2.0)*radius), xMod = (int)((0.5)*radius);
     String val = ""+(tile!=null?tile.getVal():' ');
     Polygon hexagon = new Polygon();
     /*
     hexagon.addPoint(x+xMod, y-yMod);
     hexagon.addPoint(x+radius,y);
     hexagon.addPoint(x+xMod, y+yMod);
     hexagon.addPoint(x-xMod, y+yMod);
     hexagon.addPoint(x-radius, y);
     hexagon.addPoint(x-xMod, y-yMod);
             */ //flat facing up 
     hexagon.addPoint(x,y-radius);
     hexagon.addPoint(x+yMod,y-xMod);
     hexagon.addPoint(x+yMod,y+xMod);
     hexagon.addPoint(x,y+radius);
     hexagon.addPoint(x-yMod,y+xMod);
     hexagon.addPoint(x-yMod,y-xMod); //point up
     g.setColor(Color.white);
     g.fillPolygon(hexagon);
     g.setColor(Color.black);
     g.drawPolygon(hexagon);
     g.drawString(val,x-(int)((0.3)*radius),y+(int)(0.5*radius));
    }
    public static int getRadius(){
        return radius;
    }
}
