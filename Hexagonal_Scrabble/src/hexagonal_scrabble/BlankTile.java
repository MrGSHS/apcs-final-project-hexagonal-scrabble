/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

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
    public String toString(){
        return (t!=null)?t.toString():" ";
    }
    public char getVal(){
        return (t!=null)?t.getVal():' ';
}
    public void setVal(char s){
        t = new Tile(s,0);
    }
}
