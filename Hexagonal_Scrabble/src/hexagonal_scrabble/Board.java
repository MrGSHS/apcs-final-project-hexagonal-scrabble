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
public class Board {
    Space[][] board = new Space[15][15];
    public Board(){
        board = generate();
    }
    private Space[][] generate(){//loops through and adds spaces in a hexagonal shape
        Space[][] spaces = new Space[15][15];
        int startIndex = 7, ctr = 0;
        boolean half = false;
        for(int i = 0; i<spaces.length; i++){
            for(int j = 0; j<=ctr; j++){
                spaces[i][j+startIndex]=new Space(new Tile('T',4));
                
            }
            if(!half && ctr == 14)
                  half = true;
            ctr = (!half)?ctr+2:ctr-2;
            startIndex = (!half)?startIndex-1:startIndex+1;
        }
        return spaces;
    }
    public String toString(){
        String str = "";
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                str+= ((board[i][j]!=null)?board[i][j].toString():"N")+" ";
            }
            str+="\n";
        }
        return str;
    }
}
