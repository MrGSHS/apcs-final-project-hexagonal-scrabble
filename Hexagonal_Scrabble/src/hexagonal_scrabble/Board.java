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
        board = generate(x,y,Space.getRadius());
    }
    public Board(int startX,int startY){
        x=startX;
        y=startY;
        board = generate(x,y,Space.getRadius());
    }
    private Space[][] generate(int startX, int startY, int radius){//loops through and adds spaces in a hexagonal shape
        Space[][] spaces = new Space[23][21];
        int startIndex = 10, ctr = 0, internalCtr=-1, x = startX, y= startY;
        int xMod = (int)((Math.sqrt(3)/2.0)*radius), yMod = (int)((0.5)*radius);
        boolean half = false;
        for(int i = 0; i<spaces.length; i++){
            for(int j = 0; j<=ctr; j++){
                spaces[i][j+startIndex]=new Space(x,y,TileBag.getInstance().next());
                x+=2*radius;
            }
            if(!half && ctr == 18){
                  half = true;
                  internalCtr=0;
            }
            if(internalCtr>=0 && internalCtr<4){
             internalCtr++;
             ctr=20;
             startIndex=0;
            }
            else{
            ctr = (!half)?ctr+2:ctr-2;
            startIndex = (!half)?startIndex-1:startIndex+1;
            x = (!half)?startX-(xMod*ctr):startX+(ctr*xMod);
            }
            if (ctr==20 && internalCtr==4){
                ctr=18;
                startIndex=1;
            }
            y+=2*radius;
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
    
    public void draw(Graphics g){ //(x,y) = top left corner 
        for(Space[] row : board){
            for(Space s : row){
                try{
                s.draw(g);
                }
                catch (NullPointerException e){
                    //was null space
                }
            }
         }
    }
}
