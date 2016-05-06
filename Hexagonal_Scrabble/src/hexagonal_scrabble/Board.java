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
    private Space[][] generate(){
        Space[][] spaces = new Space[15][15];
        for(int i = 0; i<spaces.length; i++){
            for(int j = 0; j<spaces[0].length; j++){
                spaces[i][j]=new Space(new Tile('T',4));
                //System.out.println(spaces[i][j]);
            }
        }
        return spaces;
    }
    public String toString(){
        String str = "";
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                str+= (board[i][j]!=null)?board[i][j].toString():"null";
            }
            str+="\n";
        }
        return str;
    }
}
