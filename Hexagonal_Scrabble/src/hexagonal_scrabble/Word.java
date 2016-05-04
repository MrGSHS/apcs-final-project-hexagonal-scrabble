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
        return true;
    }
    
}
