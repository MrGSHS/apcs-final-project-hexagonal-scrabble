/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

/**
 *
 * @author osimon8
 */
public class Space {
    Tile tile;
    public Space(){
        tile=null;
    }
    public Space(Tile t){
        tile=t;
    }
    public Tile getTile(){
        return tile;
    }
    public void setTile(Tile t){
        tile = t;
    }
}
