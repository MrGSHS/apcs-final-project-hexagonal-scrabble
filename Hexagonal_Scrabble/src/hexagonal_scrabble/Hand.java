/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import java.util.ArrayList;
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
}
