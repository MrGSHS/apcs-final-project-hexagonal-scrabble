/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author osimon8
 */
public class Word {
    List<Space> word;
    int id;
    /*
    public Word(List<Tile> word){
        this.word = word;
    }
    */
    
    public Word(List<Space> words){
        this.word=words;
        id = getID();
    }
    
    public Space get(int index){
        if(index<word.size())
            return word.get(index);
        return null;
    }
    
    public boolean isValid(){
        return Dictionary.getInstance().contains(this.toString());
    }
    public String toString(){
        String str ="";
        for(Space s : word)
            str+=s.getTile().toString();
        return str;
    }
    public int points(){
        int sum =0;
        List<Integer> specials =new LinkedList<>();
        specials.add(1);
        for(Space s : word){
            int letterMod=1;
            String special = s.getSpecial();
            if(special==null)
                letterMod=1;//do nothing
            else if(special.equals("DL"))
                letterMod=2;
            else if(special.equals("TL"))
                letterMod=3;
            else if(special.equals("DW")||special.equals("Star"))
                specials.add(0,2);
            else if(special.equals("TW"))
                specials.add(0,3);
            sum+=letterMod*s.getTile().getPoints();
        }
        sum*=specials.get(0);
        if(notPermanent()&&length()>=7)
            return sum+50;
        else
            return sum;
    }
    
    public int length(){
        return word.size();
    }
    
    public boolean notPermanent(){
        for(Space s : word){
            if(s.getTile().isPermanent())
                return false;
        }
        return true;
    }
    public int getID(){
        int sum=0;
        for(Space s : word)
            sum+=(int)Math.sqrt(s.getTile().getVal()*s.getX()+s.getY());
        return sum/2;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Word other = (Word) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    public int hashCode(){
        return id*4;
    }

}
