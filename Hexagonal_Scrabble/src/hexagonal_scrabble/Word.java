/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import java.util.List;

/**
 *
 * @author osimon8
 */
public class Word {
    List<Tile> word;
    public Word(List<Tile> word){
        this.word = word;
    }
    public boolean isValid(){
        return Dictionary.contains(this.toString());
    }
    public String toString(){
        String s ="";
        for(Tile t : word)
            s+=t.toString();
        return s;
    }
    public int points(){
        int sum =0 ;
        for(Tile t : word)
            sum+=t.getPoints();
        return sum;
    }
    
}
