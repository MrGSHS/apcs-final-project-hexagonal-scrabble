/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author osimon8
 */
public class Tile {
 private char val;
 private int points;
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
 public void draw(int x, int y, Graphics g){
     int radius = Space.getRadius();
     int yMod = (int)((Math.sqrt(3)/2.0)*radius), xMod = (int)((0.5)*radius);
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
     g.drawPolygon(hexagon);
 }
}

