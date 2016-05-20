/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import static hexagonal_scrabble.Space.radius;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
        int startIndex = 21, ctr = 6, x = startX, y= startY;
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
       board[0][26].setSpecial("TW");
       board[9][12].setSpecial("TW");
       board[9][26].setSpecial("TW");
       board[18][21].setSpecial("TW");
       board[18][26].setSpecial("TW");
       board[9][19].setSpecial("Star");
       board[8][18].setSpecial("DL");
       board[8][21].setSpecial("DL");
       board[10][18].setSpecial("DL");
       board[10][21].setSpecial("DL");
       board[7][17].setSpecial("TL");
       board[7][23].setSpecial("TL");
       board[11][17].setSpecial("TL");
       board[11][23].setSpecial("TL");
       board[6][16].setSpecial("DW");
       board[6][25].setSpecial("DW");
       board[12][16].setSpecial("DW");
       board[12][25].setSpecial("DW");
       board[5][20].setSpecial("DL");
       board[5][22].setSpecial("DL");
       board[13][20].setSpecial("DL");
       board[13][22].setSpecial("DL");
       board[4][19].setSpecial("TL");
       board[4][24].setSpecial("TL");
       board[14][19].setSpecial("TL");
       board[14][24].setSpecial("TL");
       board[1][23].setSpecial("DW");
       board[17][23].setSpecial("DW");
       
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
        spaces.add(findSpace(x-(xMod),y-(2*radius)));
        spaces.add(findSpace(x+(xMod),y-(2*radius)));
        spaces.add(findSpace(x+(2*xMod),y));
        spaces.add(findSpace(x+(xMod),y+(2*radius)));
        spaces.add(findSpace(x-(xMod),y+(2*radius)));
        spaces.add(findSpace(x-(2*xMod),y));
        return spaces;
    }
    
    public Space findSpace(int x,int y){
        for(Space[] row : board){
            for(Space s : row){
                if(s!=null && s.contains(x,y))//&& s.getX()==x && s.getY()==y)
                    return s;
            }
        }
        return null;
    }
    
    public Space findSpace(Space s){
        return findSpace(s.getX(),s.getY());
    }
    
    public List<Word> getWords(){//unfinished
        Set<Word> total = new HashSet<>();
        List<Word> words=null;
        for(Space[] row : board){
            for(Space s : row){
                if(s!=null && s.getTile()!=null && !s.getTile().isPermanent()){
                    int x = s.getX(), y =s.getY();
                    Space base = findSpace(x,y);
                    words = new LinkedList<>();
                    List<Space> s0 = getAllAdjacentSpaces(x,y,0);
                    List<Space> s1 = getAllAdjacentSpaces(x,y,1);
                    List<Space> s2 = getAllAdjacentSpaces(x,y,2);
                    List<Space> s3 = getAllAdjacentSpaces(x,y,3);
                    List<Space> s4 = getAllAdjacentSpaces(x,y,4);
                    List<Space> s5 = getAllAdjacentSpaces(x,y,5);
                    s0.add(base);
                    s0.addAll(s3);
                    s1.add(base);
                    s1.addAll(s4);
                    s5.add(base);
                    s5.addAll(s2);
                    words.add(new Word(s0));
                    words.add(new Word(s1));
                    words.add(new Word(s5));
                    int length = words.size();
                    for(int i = 0; i<length; i++){
                        if(words.get(i).length()==0)
                            words.remove(i);
                    } 
                    total.addAll(words);
                }
                 }
        }
        List<Word> finalW = new ArrayList(total);
        int size=finalW.size();
        for(int i =0; i<size; i++){
            if(i<finalW.size() && finalW.get(i).length()<2)
                finalW.remove(finalW.get(i));
        }
        return finalW;
    }
    
    public Space getAdjacentSpace(int x, int y, int i){
        if(i<=5 && findSpace(x,y)!=null)
            return getAdjacentSpaces(x,y).get(i);
        return null;
    }
    
    public List<Space> getAllAdjacentSpaces(int x, int y, int i){
        List<Space> spaces = new LinkedList<>();
        if(i<=5 && findSpace(x,y)!=null){
            Space adjSpace = getAdjacentSpace(x,y,i);
            if(adjSpace!=null && adjSpace.getTile()!=null){
                spaces.add(adjSpace);
                List<Space> newSpaces = getAllAdjacentSpaces(adjSpace.getX(),adjSpace.getY(),i);
                if(newSpaces!=null)
                    spaces.addAll(newSpaces);
                if(i==0||i==1||i==5)
                    Collections.reverse(spaces);
            }
        }
        return spaces;
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
    
    public List<Tile> recall(){
        List<Tile> tiles = new ArrayList<>();
        for(Space[] row : board){
            for(Space s : row){
               if(s!=null && s.getTile()!=null && !s.getTile().isPermanent()){
                 tiles.add(s.getTile());
                 s.setTile(null);
               }
            }
        }
        return tiles;
    }
    
}
