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
public class Tile {
 private char val;
 private int points;
 public Tile(char val, int points){
     this.val = val;
     this.points = points;
 }
 public char getVal(){
     return val;
 }
 public void setVal(char newVal){
     val=newVal;
 }
 public int getPoints(){
     return points;
 }
 public void setPoints(char newPoints){
     val=newPoints;
 }
 public String toString(){
     return ""+val;
 }
}

