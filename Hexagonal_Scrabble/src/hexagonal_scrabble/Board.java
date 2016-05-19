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
        setSpecials();
    }
    public Board(int startX,int startY){
        x=startX;
        y=startY;
        board = generate(x,y,Space.getRadius());
        setSpecials();
    }
    private Space[][] generate(int startX, int startY, int radius){//loops through and adds spaces in a hexagonal shape
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
                else if((ctr>=limit || half) && ctr>=6){
                x = oldX-(xMod*(ctr-(limit+1)));
                //oldX=x;
                if(ctr==6)
                    done=true;
                startIndex++;
                ctr--;
                }
            }
        }
        return spaces;
    }
    
    private void setSpecials(){
       board[0][21].setSpecial("TW");
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
