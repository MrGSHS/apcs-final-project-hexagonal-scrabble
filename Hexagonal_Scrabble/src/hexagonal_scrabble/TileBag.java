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
    private static int[] numEachLetter = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1,2};
    
    public TileBag(ArrayList<Tile> newTiles){
    tiles = newTiles;
}
    public TileBag(){
        tiles = makeTiles();
    }
    
    public String toString(){
        String str = "";
        for(Tile t : tiles)
            str += t.toString()+" ";
        return str;
    }

    
    private ArrayList<Character> fillBag(){ //creates a list of random chars according to numEachLetter
        //65-90 = 'A'-'Z'
        final int TOTAL_TILES=100;
        int[] totalLetters = numEachLetter;
        char[] temp = new char[TOTAL_TILES];
        int index = 0;
        for(int i =0; i<totalLetters.length-1; i++){//add amount of tiles specified in numEachLetter
            while(totalLetters[index]>0){
                temp[i] = (char)(index+65);
                totalLetters[index]--;
            }
            }
        for(int i = TOTAL_TILES-numEachLetter[26]; i<TOTAL_TILES; i++){
            temp[i] = 'b'; //assign blank tiles
        }
        ArrayList<Character> list  = new ArrayList<>();
        for(char c : temp){
            list.add(c);
        }
        Collections.shuffle(list);
        return list;
        }
    private ArrayList<Tile> makeTiles(){
        ArrayList<Character> chars = fillBag();
        ArrayList<Tile> tiles = new ArrayList<>();
        for(char c : chars){
            int points;
            if(c=='E'||c=='A'||c=='I'||c=='O'||c=='N'||c=='R'||c=='T'||c=='L'||
                    c=='S'||c=='U')
                points = 1;
            else if(c=='D'||c=='G')
                points = 2;
            else if(c=='B'||c=='C'||c=='M'||c=='P')
                points = 3;
            else if(c=='F'||c=='H'||c=='V'||c=='W'||c=='Y')
                points = 4;
            else if(c=='K')
                points = 5;
            else if(c=='J'||c=='X')
                points = 8;
            else if(c=='Q'||c=='Z')
                points = 10;
            else 
                points = 0;//blank tile
            tiles.add(new Tile(c,points));
        }
        return tiles;
    }
    }

