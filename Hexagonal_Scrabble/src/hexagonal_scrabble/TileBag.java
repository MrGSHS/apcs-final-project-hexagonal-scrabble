/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hexagonal_scrabble;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author osimon8
 */
public class TileBag {
    ArrayList<Tile> tiles = new ArrayList<>();
    private static int[] numEachLetter = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1};
    public TileBag(ArrayList<Tile> newTiles){
    tiles = newTiles;
}
    public TileBag(){
        
    }
    private void randomize(){
        //65-90 = 'A'-'Z'
        int[] totalLetters = numEachLetter;
        char[] temp = new char[100];
        for(char i : temp){
            int guess = -1;
            while(guess!=-1 || temp[guess-65]==0){
            guess = (int)Math.random()*25+65;
            if(totalLetters[guess-65]>0){
                totalLetters[guess-65]--;
                i=(char)guess;
            }
            }
        
        }
    }
}
