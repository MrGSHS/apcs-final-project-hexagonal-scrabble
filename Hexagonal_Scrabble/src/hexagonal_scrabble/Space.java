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
    String special;
    static int radius = 20;
    public Space(){
        tile=null;
        x=0;
        y=0;
        special = null;
    }
    public Space(Tile t){
        tile=t;
    }
    public Space(int x, int y, Tile t){
        tile=t;
        this.x=x;
        this.y=y;
        special = null;
    }
    public Space(int x, int y, Tile t, String str){
        tile=t;
        this.x=x;
        this.y=y;
        special = str;
    }
    
    public Tile getTile(){
        return tile;
    }
    
    public String getSpecial(){
        return special;
    }
    
    public void setSpecial(String s){
        special = s;
    }
    
    public void setTile(Tile t){
        tile = t;
    }
    public String toString(){
        return (tile!=null)?""+tile.getVal():"e";//tile.toString();
    }
    public void draw(Graphics g){
        Color background=null;
        String val1 = ""+(tile!=null?tile.getVal():(special!=null)?special:' ');
        String val2 = ""+(tile!=null?tile.getPoints():"");
        background = Color.black;// visible if ifs fail
     if(special==null && tile == null) 
         background = Color.white;
     else if(tile!=null && tile.isPermanent())
         background = Color.white;
     else if(tile!=null && !tile.isPermanent())
         background = new Color(204,209,159);//beige
     else if(special.equals("Star")||special.equals("DW"))
        background = Color.red;
     else if(special.equals("DL"))
        background = Color.CYAN;
     else if(special.equals("TL"))
        background = Color.green;
     else if(special.equals("TW")){
        background = Color.orange;   
     }
    int yMod = (int)((Math.sqrt(3)/2.0)*radius), xMod = (int)((0.5)*radius);  
    Polygon hexagon = new Polygon();
    hexagon.addPoint(x,y-radius);
    hexagon.addPoint(x+yMod,y-xMod);
    hexagon.addPoint(x+yMod,y);
    hexagon.addPoint(x+yMod,y+xMod);
    hexagon.addPoint(x,y+radius);
    hexagon.addPoint(x-yMod,y+xMod);
    hexagon.addPoint(x-yMod,y-xMod); //point up
    g.setColor(background);
    g.fillPolygon(hexagon);
    g.setColor(Color.black);
    g.drawPolygon(hexagon);
    if(val2.equals("0"))
        g.setColor(new Color(192,3,3));
    g.drawString(val1,x-(int)((0.25)*radius),y+(int)(0.3*radius));
    g.drawString(val2,x+(int)((0.25)*radius),y+(int)(0.6*radius));
    }
    
    public boolean contains(double posX, double posY){
        int yMod = (int)((Math.sqrt(3)/2.0)*radius), xMod = (int)((0.5)*radius);
        if(posX>x+xMod||posX<x-xMod)
            return false;
        if(posY>y+radius||posY<y-radius)
            return false;
        if((posX>x+xMod && posY<y-yMod)||(posX>x+xMod && posY>y+yMod)||
           (posX<x-xMod && posY<y-yMod)||(posX<x-xMod && posY>y+yMod))
            return false;
        return true;
    }
    
    public static int getRadius(){
        return radius;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
   
}
