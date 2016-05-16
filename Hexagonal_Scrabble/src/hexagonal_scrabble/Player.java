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
public class Player {
    private Hand hand;
    private int number;
    
    public Player(int number){
        this.number=number;
        hand = new Hand();
    }
    
    public Hand getHand(){
        return hand;
    }
    
    public int getNumber(){
        return number;
    }
    
}
