/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import static hexagonal_scrabble.Space.radius;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

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
        /*
        Space[][] spaces = new Space[23][21];
        int startIndex = 10, ctr = 0, internalCtr=-1, x = startX, y= startY;
        int xMod = (int)((Math.sqrt(3)/2.0)*radius), yMod = (int)((0.5)*radius);
        boolean half = false;
        for(int i = 0; i<spaces.length; i++){
            for(int j = 0; j<=ctr; j++){
                spaces[i][j+startIndex]=new Space(x,y,null);
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
    */
        Space[][] spaces = new Space[50][50];
        int startIndex = 21, ctr = 6, internalCtr=-1, x = startX, y= startY;
        int xMod = (int)((Math.sqrt(3)/2.0)*radius), yMod = (int)((0.5)*radius);
        int limit = 15;
        boolean half = false, done = false;
        int oldX=0;
        for(int i = 0; i<spaces.length; i++){
            if(!done){
                for(int j = 0; j<ctr; j++){
                    spaces[i][j+startIndex]=new Space(x,y,null);
                    x+=2*xMod;
                }
                y+=yMod+radius;
                if(ctr<limit && !half){
                x = startX-(xMod*(ctr-5));
                ctr++;
                startIndex--;
                if(ctr==limit){
                    oldX = x;
                    half=true;
                }
                }
                else if((ctr>=limit || half) && ctr>6){
                x = oldX-(xMod*(ctr-(limit+1)));
                //oldX=x;
                ctr--;
                if(ctr==6)
                    done=true;
                startIndex++;
                }
            }
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
                if(s!=null)
                    s.draw(g);
            }
         }
    }
    
    public Space contains(double posX, double posY){
        for(Space[] row : board){
            for(Space s : row){
                if(s!=null && s.contains(posX,posY))
                    return s;
            }
        }
            return null;
    }
    
    public void setSpace(int r, int c, Tile t){
        if(board[r][c]!=null)
            board[r][c].setTile(t);
    }
    
    public void setSpace(Space s, Tile t){
        findSpace(s).setTile(t);
    }
    
    public List<Space> getAdjacentSpaces(int x, int y){
        int radius = Space.getRadius();
        int xMod = (int)((Math.sqrt(3)/2.0)*radius), yMod = (int)((0.5)*radius);
        List<Space> spaces = new ArrayList<>();
        spaces.add(findSpace(x-(2*xMod),y-(2*radius)));
        spaces.add(findSpace(x+(2*xMod),y-(2*radius)));
        spaces.add(findSpace(x+(2*xMod),y));
        spaces.add(findSpace(x+(2*xMod),y+(2*radius)));
        spaces.add(findSpace(x-(2*xMod),y+(2*radius)));
        spaces.add(findSpace(x-(2*xMod),y));
        return spaces;
    }
    
    public Space findSpace(int x,int y){
        for(Space[] row : board){
            for(Space s : row){
                if(s.getX()==x && s.getY()==y)
                    return s;
            }
        }
        return null;
    }
    
    public Space findSpace(Space s){
        return findSpace(s.getX(),s.getY());
    }
    
    public List<Word> getWords(int x, int y){//unfinished
        Space base = findSpace(x,y);
        List<Space> spaces = getAdjacentSpaces(x,y);
        for(int i = 0; i<spaces.size(); i++){
            Space curr = spaces.get(i);
            
        }
        return null;
    }
    
    public void makePermanent(){
        for(Space[] row : board){
            for(Space s : row){
               if(s!=null && s.getTile()!=null)
                   s.getTile().setPermanent(true);
            }
        }
    }
    public int getPoints(){
        int sum=0;
        for(Space[] row : board){
            for(Space s : row){
               if(s!=null && s.getTile()!=null && !s.getTile().isPermanent())
                   sum+=s.getTile().getPoints();
            }
        }
        return sum;
    }
    
}
