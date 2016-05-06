/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import java.awt.Graphics;

/**
 *
 * @author osimon8
 */
public class Board {
    Space[][] board = new Space[15][15];
    int x,y;
    public Board(){
        x=0;
        y=0;
        board = generate(x,y);
    }
    public Board(int startX,int startY){
        x=startX;
        y=startY;
        board = generate(x,y);
    }
    private Space[][] generate(int x, int y){//loops through and adds spaces in a hexagonal shape
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
    
    public void draw(int startX, int startY, Graphics g){
        int x = startX, y = startY;
        
    }
}
