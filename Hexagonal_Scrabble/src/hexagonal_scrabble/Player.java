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
    private int points;
    private String name;
    
    public Player(int number){
        this.number=number;
        hand = new Hand();
        points = 0;
        name = "Player " + number;
    }
    
    public Player(int number, String name){
        this.number=number;
        hand = new Hand();
        points = 0;
        this.name = name;
    }
    
    public Hand getHand(){
        return hand;
    }
    
    public int getNumber(){
        return number;
    }
    
    public int getPoints(){
        return points;
    }
    
    public void addPoints(int points){
        this.points+=points;
    }
        
    public String getName(){
        return name;
    }
    
}
