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
 public Tile(char val){
     this.val = val;
 }
 public char getVal(){
     return val;
 }
 public void setVal(char newVal){
     val=newVal;
 }
}
