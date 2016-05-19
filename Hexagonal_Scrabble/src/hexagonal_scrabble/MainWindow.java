/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import javafx.application.Application;
import javafx.stage.Stage;
import javax.swing.JFrame;

/**
 *
 * @author osimon8
 */
public class MainWindow extends Application{
    public static void main(String[] args){
    JFrame frame = new JFrame("Hexagonal Scrabble");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new MainMenu());
    frame.pack();
    frame.setVisible(true);
            }
    
    
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
