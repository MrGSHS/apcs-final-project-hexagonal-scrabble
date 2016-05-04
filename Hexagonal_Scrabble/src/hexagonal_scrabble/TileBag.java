/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hexagonal_scrabble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author osimon8
 */
public class TileBag {
    List<Tile> tiles = new ArrayList<>();
    private static int[] numEachLetter = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1,2};
    
    public TileBag(List<Tile> newTiles){
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

    
    private List<Character> fillBag(){ //creates a list of random chars according to numEachLetter
        List<Character> list = new ArrayList<>();
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZb".toCharArray();
        for (int i = 0; i < numEachLetter.length; i++) {
            int count = numEachLetter[i];
            char character = chars[i];
            for (int a = 0; a < count; a++) {
                list.add(character);
            }
        }
        Collections.shuffle(list);
        return list;
        }
    private List<Tile> makeTiles(){
        List<Character> chars = fillBag();
        System.out.println("Characters: "+chars);
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
            Tile q;
            if(c=='b')
                  q = new BlankTile();
            else
            q = new Tile(c,points);
            tiles.add(q);
        }
        return tiles;
    }
    }

