/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import javax.swing.JFrame;

/**
 *
 * @author osimon8
 */
public class MainWindow {
    public static void main(String[] args){
    JFrame frame = new JFrame("Hexagonal Scrabble");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new MainMenu());
    frame.pack();
    frame.setVisible(true);
            }
}
